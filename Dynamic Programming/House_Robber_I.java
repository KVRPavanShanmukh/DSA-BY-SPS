/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount
of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses
have security systems connected and it will automatically contact the police if two adjacent houses
were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount
of money you can rob tonight without alerting the police.

Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
 */

import java.util.Arrays;

public class House_Robber_I {

    public static int RecursivelyRobbingMoney(int a[], int i) {
        /*  Here the condition is that adjacent houses cannot be robbed In that situation, it is a pick and a not pick
            Pick and not pick --> it is subsequences pattern. In subsequences pattern.
            Here adjacent choices cannot be taken So what are we going to do?
            We are going to take the previous choice of the adjacent choice --> (i - 2).
         */

        if (i == 0) {
            return a[i];
        }
        if (i < 0) {
            return 0;
        }

        int Picking = a[i] + RecursivelyRobbingMoney(a, i - 2);
        int Not_Picking = RecursivelyRobbingMoney(a, i - 1);

        return Math.max(Picking, Not_Picking);
    }

    public static int DynamicallyRobbingHouses_MEMO(int a[], int i, int dp[]) {
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            return a[0];
        }

        if (dp[i] != -1) {
            return dp[i];
        }
        int Picking = a[i] + DynamicallyRobbingHouses_MEMO(a, i - 2, dp);
        int Not_Picking = DynamicallyRobbingHouses_MEMO(a, i - 1, dp);

        return dp[i] = Math.max(Picking, Not_Picking);
    }

    public static int DynamicallyRobbingHouses_TABULATION(int a[]) {
        if (a == null || a.length == 0) {
            return 0;
        }
        if (a.length == 1) {
            return a[0];
        }

        int dp[] = new int[a.length + 1];
        Arrays.fill(dp, -1);

        dp[0] = a[0];
        dp[1] = Math.max(a[0], a[1]);

        for (int i = 2; i < a.length; i++) {
            if (i > 1) {
                dp[i] = Math.max((a[i] + dp[i - 2]), dp[i - 1]);
            }
        }
        return dp[a.length - 1];
    }

    public static void main(String[] args) {
        int n = 4;
        int a[] = {1, 2, 3, 1};

        /*
        At each house I have two choices:
        Rob current house.
        Skip the current house
         */
        System.out.println("Max money that I can rob is " + RecursivelyRobbingMoney(a, a.length - 1) + " Dollars!");

        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = a[0];
        dp[1] = Math.max(a[0], a[1]);
        System.out.println("Max money that I can rob is " + DynamicallyRobbingHouses_MEMO(a, n - 1, dp) + " Dollars!");

        System.out.println("Max money that I can rob is " + DynamicallyRobbingHouses_TABULATION(a) + " Dollars!");
    }
}
