# A Common-Sense Guide to Data Structures and Algorithms — Java Exercises

Java implementations of the coding exercises from *A Common-Sense Guide to Data Structures and Algorithms* by Jay Wengrow.

## Data Structures

| Class | Description |
|---|---|
| `LinkedList` | Singly linked list with reverse and mid-node deletion |
| `DoublyLinkedList` | Doubly linked list |
| `BinarySearchTree` | BST with insert, search, and greatest-value lookup |
| `Trie` | Prefix tree with insert, autocorrect, and word collection |
| `Graph` / `Vertex` | Adjacency-list graph with BFS, BFS search, and shortest path |

## Algorithms

All implemented in `Main.java`:

- **Search:** linear search, ordered-array search, binary search
- **Hashing:** array intersection, first duplicate, missing letter, first non-repeated character
- **Sorting:** temperature ordering (counting sort variant), greatest-product-of-three
- **Recursion:** character count, even filter, triangular numbers, grid paths, add-until-100, Golomb sequence, memoized unique paths
- **Greedy / optimization:** max stock profit, greatest product of two numbers, largest consecutive sequence, find missing number

## Tech

- Java 21
- Maven

## Structure

```
src/main/java/org/example/
├── Main.java               # All standalone algorithm exercises
├── LinkedList.java
├── DoublyLinkedList.java
├── Node.java
├── BinarySearchTree.java
├── Tree.java / TreeNode.java
├── Trie.java / TrieNode.java
├── Graph.java / Vertex.java
└── Player.java             # Helper record used in hash table exercises
```
