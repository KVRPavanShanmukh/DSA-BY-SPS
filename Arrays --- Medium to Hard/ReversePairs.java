/*
Given an integer array nums, return the number of reverse pairs in the array.
A reverse pair is a pair (i, j) where:
0 <= i < j < nums.length and
nums[i] > 2 * nums[j].

Example 1:x
Input: nums = [1,3,2,3,1]
Output: 2

Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
 */

public class ReversePairs {

    public int reversePairs_BF(int[] nums) {
        int n = nums.length;
        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (nums[i] > 2 * nums[j]) {
                    c++;
                }
            }
        }
        return c;
        //Wrong Answer---> 29 / 140 testcases passed
    }

    public static int mergeAndCount(int a[], int l, int m, int h) {
        int cnt = 0;

        // Count reverse pairs
        int j = m + 1;

        for (int i = l; i <= m; i++) {
            while (j <= h && (long) a[i] > 2L * a[j]) {
                j++;
            }

            cnt += j - (m + 1);
        }

        // Normal merge
        int i = l;
        j = m + 1;
        int k = l;

        int A[] = new int[h - l + 1];

        while (i <= m && j <= h) {
            if (a[i] <= a[j]) {
                A[k - l] = a[i];
                i++;
            } else {
                A[k - l] = a[j];
                j++;
            }
            k++;
        }

        // Remaining elements from left
        while (i <= m) {
            A[k - l] = a[i];
            i++;
            k++;
        }

        // Remaining elements from right
        while (j <= h) {
            A[k - l] = a[j];
            j++;
            k++;
        }

        // Copy back into original array
        for (int x = l; x <= h; x++) {
            a[x] = A[x - l];
        }

        return cnt;
    }

    public static int mergeSort(int a[], int l, int h) {

        if (l >= h) {
            return 0;
        }

        int mid = l + (h - l) / 2;

        int cnt = 0;

        // Sort left half
        cnt += mergeSort(a, l, mid);

        // Sort right half
        cnt += mergeSort(a, mid + 1, h);

        // Count reverse pairs + merge
        cnt += mergeAndCount(a, l, mid, h);

        return cnt;
    }

    public static void main(String[] args) {
        int a[] = {1, 3, 2, 3, 1};
        ReversePairs rp = new ReversePairs();
        // System.err.println(rp.reversePairs_BF(a));
        System.err.println(rp.mergeSort(a, 0, a.length - 1));
    }
}
