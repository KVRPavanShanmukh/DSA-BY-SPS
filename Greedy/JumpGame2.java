/*
Problem Statement: You are given a 0-indexed array nums of length n representing your maximum jump capability from each index.

You start at index 0. Each element nums[i] represents the maximum number of steps you can jump forward from index i.
Your goal is to reach the last index of the array (nums[n - 1]) using the minimum number of jumps
Return the minimum number of jumps required to reach the last index.
You can assume that it is always possible to reach the last index.
 */

public class JumpGame2 {

    public int jump(int[] nums) {
        // Initialize jumps and range trackers
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        // Loop through array up to second last index
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest index we can reach
            farthest = Math.max(farthest, i + nums[i]);

            // If current index reaches the end of current range
            if (i == currentEnd) {
                // Increment jump count
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        JumpGame2 j2 = new JumpGame2();
        System.out.println("Minimum jumps required: " + j2.jump(nums));
    }
}
