
public class KthEleOf2SortedArrays {

    public static int KthEleOf2Arrs(int a[], int b[], int K) {
        int ans = 0;
        int n = a.length;
        int m = b.length;

        int i = 0;  //a
        int j = 0;  //b
        int k = 0;  //c

        int c[] = new int[n + m];
        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                c[k++] = a[i++];
                if (k == K) {
                    return c[k - 1];
                }
            } else {
                c[k++] = b[j++];
                if (k >= K) {
                    return c[k - 1];
                }
            }
            if (k == K) {
                return c[k - 1];
            }
        }

        while (i < n) {
            c[k++] = a[i++];
            if (k == K) {
                return c[k - 1];
            }
        }

        while (j < m) {
            c[k++] = b[j++];
            if (k == K) {
                return c[k - 1];
            }

        }
        return -1;
    }

    public static int BinarySearchApproach(int a[], int b[], int K) {
        int ans = 0;
        int n = a.length;
        int m = b.length;

        int i = 0;  //a
        int j = 0;  //b
        int k = 0;  //c

        int c[] = new int[n + m];
        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                c[k++] = a[i++];
                if (k == K) {
                    return c[k - 1];
                }
            } else {
                c[k++] = b[j++];
                if (k >= K) {
                    return c[k - 1];
                }
            }

            if (k == K) {
                return c[k - 1];
            }
        }

        while (i < n) {
            c[k++] = a[i++];
            if (k == K) {
                return c[k - 1];
            }
        }
        while (j < m) {
            c[k++] = b[j++];
            if (k == K) {
                return c[k - 1];
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = {2, 3, 6, 7, 9};
        int b[] = {1, 4, 5, 8, 10};
        int k = 5;
        System.out.println("My approach of Merging two sorted arrays: " + KthEleOf2Arrs(a, b, k));
        System.out.println("BS Approach : " + KthEleOf2Arrs(a, b, k));
        System.out.println("TC,  SC : O(N+M)");  //not recommended for interviews.
    }
}