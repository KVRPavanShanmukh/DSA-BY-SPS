
import java.util.Scanner;

class MaxContiguousOnes3 {

    public int longestOnes(int[] a, int k) {
        int n = a.length;
        int l = 0;
        int r = 0;
        int zc = 0;
        int maxLen = 0;
        while (r < n) {
            if (a[r] == 0) {
                zc++;
            }
            while (zc > k) {
                if (a[l] == 0) {
                    zc--;
                }
                l++;
            }

            maxLen = Math.max(r - l + 1, maxLen);
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int a[] = new int[n];
        for (int idx = 0; idx < a.length; idx++) {
            a[idx] = s.nextInt();
        }

        MaxContiguousOnes3 ms3 = new MaxContiguousOnes3();
        System.err.println(ms3.longestOnes(a, k));
    }
}
