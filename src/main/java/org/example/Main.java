package org.example;

import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Main {
    static void main() {
//        int size = 100;
//        boolean sorted = true;
//        List<Integer> hay = arrayGenerator(size, sorted);
//        System.out.printf("%nResult --> %d", binarySearch(hay, new Random().nextInt(0, size)));

        List<Object> list = List.of(1, 2, 3, List.of(4,5,6), 7, List.of(8, List.of(9, 10, 11, List.of(12, 13, 14))), List.of(15, 16, 17, 18, 19, List.of(20, 21, 22, List.of(23, 24, 25, List.of(26, 27, 29), 30, 31)),32), 33);

//        System.out.printf("%nResult --> %s", reverseString("Car"));
        recursivePrint(list, 1);
    }

    private static List<Integer> arrayGenerator(int size, boolean sorted) {
        Random random = new Random();
        List<Integer> result = new ArrayList<>();
        while(result.size() < size){
            result.add(random.nextInt(0, size));
        }

        return sorted ? result.stream().sorted().toList() : result;
    }

    private static int searchOrderedArray(List<Integer> hay, Integer needle) {
        int steps = 0;
        for (int i = 0; i < hay.size(); i++) {
            steps++;
            System.out.printf("%nNumber of steps taken: %d", steps);

            if (hay.get(i) < needle) continue;
            if (hay.get(i) > needle) break;

            return i;
        }
        return -1;
    }

    private static int searchArray(List<Integer> hay, Integer needle) {
        int steps = 0;
        for (int i = 0; i < hay.size(); i++) {
            steps++;
            System.out.printf("%nNumber of steps taken: %d", steps);
            if (hay.get(i).equals(needle)) return i;
        }
        return -1;
    }

    private static int binarySearch(List<Integer> hay, Integer needle) {
        int l = 0, r = hay.size() - 1;
        int steps = 0;

        while (l <= r) {
            steps++;
            System.out.printf("%nNumber of steps taken: %d", steps);
            int m = (int) Math.ceil((double) (l + r) / 2);

            if (hay.get(m).equals(needle)) return m;
            if (hay.get(m) < needle) {
                l = m + 1;
                continue;
            }

            r = m - 1;
        }

        return -1;
    }

    private static List<Integer> intersectionArray(List<Integer> array1, List<Integer> array2){
        int steps = 0;
        List<Integer> biggest = array1.size() >= array2.size() ? array1 : array2;
        List<Integer> smallest = array1.size() < array2.size() ? array1 : array2;
        HashMap<Integer, Boolean> reference = new HashMap<>();

        for (Integer num : biggest){
            steps++;
            reference.put(num, true);
        }

        List<Integer> result = new ArrayList<>();
        for (Integer num : smallest){
            steps++;
            if (reference.containsKey(num)){
                result.add(num);
            }
        }
        System.out.printf("Number of steps taken: %d", steps);
        return result;
    }

    private static String findFirstDuplicated(List<String> strings){
        int steps = 0;
        HashMap<String, Boolean> reference = new HashMap<>();
        for (String str : strings){
            steps++;
            if (!reference.containsKey(str)){
                reference.put(str, true);
                continue;
            }

            System.out.printf("Number of steps taken: %d", steps);
            return str;
        }

        System.out.printf("Number of steps taken: %d", steps);
        return null;
    }

    private static String missingFromAlphabet(String str){
        HashMap<String, Boolean> reference = new HashMap<>();

        for (Character letter : str.toCharArray()){
            reference.put(letter.toString(), true);
        }

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (Character letter : alphabet.toCharArray()){
            if (!reference.containsKey(letter.toString())){
                return letter.toString();
            }
        }

        return null;
    }

    private static String firdFirstNonDuplicated(String hay){
        HashMap<Character, Integer> reference = new HashMap<>();

        for (Character cr : hay.toCharArray()){
            reference.put(cr, reference.getOrDefault(cr, 0) + 1);
        }

        for (Character cr : hay.toCharArray()){
            if (reference.get(cr) == 1){
                return cr.toString();
            }
        }

        return null;
    }

    private static String reverseString(String toReverse){
        System.out.printf("String to reverse: %s%n", toReverse);

        SelfStack<Character> stack = new SelfStack<>();
        for (Character ch : toReverse.toCharArray()){
            stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (stack.read() != null){
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static class SelfStack<T> {
        private final List<T> stack;

        public SelfStack(){
            stack = new ArrayList<>();
        }

        public void push(T value){
            stack.add(value);
        }

        public T read(){
            if (stack.isEmpty()) return null;

            return stack.getLast();
        }

        public T pop(){
            if (stack.isEmpty()) return null;

            return stack.removeLast();
        }
    }

    private static void recursivePrint(List<Object> list, int depth){
        for (Object obj : list){
            if (obj instanceof Integer){
                System.out.printf("%s%d%n", "-----".repeat(depth), obj);
                continue;
            }

            if (obj instanceof List<?>){
                recursivePrint((List<Object>) obj, depth+1);
            }
        }
    }
}
