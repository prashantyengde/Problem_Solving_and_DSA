package WissenTechnology;

import java.util.Scanner;

public class DivideIntoFourParts {

    public static void divideAllWays(int n) {

        // Validate
        if (n < 6 || n % 2 != 0) {
            System.out.println("Not possible to divide into a a b b");
            return;
        }

        int half = n / 2;
        int smallest = Integer.MAX_VALUE;

        System.out.println("All valid divisions of " + n + ":\n");

        // Only loop till half/2 to avoid duplicates
        // Example: 1 1 49 49 and 49 49 1 1 are same
        for (int a = 1; a <= half / 2; a++) {
            int b = half - a;
            if (a != b) {
                System.out.println(a + " " + a + " " + b + " " + b);
                if (a < smallest) {
                    smallest = a;
                }
            }
        }

        System.out.println("\nSmallest number: " + smallest);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        divideAllWays(n);
        sc.close();
    }
}