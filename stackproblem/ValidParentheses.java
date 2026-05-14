package stackproblem;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            // If opening bracket, push to stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // If closing bracket
            else {
                // Stack empty means no matching opener
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        // Valid only if all brackets are matched (stack empty)
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String[] testCases = {
            "{[()]}",   // true
            "()[]{}",   // true
            "([)]",     // false - wrong order
            "{[",       // false - unclosed
            "))",       // false - empty stack
            "",         // true  - empty string
            "{[]}"      // true
        };

        System.out.println("===== Valid Parentheses =====\n");

        for (String test : testCases) {
            boolean result = isValid(test);
            System.out.println("Input  : \"" + test + "\"");
            System.out.println("Output : " + result);
            System.out.println("Status : " + (result ? "VALID" : "INVALID"));
            System.out.println("-----------------------------");
        }
    }
}