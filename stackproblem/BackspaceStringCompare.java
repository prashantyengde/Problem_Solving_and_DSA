package stackproblem;


import java.util.Stack;

public class BackspaceStringCompare {

    // Simulate typing with '#' acting as backspace key
    private String processString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        System.out.println(result.toString());
        return result.toString();
    }

    public boolean backspaceCompare(String s, String t) {
        return processString(s).equals(processString(t));
    }

    public static void main(String[] args) {
        BackspaceStringCompare solution = new BackspaceStringCompare();

        // Test Case 1
        String s1 = "ab#c", t1 = "ad#c";
        System.out.println("Input: s = " + s1 + ", t = " + t1);
        System.out.println("Output: " + solution.backspaceCompare(s1, t1));
        System.out.println("Expected: true");
        System.out.println();

        // Test Case 2
        String s2 = "ab##", t2 = "c#d#";
        System.out.println("Input: s = " + s2 + ", t = " + t2);
        System.out.println("Output: " + solution.backspaceCompare(s2, t2));
        System.out.println("Expected: true");
        System.out.println();

        // Test Case 3
        String s3 = "a#c", t3 = "b";
        System.out.println("Input: s = " + s3 + ", t = " + t3);
        System.out.println("Output: " + solution.backspaceCompare(s3, t3));
        System.out.println("Expected: false");
        System.out.println();

        // Test Case 4 - No backspaces
        String s4 = "hello", t4 = "hello";
        System.out.println("Input: s = " + s4 + ", t = " + t4);
        System.out.println("Output: " + solution.backspaceCompare(s4, t4));
        System.out.println("Expected: true");
        System.out.println();

        // Test Case 5 - All backspaced
        String s5 = "abc###", t5 = "xyz###";
        System.out.println("Input: s = " + s5 + ", t = " + t5);
        System.out.println("Output: " + solution.backspaceCompare(s5, t5));
        System.out.println("Expected: true");
    }
}