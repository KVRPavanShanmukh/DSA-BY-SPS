/*
Given an integer array nums, return true if you can partition the array into two subsets such that the
sum of the elements in both subsets is equal or false otherwise.

Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class PartitionEqualSubsetSum {

    /*
    Approach : 
    Basically, the problem is direct modification of subset equals sum K. Because here the thing is, we can easily find it as a modification.
    If we have to partition a given array into two parts based on sum, such that the sums are equal.
    We can Decide whether to partition the array or not. First, this has to be decided. Because if the array of length is even We can partition it
    If not,I have to find the sum of the array. Then I have to divide the sum by 2 and cheque for possibility of dividing array based on that sum in the array.
     */
    public static int Sum(int a[]) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    public static boolean SubsetSumEqualK(int i, int a[], int k, int sum) {
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

    public static boolean PartitionSubsetSum(int i, int a[]) {
        int sum = Sum(a);
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        return SubsetSumEqualK(i, a, target, 0);

    }

    public static boolean PartitionSubsetSum_Recurse(int i, int a[]) {
        int sum = Sum(a);
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        return SubsetSumEqualK(i, a, target, 0);
    }

    public static boolean SubsetSumEqualK_MEMO(int i, int a[], int target, int sum, Boolean[][] dp) {
        if (sum == target) {
            return true;
        }
        if (sum > target) {
            return false;
        }
        if (i == a.length) {
            return false;
        }
        if (dp[i][sum] != null) {
            return dp[i][sum];
        }

        boolean take = SubsetSumEqualK_MEMO(i + 1, a, target, sum + a[i], dp);
        boolean notTake = SubsetSumEqualK_MEMO(i + 1, a, target, sum, dp);
        return dp[i][sum] = take || notTake;
    }

    public static boolean PartitionSubsetSum_MEMO(int a[]) {
        int totalSum = Sum(a);
        if (totalSum % 2 != 0) {
            return false;
        }
        int target = totalSum / 2;
        Boolean[][] dp = new Boolean[a.length][target + 1];
        return SubsetSumEqualK_MEMO(0, a, target, 0, dp);
    }

    public boolean canPartition(int[] nums) {
        return PartitionSubsetSum(0, nums);
    }

    public static boolean PartitionSubsetSum_TAB(int a[]) {
        int totalSum = Sum(a);

        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        int n = a.length;

        boolean[][] dp = new boolean[n + 1][target + 1];

        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {

                // Not Take
                dp[i][j] = dp[i - 1][j];

                // Take
                if (a[i - 1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - a[i - 1]];
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        int a[] = {1, 5, 11, 5};
        System.out.println(PartitionSubsetSum_Recurse(0, a));
        System.out.println(PartitionSubsetSum_MEMO(a));
        System.out.println(PartitionSubsetSum_TAB(a));
    }
}
