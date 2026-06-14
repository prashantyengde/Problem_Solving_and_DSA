package Eteam;


/*
 * 
The problem statement (Magnetic Letters):

It's your little brother Louie's birthday in a few days, so you decide to buy him a magnetic letterbox. Louie wants to construct two strings using all the letters in the box. You must determine whether he can construct both strings using all the letters in the box.

Input: Line 1 and 2 contain strings S1 and S2 (the strings Louie wants to construct). Line 3 contains string R (all letters in the magnetic box).

Constraints: 1 <= length of S1, S2, R <= 100. Strings contain only uppercase Latin letters.

Output: Print "Yes" if Louie can construct both given strings using all the letters in the box (exactly, with nothing left over). Otherwise print "No".

Examples:

* S1="SAM", S2="JOHN", R="SAMJOHN" -> "Yes" (uses exactly all letters)
* S1="SAM", S2="JOHN", R="SAMLJOHN" -> "No" (extra "L" left over)
* S1="SAM", S2="JOHN", R="SMJOHN" -> "No" (missing "A")

So essentially: sorted(S1+S2) must equal sorted(R), i.e., R's letter multiset must exactly match the combined multiset of S1 and S2 - no extras, no shortages.
 * */
import java.io.*;


class Outcome {

    /*
     * Implement method/function with name 'solve' below.
     * The function accepts following as parameters.
     *  1. S1 is of type String.
     *  2. S2 is of type String.
     *  3. R is of type String.
     * return String.
     */

    public static String solve(String S1, String S2, String R){
        int[] count = new int[26];

        for (char c : R.toCharArray()) {
            count[c - 'A']++;
        }
        for (char c : S1.toCharArray()) {
            count[c - 'A']--;
        }
        for (char c : S2.toCharArray()) {
            count[c - 'A']--;
        }

        for (int x : count) {
            if (x != 0)
                return "No";
        }

        return "Yes"; //return type "String".
    }
}

public class MagneticLetters {
    public static void main(String[] args) throws IOException {
		/*
		 * BufferedReader bufferedReader = new BufferedReader(new
		 * InputStreamReader(System.in)); BufferedWriter bufferedWriter = new
		 * BufferedWriter(new FileWriter(System.getProperty("user.dir") +
		 * "/output.txt"));
		 * 
		 * String S1 = bufferedReader.readLine(); String S2 = bufferedReader.readLine();
		 * String R = bufferedReader.readLine();
		 */
        String outcome = Outcome.solve("SAM", "JOHN", "SAMJOHN");

		/*
		 * bufferedWriter.write(outcome + "\n"); bufferedWriter.newLine();
		 * 
		 * bufferedReader.close(); bufferedWriter.close();
		 */

        System.out.println(outcome);
    }
}