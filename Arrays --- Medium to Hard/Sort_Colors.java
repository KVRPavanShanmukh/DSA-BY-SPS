
public class Sort_Colors {

    public static void SortColors(int a[], int n) {
        int p1 = 0, p2 = 0, p3 = n - 1;

        while (p2 <= p3) {
            if (a[p2] == 0) {
                swap(a, p1, p2);
                p1++;
                p2++;
            } else if (a[p2] == 1) {   // just move p2
                p2++;
            } else {
                swap(a, p2, p3);
                p3--;
            }
        }
    }

    public static void swap(int a[], int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int n = 6;
        int a[] = {2, 0, 2, 1, 1, 0};

        SortColors(a, n);

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
