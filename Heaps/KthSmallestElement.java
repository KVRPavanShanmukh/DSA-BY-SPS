import java.util.*;

public class KthSmallestElement {

    public static void BuildMaxHeap(int a[], int k) {
        for (int i = (k / 2) - 1; i >= 0; i--) {
            HeapifyDown(a, k, i);
        }
    }

    public static void HeapifyDown(int a[], int n, int i) {
        while (true) {
            int lc = 2 * i + 1;
            int rc = 2 * i + 2;

            int largestEleIndex = i;
            if (lc < n && a[lc] > a[largestEleIndex]) {
                largestEleIndex = lc;
            }
            if (rc < n && a[rc] > a[largestEleIndex]) {
                largestEleIndex = rc;
            }
            if (largestEleIndex == i) {
                break;
            }

            int t = a[i];
            a[i] = a[largestEleIndex];
            a[largestEleIndex] = t;

            i = largestEleIndex;
        }
    }

    public static int KthSmallestEle(int a[], int n, int k) {
        int heap[] = new int[k];

        for (int i = 0; i < k; i++) {
            heap[i] = a[i];
        }

        BuildMaxHeap(heap, k);

        for (int i = k; i < n; i++) {
            if (a[i] < heap[0]) {
                heap[0] = a[i];
                HeapifyDown(heap, k, 0);
            }
        }
        return heap[0];
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            System.err.println("Enter n and k : ");
            int n = s.nextInt();
            int k = s.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }
            System.out.println("Kth Smallest Element is: " + KthSmallestEle(a, n, k));
        }
        s.close();
    }
}