package org.example;

import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

public class Main {
    static void main() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(1);
        bst.insert(5);
        bst.insert(9);
        bst.insert(2);
        bst.insert(4);
        bst.insert(10);
        bst.insert(6);
        bst.insert(3);
        bst.insert(8);

        bst.print();
        System.out.println("Max Node Value --> " + bst.findGreatestValue(bst.root));
    }

    private static List<Integer> arrayGenerator(int size, boolean sorted) {
        Random random = new Random();
        List<Integer> result = new ArrayList<>();
        while (result.size() < size) {
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

    private static List<Integer> intersectionArray(List<Integer> array1, List<Integer> array2) {
        int steps = 0;
        List<Integer> biggest = array1.size() >= array2.size() ? array1 : array2;
        List<Integer> smallest = array1.size() < array2.size() ? array1 : array2;
        HashMap<Integer, Boolean> reference = new HashMap<>();

        for (Integer num : biggest) {
            steps++;
            reference.put(num, true);
        }

        List<Integer> result = new ArrayList<>();
        for (Integer num : smallest) {
            steps++;
            if (reference.containsKey(num)) {
                result.add(num);
            }
        }
        System.out.printf("Number of steps taken: %d", steps);
        return result;
    }

    private static String findFirstDuplicated(List<String> strings) {
        int steps = 0;
        HashMap<String, Boolean> reference = new HashMap<>();
        for (String str : strings) {
            steps++;
            if (!reference.containsKey(str)) {
                reference.put(str, true);
                continue;
            }

            System.out.printf("Number of steps taken: %d", steps);
            return str;
        }

        System.out.printf("Number of steps taken: %d", steps);
        return null;
    }

    private static String missingFromAlphabet(String str) {
        HashMap<String, Boolean> reference = new HashMap<>();

        for (Character letter : str.toCharArray()) {
            reference.put(letter.toString(), true);
        }

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (Character letter : alphabet.toCharArray()) {
            if (!reference.containsKey(letter.toString())) {
                return letter.toString();
            }
        }

        return null;
    }

    private static String firdFirstNonDuplicated(String hay) {
        HashMap<Character, Integer> reference = new HashMap<>();

        for (Character cr : hay.toCharArray()) {
            reference.put(cr, reference.getOrDefault(cr, 0) + 1);
        }

        for (Character cr : hay.toCharArray()) {
            if (reference.get(cr) == 1) {
                return cr.toString();
            }
        }

        return null;
    }

    private static String reverseString(String toReverse) {
        System.out.printf("String to reverse: %s%n", toReverse);

        SelfStack<Character> stack = new SelfStack<>();
        for (Character ch : toReverse.toCharArray()) {
            stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (stack.read() != null) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static class SelfStack<T> {
        private final List<T> stack;

        public SelfStack() {
            stack = new ArrayList<>();
        }

        public void push(T value) {
            stack.add(value);
        }

        public T read() {
            if (stack.isEmpty()) return null;

            return stack.getLast();
        }

        public T pop() {
            if (stack.isEmpty()) return null;

            return stack.removeLast();
        }
    }

    private static void recursivePrint(List<Object> list, int depth) {
        for (Object obj : list) {
            if (obj instanceof Integer) {
                System.out.printf("%s%d%n", "-----".repeat(depth), obj);
                continue;
            }

            if (obj instanceof List<?>) {
                recursivePrint((List<Object>) obj, depth + 1);
            }
        }
    }

    // Recursion Chapter 11
    private static int recursivelyCountNumberOfCharacters(List<String> strings, int index) {
        if (index >= strings.size()) return 0;

        return strings.get(index).length() + recursivelyCountNumberOfCharacters(strings, index+1);
    }

    private static List<Integer> recursivelyFilterOnlyEven(List<Integer> nums, List<Integer> evens, int index){
        if (index >= nums.size()) return evens;
        if (nums.get(index) % 2 == 0) evens.add(nums.get(index));
        return recursivelyFilterOnlyEven(nums, evens, index + 1);
    }

    private static int findTriangularNumberOnPosition(int position){
        if (position <= 0) return 0;
        return findTriangularNumberOnPosition(position - 1) + position;
    }

    private static int findFirstXRecursively(String str, int index){
        if (index >= str.length()) return -1;
        if (str.charAt(index) == 'x') return index;
        return findFirstXRecursively(str, index + 1);
    }

    private static int findNumberOfShortestPaths(int rows, int cols){
        if (rows == 1 || cols == 1) return 1;
        return findNumberOfShortestPaths(rows - 1, cols) + findNumberOfShortestPaths(rows, cols - 1);
    }

    private static int addUntil100(List<Integer> array){
        if (array.isEmpty()) return 0;
        int sum = addUntil100(array.subList(1, array.size() - 1));
        if (array.getFirst() + sum > 100){
            return sum;
        }
        return array.getFirst() + sum;
    }

    private static int golomb(int n, Map<Integer, Integer> memo){
        if (n == 1) return 1;
        if (!memo.containsKey(n)){
            memo.put(n, 1 + golomb(n - golomb(golomb(n - 1, memo), memo), memo));
        }
        return memo.get(n);
    }

    private static int uniquePaths(int rows, int cols, Map<int[], Integer> memo){
        if (rows == 1 || cols == 1) return 1;
        if (!memo.containsKey(new int[]{rows, cols})){
            memo.put(new int[]{rows, cols}, uniquePaths(rows - 1, cols, memo) + uniquePaths(rows, cols - 1, memo));
        }

        return memo.get(new int[]{rows, cols});
    }

    private static int greatestProductOfAnyThreeNumbers(List<Integer> array){
        array.sort(Comparator.reverseOrder());
        return array.get(0) * array.get(1) * array.get(2);
    }

    private static int findMissingNumber(List<Integer> array){
        array.sort(Comparator.naturalOrder());
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) != i) return i;
        }

        return -1;
    }

    private static int findGreatestNumberNSquared(List<Integer> array){
        int max = 0;
        for (int i = 0; i < array.size(); i++) {
            for (Integer integer : array) {
                if (array.get(i) > integer && array.get(i) > max) {
                    max = array.get(i);
                } else if (integer > max) {
                    max = integer;
                }
            }
        }
        return max;
    }

    private static int findGreatestNumberNLogN(List<Integer> array){
        array.sort(Comparator.reverseOrder());
        return array.getFirst();
    }

    private static int findGreatestNumberN(List<Integer> array){
        int max = array.getFirst();
        for (Integer num : array){
            if (num > max) max = num;
        }

        return max;
    }

    
}
