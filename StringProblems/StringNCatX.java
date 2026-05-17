package StringProblems;
import java.util.Scanner;

public class StringNCatX {
	
	    public String StrNCatX(String src, String dest, int iCnt) {
	        String result = src + " ";
	        
	        int limit;
	        if (iCnt >= dest.length()) {
	            limit = dest.length(); // concat whole string
	        } else {
	            limit = iCnt; // concat only N characters
	        }
	        
	        for (int i = 0; i < limit; i++) {
	            result = result + dest.charAt(i);
	        }
	        
	        return result;
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        StringNCatX obj = new StringNCatX();

	        System.out.print("Enter first string: ");
	        String str1 = sc.nextLine();

	        System.out.print("Enter second string: ");
	        String str2 = sc.nextLine();

	        System.out.print("Enter N: ");
	        int n = sc.nextInt();

	        String result = obj.StrNCatX(str1, str2, n);
	        System.out.println("Output: \"" + result + "\"");

	        sc.close();
	    }
	}


