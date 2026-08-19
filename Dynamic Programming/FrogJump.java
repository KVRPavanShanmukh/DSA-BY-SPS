/*

Problem Statement: Given a number of stairs and a frog, the frog wants to climb from the 0th stair to the (N-1)th stair. At a time the frog can climb either one or two steps. A height[N] array is also given. Whenever the frog jumps from a stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute difference. We need to return the minimum energy that can be used by the frog to jump from stair 0 to stair N-1.

Example 1:
Input: heights = [2, 1, 3, 5, 4]
Output: 2
Explanation: One possible route can be,
0th step -> 2nd Step = abs(2 - 3) = 1
2nd step -> 4th step = abs(3 - 4) = 1
Total = 1 + 1 = 2.

Example 2:
Input: heights = [7, 5, 1, 2, 6]
Output: 9
Explanation: One possible route can be,
0th step -> 1st Step = abs(7 - 5) = 2
1st step -> 3rd step = abs(5 - 2) = 3
3rd step -> 4th step = abs(2 - 6) = 4
Total = 2 + 3 + 4 = 9.
 */

import java.util.Arrays;

public class FrogJump {

    //Memoization: This func returns the minimum cost to reach index ind.
    public static int MemoizedJump(int i, int a[], int dp[]) {
        if (i == 0) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }

        int j1 = MemoizedJump(i - 1, a, dp) + Math.abs(a[i] - a[i - 1]);
        int j2 = Integer.MAX_VALUE;
        if (i > 1) {
            j2 = MemoizedJump(i - 2, a, dp) + Math.abs(a[i] - a[i - 2]);
        }

        dp[i] = Math.min(j1, j2);
        return dp[i];
    }

    public static int Frog_Jump(int a[]) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int n = a.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return MemoizedJump(n - 1, a, dp);
    }

    public static void main(String[] args) {
        int a[] = {2, 1, 3, 5, 4};

        //Tabulation Method
        int n = a.length;
        int dp[] = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int j1 = dp[i - 1] + Math.abs(a[i] - a[i - 1]);
            int j2 = Integer.MAX_VALUE;
            if (i > 1) {
                j2 = dp[i - 2] + Math.abs(a[i] - a[i - 2]);
            }
            dp[i] = Math.min(j1, j2);
        }

        System.out.println("Memoized Jump's #Ways : " + Frog_Jump(a));
        System.out.println("Tabulated Jump's #Ways : " + dp[n - 1]);
    }
}