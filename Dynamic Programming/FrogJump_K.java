/*
Example 1:
Input: heights = [10, 5, 20, 0, 15], k = 2
Output: 15
Explanation:
0th step -> 2nd step, cost = abs(10 - 20) = 10
2nd step -> 4th step, cost = abs(20 - 15) = 5
Total cost = 10 + 5 = 15.

Example 2:
Input: heights = [15, 4, 1, 14, 15], k = 3
Output: 2
Explanation:
0th step -> 3rd step, cost = abs(15 - 14) = 1
3rd step -> 4th step, cost = abs(14 - 15) = 1
Total cost = 1 + 1 = 2.
 */
public class FrogJump_K {

    public static void main(String[] args) {
        int a[] = {15, 4, 1, 14, 15};

        //Tabulation Method
        int n = a.length;
        int k = 3;
        int dp[] = new int[n];
        dp[0] = 0;

        // Try all possible jumps from 1 to k
        for (int i = 1; i < n; i++) {
            int mmSteps = Integer.MAX_VALUE;
            // Ensure jump does not go out of bounds
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(a[i] - a[i - j]);
                    // Store the minimum cost
                    mmSteps = Math.min(jump, mmSteps);
                }
            }
            dp[i] = mmSteps;
        }
        // Save the result in dp array
        System.out.println("Tabulated Jump's #Ways : " + dp[n - 1]);
    }
}
