package BCT_Counsulting;

import java.util.HashMap;
import java.util.Map;

public class StringMain {

    public static void main(String[] args) {

        String str = "bcaaa";

        Map<Character, Integer> freq = new HashMap<>();

        // Count frequency
        for (char ch : str.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        StringBuilder result = new StringBuilder();
        Character prev = null;

        while (result.length() < str.length()) {

            char bestChar = '\0';
            int maxFreq = 0;

            // Find highest frequency character
            // that is not same as previous character
            for (Map.Entry<Character, Integer> entry : freq.entrySet()) {

                char ch = entry.getKey();
                int count = entry.getValue();

                if (count > maxFreq &&
                        (prev == null || ch != prev)) {

                    maxFreq = count;
                    bestChar = ch;
                }
            }

            // No valid character found
            if (maxFreq == 0) {
                System.out.println("Not Possible");
                return;
            }

            result.append(bestChar);

            // Reduce frequency
            freq.put(bestChar, freq.get(bestChar) - 1);

            prev = bestChar;
        }

        System.out.println("Result = " + result);
    }
}