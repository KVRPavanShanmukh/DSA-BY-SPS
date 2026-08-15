/*
Problem Statement: Given an array where each element represents the maximum number of steps you
can jump forward from that element, return true if we can reach the last index starting from the
first index. Otherwise, return false.
Example 1:
Input:nums = [2, 3, 1, 0, 4]
Output: True           
Explanation: 
We start at index 0, with value 2 this means we can jump to index 1 or 2.
From index 1, with value 3, we can jump to index 2, 3, or 4. However, if we jump to index 2 with value 1, we can only jump to index 3.
So we jump to index 1 then index 4 reaching the end of the array.
Hence, we return true


Intuition:
Initialise a variable maxIndex to keep track of the farthest index we can reach from the start
Iterate through each index of the array and at each interaction check if the current index is greater than the maximum index we can reach so far.
If the current index is greater than maxIndex, it means the current index is not reachable hence we return false.
But if current index is reachable we update the maxIndex to be the maximum of the current value of maxIndex and maximum index we can reach from current index ie. i + nums[i].
If we exit the loop without returning false, it means we have reached the last index, therefore we can return a true.
*/
public class JumpGame {

    public boolean canJump(int[] nums) {
        int mi = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > mi) {
                return false;
            }
            mi = Math.max(i + nums[i], mi);
        }
        return true;
    }

    public static void main(String[] args) {
        int a[] = {2, 3, 1, 1, 4};
        JumpGame j = new JumpGame();
        System.out.println(j.canJump(a));
    }
}
