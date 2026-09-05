/*
You are given an array a1, a2, ..., an.

You may perform the following operation any number of times, including zero times:

For every index i (1 <= i <= n), replace ai with |ai - 2|.

Your task is to find the maximum possible frequency of any integer in the array after performing the operation an arbitrary number of times.

Input:

The first line contains an integer t, the number of test cases.

For each test case:

The first line contains an integer n, the length of the array.
The second line contains n integers a1, a2, ..., an.

Constraints:

1 <= t <= 10^4
1 <= n <= 2 * 10^5
1 <= ai <= 10^9
The sum of n over all test cases does not exceed 2 * 10^5.

Output:

For each test case, print a single integer representing the maximum possible frequency of any integer in the array after performing the operation any number of times.

Example:

Input:

5
2
1 3
4
1 1 1 2
3
6 7 8
4
2 2 2 2
5
1 10 100 1000 100000

Output:

2
3
1
4
3
 */

import java.util.HashMap;
import java.util.Scanner;

public class MinusTwo {

    public static int Minus2(int a[], int n) {
        for (int i = 0; i < n; i++) {
            a[i] = Math.abs(a[i] - 2);
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : a) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        int ans = 0;
        for (int i : a) {
            ans = Math.max(hm.get(i), ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }
            System.out.println(Minus2(a, n));
        }
    }
}
