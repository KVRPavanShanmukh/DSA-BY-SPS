
import java.util.Arrays;

/*
Count Partitions with Given Difference:
Problem Statement : Given an array with N positive integers and an integer D, count the number of ways we can partition the
given array into two subsets, S1 and S2 such that S1 - S2 = D and S1 is always greater than or equal to S2.
 */
public class CountPartitionsWithDiff {

    public final int mod = (int) (1e9 + 7);

    public int Sum(int a[]) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    public int CountPartitionDIFF_RECURSE(int i, int a[], int sum, int d) {
        if (i == a.length) {
            if (sum == d) {
                return 1;
            }
            return 0;
        }

        int take = CountPartitionDIFF_RECURSE(i + 1, a, sum + a[i], d);
        int NotTake = CountPartitionDIFF_RECURSE(i + 1, a, sum, d);

        return take + NotTake;
    }

    public int countPartitions_RECURSE(int a[], int d) {
        int totalSum = Sum(a);
        if (totalSum < d || (totalSum + d) % 2 != 0) {
            return 0;
        }

        int target = (totalSum + d) / 2;
        return CountPartitionDIFF_RECURSE(0, a, 0, target);
    }

    //MEMO
    public int CountPartitionDIFF_MEMO(int i, int a[], int sum, int d, int[][] dp) {
        if (i == a.length) {
            if (sum == d) {
                return 1;
            }
            return 0;
        }

        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }

        int take = CountPartitionDIFF_MEMO(i + 1, a, sum + a[i], d, dp);
        int NotTake = CountPartitionDIFF_MEMO(i + 1, a, sum, d, dp);

        return dp[i][sum] = take + NotTake;
    }

    public int countPartitions_MEMO(int a[], int d, int dp[][]) {
        int totalSum = Sum(a);
        if (totalSum < d || (totalSum + d) % 2 != 0) {
            return 0;
        }

        int target = (totalSum + d) / 2;
        return CountPartitionDIFF_MEMO(0, a, 0, target, dp);
    }

    public int CountPartitionDIFF_TAB(int a[], int target) {
        int n = a.length;
        int dp[][] = new int[n + 1][target + 1];

        // Base case
        dp[n][target] = 1;
        // i goes backwards because recursion goes i -> i + 1
        for (int i = n - 1; i >= 0; i--) {
            for (int sum = 0; sum <= target; sum++) {
                int NotTake = dp[i + 1][sum];
                int take = 0;
                if (sum + a[i] <= target) {
                    take = dp[i + 1][sum + a[i]];
                }
                dp[i][sum] = (take + NotTake) % mod;
            }
        }
        //The first element will give us ans as we are coming from back, we come back from as MEMO goes from Front.

        //Memo is Opposite of Tab right!!!
        return dp[0][0];
    }

    public static void main(String[] args) {

        int arr[] = {1, 1, 2, 3};
        int diff = 1;
        int n = arr.length;

        CountPartitionsWithDiff cpwd = new CountPartitionsWithDiff();
        System.err.println("RECURSION : " + cpwd.countPartitions_RECURSE(arr, diff));
        int totalSum = cpwd.Sum(arr);
        int target = (totalSum + diff) / 2;

        int memo[][] = new int[n + 1][target + 1];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        System.err.println("MEMOIZATION : " + cpwd.countPartitions_MEMO(arr, diff, memo));
        System.err.println("TABULATION : " + cpwd.CountPartitionDIFF_TAB(arr, target));
    }
}
