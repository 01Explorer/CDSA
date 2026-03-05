package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Trie {
    public TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode currentNode = root;
        for (Character ch : word.toCharArray()){
            if (currentNode.children.containsKey(ch)){
                currentNode = currentNode.children.get(ch);
                continue;
            }
            TrieNode newChar = new TrieNode();
            currentNode.children.put(ch, newChar);
            currentNode = newChar;
        }
        currentNode.children.put('*', null);
    }

    public void print() {
        System.out.println("root");
        List<Map.Entry<Character, TrieNode>> entries = new ArrayList<>(root.children.entrySet());
        entries.sort(Map.Entry.comparingByKey());
        for (int i = 0; i < entries.size(); i++) {
            printTrie(entries.get(i).getKey(), entries.get(i).getValue(), "", i == entries.size() - 1);
        }
    }

    private void printTrie(char ch, TrieNode node, String prefix, boolean isLast) {
        String connector = isLast ? "└── " : "├── ";
        System.out.println(prefix + connector + (ch == '*' ? "(*)" : ch));
        if (node == null) return;
        List<Map.Entry<Character, TrieNode>> entries = new ArrayList<>(node.children.entrySet());
        entries.sort(Map.Entry.comparingByKey());
        String childPrefix = prefix + (isLast ? "    " : "│   ");
        for (int i = 0; i < entries.size(); i++) {
            printTrie(entries.get(i).getKey(), entries.get(i).getValue(), childPrefix, i == entries.size() - 1);
        }
    }

    public void printKeys(TrieNode node){
        TrieNode current = node != null ? node : root;
        for (Map.Entry<Character, TrieNode> child : current.children.entrySet()){
            System.out.println(child.getKey());
            if (child.getKey() != '*'){
                printKeys(child.getValue());
            }
        }
    }

    public List<String> autocorrect(String word){
        TrieNode current = root;
        String foundSoFar = "";

        for (Character ch : word.toCharArray()){
            if (current.children.containsKey(ch)){
                foundSoFar = foundSoFar.concat(ch.toString());
                current = current.children.get(ch);
                continue;
            }

            return collectAllWords(current, foundSoFar, new ArrayList<>());
        }

        return List.of(word);
    }

    private List<String> collectAllWords(TrieNode node, String word, List<String> words) {
        TrieNode currentNode = node != null ? node : root;

        for (Map.Entry<Character, TrieNode> entry : currentNode.children.entrySet()){
            if (entry.getKey() == '*'){
                words.add(word);
                continue;
            }
            collectAllWords(entry.getValue(), word + entry.getKey().toString(), words);
        }

        return words;
    }
}
