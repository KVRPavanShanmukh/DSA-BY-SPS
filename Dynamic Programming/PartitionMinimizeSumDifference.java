/*
You are given an integer array nums of 2 * n integers.
You need to partition nums into two arrays of length n to minimize the absolute difference of the
sums of the arrays. To partition nums, put each element of nums into one of the two arrays.
Return the minimum possible absolute difference.
Input: nums = [3,9,7,3]
Output: 2
Explanation: One optimal partition is: [3,9] and [7,3].
The absolute difference between the sums of the arrays is abs((3 + 9) - (7 + 3)) = 2.
 */

import java.util.HashMap;
import java.util.HashSet;

public class PartitionMinimizeSumDifference {

    static int n;
    static int totalSum;

    static int MiniPartition_Recursively(int index, int count, int sum, int[] nums) {
        if (index == nums.length) {
            if (count == n) {
                return Math.abs(2 * sum - totalSum);
            }
            return Integer.MAX_VALUE;
        }

        int take = Integer.MAX_VALUE;
        if (count < n) {
            take = MiniPartition_Recursively(index + 1, count + 1, sum + nums[index], nums);
        }

        int notTake = MiniPartition_Recursively(
                index + 1,
                count, sum, nums);
        return Math.min(take, notTake);
    }

    // ================= MEMOIZATION =================
    static HashMap<String, Integer> dp;

    static int MiniPartition_MEMO(int index, int count, int sum, int[] nums) {
        if (index == nums.length) {
            if (count == n) {
                return Math.abs(2 * sum - totalSum);
            }
            return Integer.MAX_VALUE;
        }

        // Create unique key for the current state
        String key = index + "," + count + "," + sum;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int take = Integer.MAX_VALUE;

        if (count < n) {
            take = MiniPartition_MEMO(index + 1, count + 1, sum + nums[index], nums);
        }

        // Not Take
        int notTake = MiniPartition_MEMO(index + 1, count, sum, nums);

        int ans = Math.min(take, notTake);
        dp.put(key, ans);
        return ans;
    }

    // ================= LEETCODE METHOD =================
    public int minimumDifference(int[] nums) {
        n = nums.length / 2;
        totalSum = 0;
        for (int x : nums) {
            totalSum += x;
        }

        dp = new HashMap<>();
        return MiniPartition_MEMO(0, 0, 0, nums);
    }

    // ================= TABULATION =================
    static int MiniPartition_TAB(int[] nums) {

        // dp[count] = all possible sums using exactly count elements
        HashSet<Integer>[] dp = new HashSet[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = new HashSet<>();
        }

        dp[0].add(0);
        for (int num : nums) {
            // Go backwards so one number is not used multiple times
            for (int count = n - 1; count >= 0; count--) {
                for (int sum : new HashSet<>(dp[count])) {
                    dp[count + 1].add(sum + num);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        // We need exactly n elements
        for (int sum : dp[n]) {
            int diff = Math.abs(totalSum - 2 * sum);
            ans = Math.min(ans, diff);
        }
        return ans;
    }

    public static void main(String[] args) {
        int a[] = {3, 9, 7, 3};
        // Initialize for array 'a'
        n = a.length / 2;
        totalSum = 0;
        for (int x : a) {
            totalSum += x;
        }
        // ================= SECOND TEST =================
        int b[] = {-36, 36};
        // Re-initialize for array 'b'
        n = b.length / 2;
        totalSum = 0;
        for (int x : b) {
            totalSum += x;
        }

        System.err.println();
        System.err.println("RECURSIVE MINIMUM ABS SUM OF TWO SUBSETS IS : " + MiniPartition_Recursively(0, 0, 0, b));

        dp = new HashMap<>();
        System.err.println("MEMOIZED MINIMUM ABS SUM OF TWO SUBSETS IS : " + MiniPartition_MEMO(0, 0, 0, a));
        System.err.println("TABULATED MINIMUM ABS SUM OF TWO SUBSETS IS : " + MiniPartition_TAB(b));
    }
}
