package WissenTechnology;

import java.util.Scanner;
import java.util.ArrayList;

public class TargetSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        // Step 1: Create list 1 to n
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        System.out.println("Numbers: " + list);

        // Step 2: Sum odd positioned (index 0,2,4...) elements
        ArrayList<Integer> remaining = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {           // index 0,2,4 → values 1,3,5
                sum += list.get(i);
            } else {
                remaining.add(list.get(i)); // 2,4 are remaining
            }
        }
        System.out.println("After picking 1,3,5 → Sum = " + sum);
        System.out.println("Remaining: " + remaining);

        // Step 3: Loop remaining, ignore last element
        for (int i = 0; i < remaining.size() - 1; i++) {  // -1 to ignore last
            sum += remaining.get(i);
            System.out.println("Adding " + remaining.get(i) + " → Sum = " + sum);
        }

        System.out.println("\nOutput: " + sum);
        sc.close();
    }
}