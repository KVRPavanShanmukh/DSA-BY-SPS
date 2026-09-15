/*
Problem Statement : Given an array arr of n integers and an integer K, count the number of subsets of the given array that
have a sum equal to K.

Input: arr = [1, 2, 2, 3], K = 3
Output: 3
 */
import java.util.Arrays;

public class CountSubsetsWithSumK {

    public int CountSubsetSumWithk_RECURSE(int i, int a[], int sum, int k) {
        if (i == a.length) {
            if (sum == k) {
                return 1;
            }
            return 0;
        }

        //main logic
        int Take = CountSubsetSumWithk_RECURSE(i + 1, a, sum + a[i], k);
        int NotTake = CountSubsetSumWithk_RECURSE(i + 1, a, sum, k);

        return Take + NotTake;
    }

    public int CountSubsetSumWithk_MEMO(int i, int a[], int sum, int k, int dp[][]) {
        if (i == a.length) {
            if (sum == k) {
                return 1;
            }
            return 0;
        }

        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }

        //main logic
        int Take = 0;
        if (sum + a[i] <= k) {
            Take = CountSubsetSumWithk_MEMO(i + 1, a, sum + a[i], k, dp);
        }
        int NotTake = CountSubsetSumWithk_MEMO(i + 1, a, sum, k, dp);

        return dp[i][sum] = Take + NotTake;
    }

    public int CountSubsetSumWithk_TAB(int a[], int k) {
        int n = a.length;
        int dp[][] = new int[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                //Not take
                dp[i][j] = dp[i - 1][j];

                //Take
                if (a[i - 1] <= j) {
                    dp[i][j] += dp[i - 1][j - a[i - 1]];
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 2};
        int k = 3;
        CountSubsetsWithSumK csswk = new CountSubsetsWithSumK();
        System.out.println(csswk.CountSubsetSumWithk_RECURSE(0, a, 0, k));
        int dp[][] = new int[a.length + 1][k + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println(csswk.CountSubsetSumWithk_MEMO(0, a, 0, k, dp));
        System.out.println(csswk.CountSubsetSumWithk_TAB(a, k));
    }
}
