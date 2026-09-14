

/*
You are given a grid with m rows and n columns. You start from the top-left cell (0,0) and want
to reach the bottom-right cell (m-1,n-1).
From any cell, you are allowed to move only in two directions:
● Right
● Down
You need to return the total number of unique paths from the start cell to the destination cell.
Example explanation:
For m = 3, n = 2
You need to make exactly 1 right move and 2 down moves.
All different orders of these moves give 3 unique paths.

 */
public class UniquePathsI {

    //RECURSE
    public int uniquePaths_Recursion(int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (i == 0 && j == 0) {
            return 1;
        }

        int WaysFromTop = uniquePaths_Recursion(i - 1, j);
        int WaysFromLeft = uniquePaths_Recursion(i, j - 1);

        return (WaysFromLeft + WaysFromTop);
    }

    //MEMO
    public int uniquePaths(int i, int j, int dp[][]) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (i == 0 && j == 0) {
            return 1;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int WaysFromTop = uniquePaths(i - 1, j, dp);
        int WaysFromLeft = uniquePaths(i, j - 1, dp);

        return dp[i][j] = WaysFromLeft + WaysFromTop;
    }

    public int uniquePaths_MEMO(int m, int n) {
        return uniquePaths(m - 1, n - 1, new int[m][n]);
    }

    //TAB
    public int uniquePaths_TAB(int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                int left = 0, up = 0;
                if (i > 0) {
                    //I can move up
                    up = dp[i - 1][j];
                }
                if (j > 0) {
                    //I can move left
                    left = dp[i][j - 1];
                }
                dp[i][j] = up + left;
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3, n = 7;

        UniquePathsI up = new UniquePathsI();
        System.err.println("Recursive Approach : " + up.uniquePaths_Recursion(m - 1, n - 1));
        System.err.println("Memoized Approach : " + up.uniquePaths_MEMO(m, n));
        System.err.println("Tabulated Approach : " + up.uniquePaths_TAB(m, n));
    }

}
