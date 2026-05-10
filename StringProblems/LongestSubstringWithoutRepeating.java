package StringProblems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0, l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (map.containsKey(c) && map.get(c) >= l)
                l = map.get(c) + 1;
            map.put(c, r);
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String[] testCases = { "abcabcbb", "bbbbb", "pwwkew", "", "abcdef", "dvdf" };

        for (String test : testCases) {
            int result = lengthOfLongestSubstring(test);
            System.out.println("Input: \"" + test + "\" → Length: " + result);
        }
    }
}