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
//        List<Player> basketballPlayers = List.of(
//                new Player("Jill", "Huang", "Gators"),
//                new Player("Janko", "Barton", "Sharks"),
//                new Player("Wanda", "Vakulskas", "Sharks"),
//                new Player("Jill", "Moloney", "Gators"),
//                new Player("Luuk", "Watkins", "Gators")
//        );
//
//        List<Player> footballPlayers = List.of(
//                new Player("Hanzla", "Radozti", "32ers"),
//                new Player("Tina", "Watkins", "Barleycorns"),
//                new Player("Alex", "Patel", "32ers"),
//                new Player("Jill", "Huang", "Barleycorns"),
//                new Player("Wanda", "Vakulskas", "Gators")
//        );
//
//        IO.println("Repeated Players --> " + findPlayersInBothSports(basketballPlayers, footballPlayers));
//
//        List<Integer> nums = List.of(2, 3, 0, 6, 1, 5);
//
//        IO.println("Missing Number -> " + findMissingnNumber(nums));

//        List<Integer> prices = List.of(10, 7, 5, 8, 11, 2, 6);
//        IO.println("Max Profit -> " + mostStockProfit(prices));

//        List<Integer> numbers = List.of(5, -10, -6, 9, 4);
//        IO.println("Greatest Product -> " + greatestProduct(numbers));

//        List<Double> temperatures = List.of(98.6, 98.0, 97.1, 99.0, 98.9, 97.8, 98.5, 98.2, 98.0, 97.1);
//        IO.println("Ordered Temperatures -> " + orderTemperatures(temperatures));

        List<Integer> numbers = List.of(19, 13, 15, 12, 18, 14, 17, 11);
        IO.println("Maximum Sequence -> " + largestSequence(numbers));
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

        return strings.get(index).length() + recursivelyCountNumberOfCharacters(strings, index + 1);
    }

    private static List<Integer> recursivelyFilterOnlyEven(List<Integer> nums, List<Integer> evens, int index) {
        if (index >= nums.size()) return evens;
        if (nums.get(index) % 2 == 0) evens.add(nums.get(index));
        return recursivelyFilterOnlyEven(nums, evens, index + 1);
    }

    private static int findTriangularNumberOnPosition(int position) {
        if (position <= 0) return 0;
        return findTriangularNumberOnPosition(position - 1) + position;
    }

    private static int findFirstXRecursively(String str, int index) {
        if (index >= str.length()) return -1;
        if (str.charAt(index) == 'x') return index;
        return findFirstXRecursively(str, index + 1);
    }

    private static int findNumberOfShortestPaths(int rows, int cols) {
        if (rows == 1 || cols == 1) return 1;
        return findNumberOfShortestPaths(rows - 1, cols) + findNumberOfShortestPaths(rows, cols - 1);
    }

    private static int addUntil100(List<Integer> array) {
        if (array.isEmpty()) return 0;
        int sum = addUntil100(array.subList(1, array.size() - 1));
        if (array.getFirst() + sum > 100) {
            return sum;
        }
        return array.getFirst() + sum;
    }

    private static int golomb(int n, Map<Integer, Integer> memo) {
        if (n == 1) return 1;
        if (!memo.containsKey(n)) {
            memo.put(n, 1 + golomb(n - golomb(golomb(n - 1, memo), memo), memo));
        }
        return memo.get(n);
    }

    private static int uniquePaths(int rows, int cols, Map<int[], Integer> memo) {
        if (rows == 1 || cols == 1) return 1;
        if (!memo.containsKey(new int[]{rows, cols})) {
            memo.put(new int[]{rows, cols}, uniquePaths(rows - 1, cols, memo) + uniquePaths(rows, cols - 1, memo));
        }

        return memo.get(new int[]{rows, cols});
    }

    private static int greatestProductOfAnyThreeNumbers(List<Integer> array) {
        array.sort(Comparator.reverseOrder());
        return array.get(0) * array.get(1) * array.get(2);
    }

    private static int findMissingNumberWithOrdering(List<Integer> array) {
        array.sort(Comparator.naturalOrder());
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) != i) return i;
        }

        return -1;
    }

    private static int findGreatestNumberNSquared(List<Integer> array) {
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

    private static int findGreatestNumberNLogN(List<Integer> array) {
        array.sort(Comparator.reverseOrder());
        return array.getFirst();
    }

    private static int findGreatestNumberN(List<Integer> array) {
        int max = array.getFirst();
        for (Integer num : array) {
            if (num > max) max = num;
        }

        return max;
    }

    private static <T> void reverseArrayInPlace(List<T> array) {
        for (int i = 0; i < array.size() / 2; i++) {
            int pos = array.size() - i - 1;
            var temp = array.get(pos);
            array.set(pos, array.get(i));
            array.set(i, temp);
        }
    }

    private static List<String> findPlayersInBothSports(List<Player> sport1, List<Player> sport2) {
        Map<String, Boolean> sport1Ref = new HashMap<>();

        for (Player player : sport1) {
            sport1Ref.putIfAbsent(player.fullName(), true);
        }

        List<String> repeatedPlayers = new ArrayList<>();

        for (Player player : sport2) {
            if (sport1Ref.containsKey(player.fullName())) {
                repeatedPlayers.add(player.fullName());
            }
        }

        return repeatedPlayers;
    }

    private static int findMissingnNumber(List<Integer> array) {
        int currentSum = 0;
        int fullSum = 0;

        for (int i = 0; i <= array.size(); i++) {
            fullSum += i;
        }

        for (Integer num : array) {
            currentSum += num;
        }


        return fullSum - currentSum;
    }

    private static int mostStockProfit(List<Integer> prices){
        int maxProfit = 0;
        int buyPrice = prices.getFirst();

        for (int i = 1; i < prices.size(); i++){
            int profit = buyPrice - prices.get(i);

            if (buyPrice > prices.get(i)){
                buyPrice = prices.get(i);
                continue;
            }

            if (maxProfit < profit){
                maxProfit = profit;
            }

        }

        return maxProfit;
    }

    private static int greatestProduct(List<Integer> numbers){
        int bestProductNegative = 0;
        int first = numbers.getFirst();
        int second = numbers.getFirst();

        for (int i = 0; i < numbers.size(); i++){
            if (numbers.get(i) < second && numbers.get(i) > first){
                second = numbers.get(i);
                continue;
            }
            if (numbers.get(i) < first) {
                first = numbers.get(i);
            }
        }

        bestProductNegative = first * second;

        first = numbers.getFirst();
        second = numbers.getFirst();
        int bestProductPositive = 0;

        for (int i = 0; i < numbers.size(); i++){
            if (numbers.get(i) > second && numbers.get(i) < first){
                second = numbers.get(i);
                continue;
            }
            if (numbers.get(i) > first) {
                first = numbers.get(i);
            }
        }

        bestProductPositive = first * second;

        return Math.max(bestProductNegative, bestProductPositive);
    }

    private static List<Double> orderTemperatures(List<Double> temperatures){
        Map<Double, Integer> reference = new HashMap<>();
        for (Double temperature : temperatures){
            reference.put(temperature, reference.getOrDefault(temperature, 0) + 1);
        }

        IO.println(reference);

        List<Double> ordered = new ArrayList<>();

        // Multiply by 10X to remove floating points operation errors
        for (int i = 970; i <= 990; i++){
            IO.println(i);
            for (int j = 0; j < reference.getOrDefault(i / 10., 0); j++){
                ordered.add(i / 10.);
            }
        }

        return ordered;
    }

    private static int largestSequence(List<Integer> numbers){
        Map<Integer, Boolean> aux = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Integer num : numbers){
            aux.put(num, true);
            if (num < min) min = num;
            if (num > max) max = num;
        }

        int greatestSequence = 0;
        int sequence = 1;

        for (int i = min; i <= max; i++){
            if (aux.containsKey(i + 1)) {
                sequence++;
                continue;
            }
            if (sequence > greatestSequence){
                greatestSequence = sequence;
            }
            sequence = 1;
        }

        return greatestSequence;
    }

}
