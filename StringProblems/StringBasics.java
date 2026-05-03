package StringProblems;

public class StringBasics {

    // Method to reverse a string
    static String reverseString(String str) {
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        return reverse;
    }

    // Method to check palindrome
    static boolean isPalindrome(String str) {
        String original = str;
        String reverse = reverseString(original);

        // compare character by character
        for (int i = 0; i < original.length(); i++) {
            char ch1 = original.charAt(i);
            char ch2 = reverse.charAt(i);

            if (ch1 != ch2) {
                // no match
                return false;
            }
        }
        // loop se bahar main tabhi aaunga
        // jab saare character match krre honge
        // iska mtlb return true
        return true;
    }

    public static void main(String[] args) {
        String word = "madam";

        if (isPalindrome(word)) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is NOT a Palindrome");
        }
    }
}