
public class MergeSort {

    public static void merge(int a[], int l, int m, int h) {
        int n1 = m - l + 1;   //first half of array of size l to r;
        int n2 = h - m;     //second half

        int A[] = new int[n1];
        int B[] = new int[n2];

        //Copy the data from a to A,B
        for (int i = 0; i < n1; i++) 
            A[i] = a[l + i];
        
        for (int i = 0; i < n2; i++) 
            B[i] = a[(m + 1) + i];
        

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (A[i] <= B[j]) {
                a[k] = A[i];
                i++;
            } else {
                a[k] = B[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) 
            a[k++] = A[i++];
        
        while (j < n2) 
            a[k++] = B[j++];
        
    }

    public static void mergeArray(int a[], int l, int h) {
        if (l < h) {
            int mid = l + (h - l) / 2;

            //Sort left and right halves
            mergeArray(a, l, mid);
            mergeArray(a, mid + 1, h);

            //Finally merge arrays into original array
            merge(a, l, mid, h);
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int a[] = {1, 5, 4, 5, 7, 8, 9, 5, 53, 1};
        mergeArray(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
