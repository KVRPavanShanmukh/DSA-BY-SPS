
import java.util.ArrayList;
import java.util.Scanner;

public class CountsSubsetsWithSum_K {

    public int C_S_S_K(int i, int a[], ArrayList<Integer> ls, int sum, int k) {
        if (i == a.length) {
            if (sum == k) {
                return 1;
            } else {
                return 0;
            }
        }

        ls.add(a[i]);
        sum += a[i];
        int l = C_S_S_K(i + 1, a, ls, sum, k);

        ls.remove(ls.size() - 1);
        sum -= a[i];
        int r = C_S_S_K(i + 1, a, ls, sum, k);
        return l + r;
    }

    private static final long MOD = 1_000_000_007L;

    public static long countSubsets(int[] a, int k) {
        long[] dp = new long[k + 1];
        // One way to create sum 0: choose nothing
        dp[0] = 1;

        for (int value : a) {
            // Traverse backwards so each element is used at most once
            for (int sum = k; sum >= value; sum--) {
                dp[sum] = (dp[sum] + dp[sum - value]) % MOD;
            }
        }
        return dp[k];
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = s.nextInt();

        System.out.println("Enter sum to find in the array: ");
        int k = s.nextInt();

        System.out.println("Enter ele's of array: ");
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        System.out.println("The Subsets with sum K are : ");
        CountsSubsetsWithSum_K ss = new CountsSubsetsWithSum_K();
        ArrayList<Integer> ls = new ArrayList<>();

        // System.out.println(ss.C_S_S_K(0, a, ls, 0, k));
        System.out.println(ss.countSubsets(a,k));
        s.close();
    }
}
