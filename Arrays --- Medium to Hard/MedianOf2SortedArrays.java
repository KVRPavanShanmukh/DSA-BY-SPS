public class MedianOf2SortedArrays {

    public static double FindMedian(int a[], int b[]) {
        int n = a.length;
        int m = b.length;
        int totalLen = n + m;
        
        int i = 0, j = 0, k = 0;
        int res[] = new int[(totalLen / 2) + 1];
        while (k <= (totalLen / 2) && i < n && j < m) {
            if (a[i] < b[j]) {
                res[k++] = a[i++];
            } else {
                res[k++] = b[j++];
            }
        }

        while (k <= totalLen / 2 && i < n) {
            res[k++] = a[i++];
        }

        while (k <= totalLen / 2 && j < m) {
            res[k++] = b[j++];
        }

        if (totalLen % 2 == 0) {
            double med1 = res[totalLen / 2];
            double med2 = res[(totalLen / 2) - 1];
            return (med1 + med2) / 2.0;
        } else {
            return res[totalLen / 2];
        }
    }

    public static void main(String[] args) {
        int a[] = {1, 3};
        int b[] = {2, 4};
        System.out.printf("%.5f", FindMedian(a, b));
    }
}