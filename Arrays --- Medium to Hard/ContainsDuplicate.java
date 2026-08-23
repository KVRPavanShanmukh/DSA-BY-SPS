/*
Given an integer array nums, return true if
any value appears at least twice in the array, and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true
Explanation:
The element 1 occurs at the indices 0 and 3.
 */

import java.util.HashMap;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
            if (hm.get(i) == 2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 2, 3, 4, 1};
        ContainsDuplicate cd = new ContainsDuplicate();
        System.out.println("We have duplicates? " + (cd.containsDuplicate(a)));
    }
}
