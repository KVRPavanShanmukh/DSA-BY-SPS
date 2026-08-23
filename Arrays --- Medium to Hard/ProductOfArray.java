/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of
all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
Note:
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,  2,  3, 4]
Output:       [24, 12, 8, 6]


a[] =      [1  2  3 4]
prefix[] = [1  1  2 6]
suffix[] = [24 12 4 1]
result[] = [24 12 8 6]
 */
public class ProductOfArray {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pref[] = new int[n];
        int suff[] = new int[n];
        pref[0] = 1;
        suff[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] * nums[i - 1];    // i is not there bcz we do not need it.
        }
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }

        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = pref[i] * suff[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4};
        ProductOfArray po = new ProductOfArray();
        int ans[] = po.productExceptSelf(a);
        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.err.println();
    }
}
