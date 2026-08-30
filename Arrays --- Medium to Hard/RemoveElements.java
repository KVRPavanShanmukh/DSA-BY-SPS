/*
LC 2091:
You are given a 0-indexed array of distinct integers nums.
There is an element in nums that has the lowest value and an element that has the highest value. We call them the minimum and maximum respectively. Your goal is to remove both these elements from the array.
A deletion is defined as either removing an element from the front of the array or removing an element from the back of the array.
Return the minimum number of deletions it would take to remove both the minimum and maximum element from the array.

Example 1:

Input: nums = [2,10,7,5,4,1,8,6]
Output: 5
Explanation: 
The minimum element in the array is nums[5], which is 1.
The maximum element in the array is nums[1], which is 10.
We can remove both the minimum and maximum by removing 2 elements from the front and 3 elements from the back.
This results in 2 + 3 = 5 deletions, which is the minimum number possible.
Example 2:

Input: nums = [0,-4,19,1,8,-2,-3,5]
Output: 3
Explanation: 
The minimum element in the array is nums[1], which is -4.
The maximum element in the array is nums[2], which is 19.
We can remove both the minimum and maximum by removing 3 elements from the front.
This results in only 3 deletions, which is the minimum number possible.
 */

class RemoveElements {

    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        //find maxi and mini
        int maxIndx = 0;
        int minIndx = 0;

        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] > maxi) {
                maxi = nums[i];
                maxIndx = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] < mini) {
                mini = nums[i];
                minIndx = i;
            }
        }

        int lx = Math.min(minIndx, maxIndx);
        int rx = Math.max(minIndx, maxIndx);

        // Case 1: Remove both from left
        int fromLeft = rx + 1;

        // Case 2: Remove both from right
        int fromRight = n - lx;

        // Case 3: Remove one from left and one from right
        int fromBoth = (lx + 1) + (n - rx);

        return Math.min(fromLeft, Math.min(fromRight, fromBoth));
    }

    public static void main(String[] args) {
        int a[] = {2, 10, 7, 5, 4, 1, 8, 6};
        RemoveElements re = new RemoveElements();
        System.out.println("Minimum Deletions required is/are : " + re.minimumDeletions(a));
    }
}
