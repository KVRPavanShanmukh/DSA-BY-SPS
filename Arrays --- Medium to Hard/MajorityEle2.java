/*
Given an integer array of size n, find all elements that appear more than ⌊n / 3⌋ times.

Example 1:
Input: nums = [3,2,3]
Output: [3]
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityEle2 {

    public static List<Integer> MajorityEleII(int a[]) {
        int n = a.length;

        List<Integer> ls = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : a) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        int Treshold = (int) Math.floor(n / 3);
        for (int i = 0; i < n; i++) {
            if (hm.get(a[i]) > Treshold && !ls.contains(a[i])) {
                ls.add(a[i]);
            }
        }
        return ls;
    }

    public static void main(String[] args) {
        int a[] = {3, 2, 3};
        System.out.println(MajorityEleII(a));
    }
}
