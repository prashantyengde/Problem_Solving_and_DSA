package Eteam;



/*
The problem statement (Virus Spread):

You are given a Petri dish represented as an N x M grid. Each cell in the grid can contain one of the following:
- 0: Empty (no cells in this location)
- 1: A healthy cell
- 2: A virus-infected cell

The virus spreads from infected cells to their neighboring healthy cells. Specifically, a virus-infected cell at
position [i,j] can spread the infection to healthy cells located directly above [i-1,j], below [i+1,j],
left [i,j-1], and right [i,j+1] in one second.

Your task is to determine the minimum time (in seconds) required for the virus to infect all the healthy cells
in the dish. If it is impossible for all the healthy cells to become infected (i.e., some healthy cells are
unreachable by the virus), return -1.

Note:
- The virus can only spread to cells containing a healthy cell (1).
- Empty cells (0) cannot be infected or contribute to the infection process.
- A cell that gets infected in one second cannot spread the infection further in the same second.
  The spread occurs in discrete steps.

Input:
The first line of input contains the number of rows (N).
The second line of input contains the number of columns (M).
Next, the N lines contain M space-separated integers representing the state of each cell in the grid
(either 0, 1, or 2).

Output:
Print an integer that denotes the minimum time for all healthy cells to be infected by the virus.
If not all healthy cells can be infected, print -1.

Constraints:
1 <= M <= 100
1 <= N <= 100
0 <= ar[i][j] <= 2

Example #1
Input:
2
3
2 0 0
1 1 1
Output:
3

Example #2
Input:
2
3
2 0 1
1 1 0
Output:
-1
*/

import java.io.*;
import java.util.*;

class Outcome2 {

    /*
     * Implement method/function with name 'minTime' below.
     * The function accepts following as parameters.
     *  1. ar is of type List<List<Integer>>.
     * return int.
     */

    public static int minTime(List<List<Integer>> ar) {
        int n = ar.size();
        int m = ar.get(0).size();
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int healthyCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = ar.get(i).get(j);
                if (val == 2) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                } else if (val == 1) {
                    healthyCount++;
                }
            }
        }

        if (healthyCount == 0) {
            return 0;
        }

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int time = 0;
        int infectedCount = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean infectedThisRound = false;

            for (int k = 0; k < size; k++) {
                int[] cur = queue.poll();
                for (int[] d : dirs) {
                    int ni = cur[0] + d[0];
                    int nj = cur[1] + d[1];
                    if (ni >= 0 && ni < n && nj >= 0 && nj < m && !visited[ni][nj] && ar.get(ni).get(nj) == 1) {
                        visited[ni][nj] = true;
                        queue.add(new int[]{ni, nj});
                        infectedCount++;
                        infectedThisRound = true;
                    }
                }
            }

            if (infectedThisRound) {
                time++;
            }
        }

        if (infectedCount == healthyCount) {
            return time;
        } else {
            return -1;
        }
    }
}

public class VirusSpread {
    public static void main(String[] args) throws IOException {
        /*
         * BufferedReader bufferedReader = new BufferedReader(new
         * InputStreamReader(System.in)); BufferedWriter bufferedWriter = new
         * BufferedWriter(new FileWriter(System.getProperty("user.dir") +
         * "/output.txt"));
         *
         * int arRows = Integer.parseInt(bufferedReader.readLine().trim());
         * int arColumns = Integer.parseInt(bufferedReader.readLine().trim());
         *
         * List<List<Integer>> ar = new ArrayList<>();
         * for (int i = 0; i < arRows; i++) {
         *     String[] arRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
         *     List<Integer> arRowItems = new ArrayList<>();
         *     for (int j = 0; j < arColumns; j++) {
         *         arRowItems.add(Integer.parseInt(arRowTempItems[j]));
         *     }
         *     ar.add(arRowItems);
         * }
         */

        List<List<Integer>> ar = new ArrayList<>();
        ar.add(Arrays.asList(2, 0, 0));
        ar.add(Arrays.asList(1, 1, 1));

        int outcome = Outcome2.minTime(ar);

        /*
         * bufferedWriter.write(outcome + "\n");
         * bufferedWriter.newLine();
         *
         * bufferedReader.close();
         * bufferedWriter.close();
         */

        System.out.println(outcome);
    }
}