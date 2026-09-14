/*
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleSum {

    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotalDemo(0, 0, triangle);
    }

    public int minimumTotalDemo(int row, int col, List<List<Integer>> ls) {
        if (row == ls.size() - 1) {
            return ls.get(row).get(col);
        }

        int ithSum;
        int val1 = ls.get(row).get(col);
        ithSum = val1 + minimumTotalDemo(row + 1, col, ls);

        int iPlusOnethSum;
        iPlusOnethSum = val1 + minimumTotalDemo(row + 1, col + 1, ls);
        return Math.min(ithSum, iPlusOnethSum);
    }

    public int minimumTotal_Memo(List<List<Integer>> triangle) {
        int dp[][] = new int[triangle.size()][triangle.size()];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return minimumTotalDemo_Memo(0, 0, triangle, dp);
    }

    public int minimumTotalDemo_Memo(int row, int col, List<List<Integer>> ls, int dp[][]) {
        if (row == ls.size() - 1) {
            return dp[row][col] = ls.get(row).get(col);
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int ithSum;
        int val1 = ls.get(row).get(col);
        ithSum = val1 + minimumTotalDemo_Memo(row + 1, col, ls, dp);

        int iPlusOnethSum;
        iPlusOnethSum = val1 + minimumTotalDemo_Memo(row + 1, col + 1, ls, dp);
        return dp[row][col] = Math.min(ithSum, iPlusOnethSum);
    }

    public int minimumTotalDemo_TAB(List<List<Integer>> ls) {
        int n = ls.size();
        int dp[][] = new int[n][n];

        //Base case : last row
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = ls.get(n - 1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int val = ls.get(i).get(j);
                dp[i][j] = val + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int triangle[][] = {
            {2},
            {3, 4},
            {6, 5, 7},
            {4, 1, 8, 3}
        };

        List<List<Integer>> ls = new ArrayList<>();
        for (int[] row : triangle) {
            List<Integer> currentRow = new ArrayList<>();
            for (int value : row) {
                currentRow.add(value);
            }
            ls.add(currentRow);
        }

        TriangleSum ts = new TriangleSum();
        System.err.println("Recursive Minimum Sum : " + ts.minimumTotal(ls));
        System.err.println("Memoized Minimum Sum : " + ts.minimumTotal_Memo(ls));
        System.err.println("Tabulated Minimum Sum : " + ts.minimumTotalDemo_TAB(ls));
    }
}
