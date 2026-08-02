

/*
Problem Statement: Given an array/list of length ‘N’, where the array/list represents the boards and each element of the given
array/list represents the length of each board. Some ‘K’ numbers of Painters are available to paint these boards. Consider
that each unit of a board takes 1 unit of time to paint. You are supposed to return the area of the minimum time to get this
job done of painting all the ‘N’ boards under the constraint that any painter will only paint the continuous sections of boards.

Example 1:
Input Format: N = 4, boards[] = {5, 5, 5, 5}, k = 2
Result: 10
Explanation: We can divide the boards into 2 equal-sized partitions, so each painter gets 10 units of the board and the
total time taken is 10.

Example 2:
Input Format: N = 4, boards[] = {10, 20, 30, 40}, k = 2
Result: 60
Explanation: We can divide the first 3 boards for one painter and the last board for the second painter.
 */
public class PaintersPartitions {

    public static int CanWePAINT(int[] arr, int k) {
        int n = arr.length;
        int Painters = 1;
        long boards = 0;
        for (int i = 0; i < n; i++) {
            if (boards + arr[i] <= k) {
                boards += arr[i];
            } else {
                Painters++;
                boards = arr[i];
            }
        }
        return Painters;
    }

    public static int findMax(int a[]) {
        int ans = a[0];
        for (int i = 0; i < a.length; i++) {
            ans = Math.max(a[i], ans);
        }
        return ans;
    }

    public static int findSum(int a[]) {
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            ans += a[i];
        }
        return ans;
    }

    public static int findboards(int[] arr, int m) {
        int n = arr.length;
        if (m > n) {
            return -1;
        }

        int low = findMax(arr);
        int high = findSum(arr);
        while (low <= high) {
            int mid = (low + high) / 2;
            int Painters = CanWePAINT(arr, mid);
            if (Painters > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int PAINTER_PARTITION(int[] nums, int k) {
        return findboards(nums, k);
    }

    public static void main(String[] args) {
        PaintersPartitions pp = new PaintersPartitions();
        int a[] = {1, 2, 3, 4};
        int k = 2;
        System.out.println(pp.PAINTER_PARTITION(a, k));
    }
}
