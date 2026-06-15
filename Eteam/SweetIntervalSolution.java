package Eteam;

import java.util.*;
import java.io.*;
import java.math.*;
/*
 * 
Sweet Interval

Find an interval in the given array of non-negative integers such that the elements 
in the interval sum up to a given number S.

Input:
The first line of input contains N, representing the size of the array ar[].
The second line of input contains N space-separated non-negative integers 
representing the array elements.
The third line of input contains S, representing the sum.

Output:
Print the starting and ending positions of the first such occurring interval if the 
sum equals S; else, print -1.

Note: The position of the 1st element of the array should be considered as 1.

Constraints:
1 <= N <= 100
1 <= ar[i] <= 200

The problem should be solved with an O(n) Time Complexity.

Example #1
Input:
4
1 3 7 5
10

Output:
2 3

Explanation: 3+7 = 10. So, the interval is from 2 to 3.

Example #2
Input:
8
1 2 3 4 5 6 7 8
21

Output:
1 6

Explanation: Here, 1+2+3+4+5+6 = 21. So, the interval is from 1 to 6.
 */
class Outcome3 {

    public static List<Integer> solve(List<Integer> ar, int S) {
        int n = ar.size();
        int sum = 0, start = 0;
        for (int end = 0; end < n; end++) {
            sum += ar.get(end);
            System.out.println("end=" + end + " sum=" + sum + " start=" + start);

            while (sum > S && start < end) {
                sum -= ar.get(start);
                start++;
                System.out.println("  shrink -> start=" + start + " sum=" + sum);
            }
            if (sum == S) {
                System.out.println("Found! start=" + (start + 1) + " end=" + (end + 1));
                List<Integer> result = new ArrayList<>();
                result.add(start + 1);
                result.add(end + 1);
                return result;
            }
        }
        System.out.println("No interval found");
        List<Integer> result = new ArrayList<>();
        result.add(-1);
        return result;
    }
}

public class SweetIntervalSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Numbers  " );
        int n = Integer.parseInt(br.readLine().trim());
        System.out.println("N = " + n);

        List<Integer> ar = new ArrayList<>();
        System.out.println("Enter Numbers that N  " );
        String[] items = br.readLine().trim().split("\\s+");
        
        for (int i = 0; i < n; i++) {
            ar.add(Integer.parseInt(items[i]));
        }
        System.out.println("Array = " + ar);
        System.out.println("Sum Want  " );
        int S = Integer.parseInt(br.readLine().trim());
      
        System.out.println("S = " + S);

        List<Integer> outcome = Outcome3.solve(ar, S);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < outcome.size(); i++) {
            sb.append(outcome.get(i));
            if (i < outcome.size() - 1) sb.append(" ");
        }
        System.out.println("Result = " + sb.toString());

        br.close();
    }
}