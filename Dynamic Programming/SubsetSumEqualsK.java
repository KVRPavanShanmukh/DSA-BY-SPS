/*
Subset sum equal to target:
Problem Statement: We are given an array ‘ARR’ with N positive integers. We need to find if there is a subset in “ARR” with a sum equal to K. If there is, return true else return false.

A subset/subsequence is a contiguous or non-contiguous part of an array, where elements appear in the same order as the original array.
For example, for the array: [2,3,1] , the subsequences will be [{2},{3},{1},{2,3},{2,1},{3,1},{2,3,1}} but {3,2} is not a subsequence because its elements are not in the same order as the original array.

Input :  N = 4, ARR = [4, 3, 5, 2], K = 6 
Output : true
Explanation : One possible subset with sum = 6 is [4, 2]. There’s also [3, 3] but that doesn’t exist in the array. As soon as we find one subset whose sum is equal to K, the answer is true.
 */

public class SubsetSumEqualsK {

    public boolean SubsetSumEqualK(int i, int a[], int k, int sum) {
        if (sum == k) {
            return true;
        }
        if (i == a.length) {
            return false;
        }
        boolean take = SubsetSumEqualK(i + 1, a, k, sum + a[i]);
        boolean notTake = SubsetSumEqualK(i + 1, a, k, sum);

        return take || notTake;
    }

    //MEMO
    public boolean SubsetSumEqualK_MEMO(int i, int a[], int k, int sum, Boolean dp[][]) {
        if (sum == k) {
            return true;
        }

        if (sum > k) {
            return false;
        }

        if (i == a.length) {
            return false;
        }
        if (dp[i][sum] != null) {
            return dp[i][sum];
        }

        boolean take = SubsetSumEqualK_MEMO(i + 1, a, k, sum + a[i], dp);
        boolean notTake = SubsetSumEqualK_MEMO(i + 1, a, k, sum, dp);

        return dp[i][sum] = (take || notTake);
    }

    //TAB
    public boolean SubsetSumEqualK_TAB(int a[], int k) {
        int n = a.length;
        //A sum needs to go upto k, not n. it is k + 1.
        boolean dp[][] = new boolean[n + 1][k + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (a[i - 1] <= j) {
                    dp[i][j] = (dp[i - 1][j - a[i - 1]]) || (dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        int a[] = {4, 3, 5, 2};
        int k = 6;
        SubsetSumEqualsK ssek = new SubsetSumEqualsK();
        System.out.println("Sum in Recursive Approach : " + ssek.SubsetSumEqualK(0, a, k, 0));
        System.out.println("Sum in Memoized Approach : " + ssek.SubsetSumEqualK_MEMO(0, a, k, 0, new Boolean[a.length][k + 1]));
        System.out.println("Sum in Tabulated Approach : " + ssek.SubsetSumEqualK_TAB(a, k));
    }
}
