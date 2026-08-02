
import java.util.Arrays;

public class FindMedianOf2Arrays {

    public static double findMedianSortedArrays(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;

        int c[] = new int[n + m];
        int k = 0;

        for (int i = 0; i < n; i++) {
            c[k++] = a[i]; // I am adding array 'a' into 'c'.
        }

        for (int i = 0; i < m; i++) {
            c[k++] = b[i]; // I am adding array 'a' into 'c'.
        }

        Arrays.sort(c);

        //Find median
        int t = c.length;
        if (t % 2 == 1) {
            return (double) c[t / 2];
        } else {
            int m1 = c[t / 2 - 1];
            int m2 = c[t / 2];
            return ((double) m1 + (double) m2) / 2.0;
        }
    }

    public static void main(String[] args) {
        int a[] = {1, 3};
        int b[] = {2};
        System.out.println(findMedianSortedArrays(a, b));
    }
}
