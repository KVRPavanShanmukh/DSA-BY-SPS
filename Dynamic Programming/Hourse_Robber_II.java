/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place
are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if
two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

Example 2:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
 */

import java.util.Arrays;

public class Hourse_Robber_II {

    public static int RobLinear(int a[], int st, int end) {
        int dp[] = new int[a.length];
        int len = end - st + 1;
        dp[0] = a[st];
        dp[1] = Math.max(a[st], a[st + 1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], a[st + i] + dp[i - 2]);
        }
        return dp[len - 1];
    }
    public static void main(String[] args) {
        int n = 4;
        int a[] = {1, 2, 3, 1};
        int m = 3;
        int b[] = {2, 3, 2};
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        //Base cases
        int ans1 = 0;
        int ans2 = 0;
        int ans3 = 0;
        int ans4 = 0;
        ans1 = RobLinear(a, 0, n - 2);
        ans2 = RobLinear(a, 1, n - 1);
        ans3 = RobLinear(a, 0, m - 2);
        ans4 = RobLinear(a, 1, m - 1);

        System.out.println("For Array 'a' : " + Math.max(ans1, ans2));
        System.out.println("For Array 'b' : " + Math.max(ans3, ans4));
    }
}
