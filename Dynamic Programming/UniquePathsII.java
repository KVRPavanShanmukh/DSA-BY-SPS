/*
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The testcases are generated so that the answer will be less than or equal to 2 * 109.

Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

 */
public class UniquePathsII {

    public int uniquePathsWithObstacles_REC(int obstacleGrid[][], int i, int j) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }

        int upMove = 0;
        if (i > 0 && obstacleGrid[i - 1][j] == 0) {
            upMove = uniquePathsWithObstacles_REC(obstacleGrid, i - 1, j);
        }
        int LeftMove = 0;
        if (j > 0 && obstacleGrid[i][j - 1] == 0) {
            LeftMove = uniquePathsWithObstacles_REC(obstacleGrid, i, j - 1);
        }

        return upMove + LeftMove;
    }

    public int uniquePathsWithObstacles_MEMO(int obstacleGrid[][], int i, int j, int dp[][]) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (obstacleGrid[0][0] == 1 || obstacleGrid[i][j] == 1) {
            return 0;
        }

        if (i == 0 && j == 0) {
            return 1;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int upMove = 0;
        if (i > 0 && obstacleGrid[i - 1][j] == 0) {
            upMove = uniquePathsWithObstacles_MEMO(obstacleGrid, i - 1, j, dp);
        }

        int LeftMove = 0;
        if (j > 0 && obstacleGrid[i][j - 1] == 0) {
            LeftMove = uniquePathsWithObstacles_MEMO(obstacleGrid, i, j - 1, dp);
        }

        return dp[i][j] = (upMove + LeftMove);
    }

    public int uniquePathsWithObstacles_TAB(int obstacleGrid[][]) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m == 0 && n == 0) {
            return 0;
        }

        int dp[][] = new int[m + 1][n + 1];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0){
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                int upMove = 0;
                if (i > 0 && obstacleGrid[i - 1][j] ==0) {
                    upMove = dp[i - 1][j];
                }
                int LeftMove = 0;
                if (j > 0 && obstacleGrid[i][j - 1] ==0) {
                    LeftMove = dp[i][j - 1];
                }
                dp[i][j] = upMove + LeftMove;
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int grid[][] = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int m = grid.length;
        int n = grid[0].length;

        UniquePathsII up2 = new UniquePathsII();

        int dp[][] = new int[m + 1][n + 1];
        System.out.println("Recursive Approach : " + up2.uniquePathsWithObstacles_REC(grid, m - 1, n - 1));
        System.out.println("Memoization Approach : " + up2.uniquePathsWithObstacles_MEMO(grid, m - 1, n - 1, dp));
        System.out.println("Tabulation Approach : " + up2.uniquePathsWithObstacles_TAB(grid));
    }
}
