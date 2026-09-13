/*
A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone.
The frog can jump on a stone, but it must not jump into the water.

Given a list of stones positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the
last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.

If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward
direction. 

Example 1:
Input: stones = [0,1,3,5,6,8,12,17]
Output: true
Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.

Example 2:
Input: stones = [0,1,2,3,4,8,9,11]
Output: false
Explanation: There is no way to jump to the last stone as the gap between the 5th and 6th stone is too large.
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    // Leetcode basic approach:
    static Map<Integer, Integer> hm = new HashMap<>();

    public static boolean canCross(int[] stones) {
        if (stones.length > 1 && stones[1] != 1) {
            return false;
            //base case is to have 0 and 1.
        }

        for (int i = 0; i < stones.length; i++) {
            hm.put(stones[i], i);
        }

        return solve(1, 1, stones);
    }

    public static boolean solve(int currIdx, int k, int stones[]) {
        if (currIdx == stones.length - 1) {
            return true;
        }

        for (int i = k - 1; i <= k + 1; i++) {
            if (i <= 0) {
                continue;
            }
            int nextPos = stones[currIdx] + i;
            if (hm.containsKey(nextPos)) {
                int nxtIdx = hm.get(nextPos);
                if (solve(nxtIdx, i, stones)) {
                    return true;
                }
            }
        }
        return false;
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
        System.out.println("Memoized HashMap Jump -> #Ways : " + canCross(a));

        System.out.println("Memoized Jump's #Ways : " + Frog_Jump(a));

        System.out.println("Tabulated Jump's #Ways : " + dp[n - 1]);
    }
}
