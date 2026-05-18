package StringProblems;

import java.util.Scanner;

public class StringLength {
    
    static void strlen(String str1, String str2) {
        System.out.println(str1.length() + "  " + str2.length());
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();
        
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();
        
        strlen(str1, str2);
        
        sc.close();
    }
}