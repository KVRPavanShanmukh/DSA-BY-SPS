
import java.util.Scanner;

public class NonDecreasingSubsequences {

    public static long mod = (long) (1e9 + 7);

    public static long Count_ND_Subseq(int i, int a[]) {
        // This function will return me the number of non decreasing subsequences.
        long cnt = 1;
        for (int k = i + 1; k < a.length; k++) {
            if (a[k] >= a[i]) {
                cnt = (cnt + Count_ND_Subseq(k, a)) % mod;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }

            long totalCnt = 0;
            for (int i = 0; i < n; i++) {
                totalCnt = (totalCnt + Count_ND_Subseq(i, a)) % mod;
            }
            sb.append(totalCnt).append("\n");
        }
        System.out.println(sb);
        s.close();
    }
}
