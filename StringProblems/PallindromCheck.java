package StringProblems;

public class PallindromCheck {
	public static String reversestr(String str) {
		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i); // ✅ fixed
		}
		return rev;
	}

	public static void main(String[] args) {
		String str = "MOM";
		String str2 = reversestr(str);

		char[] Arr = str.toCharArray();
		char[] Brr = str2.toCharArray();

		boolean isPalindrome = true;
		for (int k = 0; k < Arr.length; k++) {
			if (Arr[k] != Brr[k]) {
				isPalindrome = false;
				break;
			}
		}

		if (isPalindrome)
			System.out.println("It is a palindrome");
		else
			System.out.println("It is not a palindrome");
	}
}
