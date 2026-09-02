import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {

    public static int LongestIncSubSeq(int a[], int i, int prevIdx) {
        if (i == a.length) {
            return 0;
        }

        int pick = 0;
        if (prevIdx == -1 || a[i] > a[prevIdx]) {
            pick = 1 + LongestIncSubSeq(a, i + 1, i);
        }

        int skip = LongestIncSubSeq(a, i + 1, prevIdx);

        return Math.max(pick, skip);
    }

    //try to do Binary Search on loop for j = 0 to i.
    public static int LIS(int a[], int n) {
        int dp[] = new int[n];
        //base case:
        Arrays.fill(dp, 1);  //by default, each ele is valid subseq of length 1.
        int maxLen = 1;

        if (n == 0) {
            return 0;
        }

        for (int i = 1; i < n; i++) {
            int k = 0;
            // int l = i;
            // while (k <= i) {
            //     int mid = (k + l) / 2;

            // }
            for (int j = 0; j < i; j++) {
                // dp[i] = longest subsequence until index i.
                if (a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        // ls.clear(); //remove all elements for new upcoming iterations
        sb.append("Length of Longest Increasing Subsequence : " + LIS(a, n)).append("\n");
        sb.append("DP in Tabulation is not enough as it takes O(N*N) time in worst case!..").append("\n");
        System.out.println(sb);
        s.close();
    }
}
