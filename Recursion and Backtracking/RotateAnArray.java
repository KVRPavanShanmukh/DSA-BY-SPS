
import java.util.Scanner;

public class RotateAnArray {

    // public void ReverseArr(int l, int r, int a[]) {
    //     if (l >= r) {
    //         return;
    //     }
    //     int t = a[l];
    //     a[l] = a[r];
    //     a[r] = t;
    //     ReverseArr(l + 1, r - 1, a);
    // }
    public void ReverseArrSingleParma(int i, int a[], int n) {
        if (i >= n / 2) {
            return;
        }

        int t = a[i];
        a[i] = a[n - i - 1];
        a[n - i - 1] = t;

        ReverseArrSingleParma(i + 1, a, n);
    }

    public void PrintArr(int a[]) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter array size : ");
        int n = s.nextInt();
        System.out.print("Enter array ele's : ");
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        RotateAnArray raa = new RotateAnArray();
        // raa.ReverseArr(0, n - 1, a);
        raa.ReverseArrSingleParma(0, a, n);
        raa.PrintArr(a);
        s.close();
    }
}
