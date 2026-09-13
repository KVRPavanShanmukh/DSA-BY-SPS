/*
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 
Constraints:
1 <= n <= 45
*/
import java.util.Arrays;

public class ClimbingStairs {

    public int ClimbingRecursively(int n) {
        if (n <= 1) {
            return n;
        }
        int left = ClimbingRecursively(n - 1);
        int right = ClimbingRecursively(n - 2);

        return left + right;
    }

    public int ClimbingStairs_Memo(int n, int dp[]) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int left = ClimbingRecursively(n - 1);
        int right = ClimbingRecursively(n - 2);

        return dp[n] = left + right;
    }

    public int ClimbingStairs_Tabulation(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println("Number of ways to climb Recursively " + n + " stairs is : " + cs.ClimbingRecursively(n));
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Number of ways to climb Memoized manner " + n + " stairs is : " + cs.ClimbingStairs_Memo(n, dp));
        System.out.println("Number of ways to climb Memoized manner " + n + " stairs is : " + cs.ClimbingStairs_Tabulation(n));
    }
}
