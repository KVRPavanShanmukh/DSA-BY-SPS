/*
Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.
The solution set must not contain duplicate combinations.

Example:
Input: candidates = [10,1,2,7,6,1,5], target = 8

Output:
[
    [1,1,6],
    [1,2,5],
    [1,7],
    [2,6]
]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinationSumII {

    private List<List<Integer>> CombinationSum2(int[] a, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(a);
        CombiSum2(a, 0, target, ans, new ArrayList<>());
        return ans; 
    }

    private void CombiSum2(int[] a, int start, int target, List<List<Integer>> ans, List<Integer> ls) {
        if (target == 0) {
            ans.add(new ArrayList<>(ls));
            return;
        }

        for (int i = start; i < a.length; i++) {
            //Skipping Duplicates!
            if (i > start && a[i] == a[i - 1]) {
                continue;
            }

            //if ele is > target === Break karo!
            if (a[i] > target) {
                break;
            }

            //Ledhanuko, normal ga Subsequence process chestham
            ls.add(a[i]);
            CombiSum2(a, i + 1, target - a[i], ans, ls);
            ls.remove(ls.size() - 1);
        }
    }

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter size of array: ");
            int n = s.nextInt();

            int[] a = new int[n];

            System.out.print("Enter array elements: ");
            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }

            System.out.print("Enter target: ");
            int target = s.nextInt();

            CombinationSumII cs2 = new CombinationSumII();

            System.out.println("Unique combinations:");
            System.out.println(cs2.CombinationSum2(a, target));

        } catch (Exception e) {
            System.err.println("Invalid input");
        }
    }
}
