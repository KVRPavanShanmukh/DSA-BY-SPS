/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
which minimizes the sum of all numbers along its path.  
Note: You can only move either down or right at any point in time.
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 */

import java.util.Arrays;

public class MinimumPathSum {

    public int Move_Recursively(int i, int j, int grid[][]) {
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        int UpSum = Integer.MAX_VALUE;
        int LeftSum = Integer.MAX_VALUE;
        if (i > 0) {
            UpSum = grid[i][j] + Move_Recursively(i - 1, j, grid);
        }

        if (j > 0) {
            LeftSum = grid[i][j] + Move_Recursively(i, j - 1, grid);
        }

        return Math.min(LeftSum, UpSum);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return Move_Recursively(m - 1, n - 1, grid);
    }

    //MEMO
    public int Memoized_Sum(int i, int j, int grid[][], int dp[][]) {
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (i == 0 && j == 0) {
            return grid[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int UpSum = Integer.MAX_VALUE;
        int LeftSum = Integer.MAX_VALUE;
        if (i > 0) {
            UpSum = grid[i][j] + Memoized_Sum(i - 1, j, grid, dp);
        }
        if (j > 0) {
            LeftSum = grid[i][j] + Memoized_Sum(i, j - 1, grid, dp);
        }

        return dp[i][j] = Math.min(LeftSum, UpSum);
    }

    public int minPathSumMemo(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m + 1][n + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return Memoized_Sum(m - 1, n - 1, grid, dp);
    }

    public int minPathSumMemo_TAB(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                int leftSum = Integer.MAX_VALUE;
                int UpSum = Integer.MAX_VALUE;
                if (i > 0) {
                    UpSum = grid[i][j] + dp[i - 1][j];
                }
                if (j > 0) {
                    leftSum = grid[i][j] + dp[i][j - 1];
                }
                dp[i][j] = Math.min(leftSum, UpSum);
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int grid[][] = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int m = grid.length;
        int n = grid[0].length;
        MinimumPathSum mups = new MinimumPathSum();
        System.out.println("Recursive Sum : " + mups.Move_Recursively(m - 1, n - 1, grid));
        System.out.println("Recursive Sum : " + mups.minPathSumMemo(grid));
        System.out.println("Recursive Sum : " + mups.minPathSumMemo_TAB(grid));
    }
}
