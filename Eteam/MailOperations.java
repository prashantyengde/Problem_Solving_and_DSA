package Eteam;


import java.util.*;
import java.io.*;
import java.math.*;
/*
 Problem: Unread Mail Operations

Over time, your mailbox gets littered with too many letters. Some of them
are read, while others are unread. Your mail program can either show a
list of all letters or show the content of a single letter. As soon as
the program shows the content of an unread letter, it becomes a read
letter (if the program shows the content of a read letter, nothing
happens).

In one click, you can do any of the following operations:
- Move from the list of letters to the content of any single letter.
- Return to the list of letters from single-letter viewing mode.
- In single-letter viewing mode, move to the next or to the previous
  letter in the list. You cannot move from the first letter to the
  previous one or from the last letter to the next one.

The program cannot delete the letters from the list or rearrange them.
You want to read all the unread letters and go watch football. Now you
are viewing the list of all letters, and for each letter, you can see if
it is read or unread. What is the minimum number of operations you need
to perform to read all the unread letters?

Input
The first line contains an integer n, representing the number of letters
in the mailbox.
The second line contains n space-separated integers (zeros and ones),
representing the state of the letters in the list. The i-th number
equals 1 if that letter is unread and 0 if that letter is read.

Output
Print the minimum number of operations needed to read all the unread
letters.

Constraints
1 <= n <= 10^5

Example #1
Input:
5
1 1 0 0 1

Output:
4

Explanation: In this example, the action plan is as follows: Open the
first letter, move to the second letter, return to the list, and open
the fifth letter. So you need to perform four operations.

Example #2
Input:
2
0 0

Output:
0

Explanation: There are no unread letters. So you need to perform no
operations.
 */
class Outcome4 {

    public static int solve(List<Integer> ar) {
        int unread = 0;
        int group = 0;
        boolean inGroup = false;

        for (int x : ar) {
            if (x == 1) {
                unread++;
                if (!inGroup) {
                    group++;
                    inGroup = true;
                }
            } else {
                inGroup = false;
            }
        }

        if (unread == 0)
            return 0;

        return unread + (group - 1);
    }
}

public class MailOperations {
    public static void main(String[] args) {
        // Quick local tests
        List<Integer> t1 = Arrays.asList(1, 1, 0, 0, 1);
        System.out.println(Outcome4.solve(t1)); // Expected: 4

        List<Integer> t2 = Arrays.asList(0, 0);
        System.out.println(Outcome4.solve(t2)); // Expected: 0

        List<Integer> t3 = Arrays.asList(1);
        System.out.println(Outcome4.solve(t3)); // Expected: 1

        List<Integer> t4 = Arrays.asList(1, 1, 1, 1, 1);
        System.out.println(Outcome4.solve(t4)); // Expected: 5

        List<Integer> t5 = Arrays.asList(1, 0, 1, 0, 1);
        System.out.println(Outcome4.solve(t5)); // Expected: 5
    }
}