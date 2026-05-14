package stackproblem;

public class RemoveStars {
	
	    public String removeStars(String s) {
	        StringBuilder stack = new StringBuilder();
	        for (char c : s.toCharArray()) {
	            if (c == '*') {
	                stack.deleteCharAt(stack.length() - 1);
	            } else {
	                stack.append(c);
	            }
	        }
	        return stack.toString();
	    }

	    public static void main(String[] args) {
	    	RemoveStars solution = new RemoveStars();

	        // Test Case 1
	        String s1 = "leet**cod*e";
	        System.out.println("Input: " + s1);
	        System.out.println("Output: " + solution.removeStars(s1));
	        System.out.println("Expected: lecoe");
	        System.out.println();

	        // Test Case 2
	        String s2 = "erase*****";
	        System.out.println("Input: " + s2);
	        System.out.println("Output: " + solution.removeStars(s2));
	        System.out.println("Expected: (empty string)");
	        System.out.println();

	        // Test Case 3 - No stars
	        String s3 = "hello";
	        System.out.println("Input: " + s3);
	        System.out.println("Output: " + solution.removeStars(s3));
	        System.out.println("Expected: hello");
	        System.out.println();

	        // Test Case 4 - Alternating
	        String s4 = "a*b*c*";
	        System.out.println("Input: " + s4);
	        System.out.println("Output: " + solution.removeStars(s4));
	        System.out.println("Expected: (empty string)");
	        System.out.println();

	        // Test Case 5 - Single star
	        String s5 = "ab*c";
	        System.out.println("Input: " + s5);
	        System.out.println("Output: " + solution.removeStars(s5));
	        System.out.println("Expected: ac");
	    }
	}