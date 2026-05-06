package StringProblems;

public class suybstring {

	
	
	static String reverseString(String str) {
	    String reverse = "";
	    for (int i = str.length() - 1; i >= 0; i--) {
	        reverse += str.substring(i, i + 1);  // char ki jagah substring
	    }
	    return reverse;
	}

	static boolean isPalindrome(String str) {
	    String reverse = reverseString(str);
	    return str.equals(reverse);  // direct compare, no loop needed
	}
	
	
	public static void main(String[] args) {
		       boolean ret=false;
				ret=isPalindrome("MOM");
				
			if(ret) {
				
				System.out.println("pallindrom");
			}
			else {
				
				System.out.println(" not pallindrom");
			}
			
			
		
	}
}
