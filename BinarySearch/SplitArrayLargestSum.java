/*
Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of
any subarray is minimized.

Return the minimized largest sum of the split.
A subarray is a contiguous part of the array.

Example 1:
Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
 */
public class SplitArrayLargestSum {

    public static int CanWeGive(int[] arr, int k) {
        int n = arr.length;
        int students = 1;
        long pages = 0;
        for (int i = 0; i < n; i++) {
            if (pages + arr[i] <= k) {
                pages += arr[i];
            } else {
                students++;
                pages = arr[i];
            }
        }
        return students;
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

    public static int findPages(int[] arr, int m) {
        int n = arr.length;
        if (m > n) {
            return -1;
        }

        int low = findMax(arr);
        int high = findSum(arr);
        while (low <= high) {
            int mid = (low + high) / 2;
            int students = CanWeGive(arr, mid);
            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int splitArray(int[] nums, int k) {
        return findPages(nums, k);
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4};
        int k = 2;
        SplitArrayLargestSum sp = new SplitArrayLargestSum();
        System.out.println(sp.splitArray(a, k));
    }
}
