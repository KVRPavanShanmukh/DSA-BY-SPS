import java.util.*;

class IsArrayAsMinHeap {
    public static boolean isMinHeapAsArray(int a[], int n) {
        for (int i = 0; i <= (n / 2) - 1; i++) {
            int lc = 2 * i + 1;
            int rc = 2 * i + 2;
            if (a[i] > a[lc] && a[i] > a[rc]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();

            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }
            System.out.print("The Output is: ");
            System.out.println((isMinHeapAsArray(a, n)) ? "Yes" : "No");

        }
        s.close();
    }
}