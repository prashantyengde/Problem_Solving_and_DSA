package BCT_Counsulting;

import java.util.*;

public class RearrangeString {

    public static String rearrange(String s) {
        int n = s.length();

        // Step 1: frequency count
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Step 2: max-heap by frequency
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(freq.entrySet());

        StringBuilder result = new StringBuilder();

        // "previous" character waiting to be re-added (cooldown of 1)
        Map.Entry<Character, Integer> prev = null;

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> current = maxHeap.poll();
            result.append(current.getKey());
            current.setValue(current.getValue() - 1);

            // re-add the previous entry back to heap (if it still has count left)
            if (prev != null && prev.getValue() > 0) {
                maxHeap.add(prev);
            }

            prev = current;
        }

        if (result.length() != n) {
            return ""; // not possible to rearrange
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "bcaaa";
        System.out.println("Input : " + input);
        System.out.println("Output: " + rearrange(input));
    }
}