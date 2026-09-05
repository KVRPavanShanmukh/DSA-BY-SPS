/*
Non-Decreasing Subarrays bookmarkGiven an array of integers of size N, count the number of subarrays of given array which are non-decreasing.

Input Format
First line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N - size of the array and second line contains the elements of the array.

Output Format
For each test case, print the count of number of subarrays which are non-decreasing, separated by newline.

Constraints
10 points
1 <= T <= 100
1 <= N <= 102

20 points
1 <= T <= 100
1 <= N <= 103

70 points
1 <= T <= 100
1 <= N <= 105

General Constraints
1 <= arr[i] <= 109

Example
Input
3
6
2 3 1 4 6 6
1
5
3
1 3 2

Output
13
1
4

Explanation

Test Case 1:
All the valid subarrays are: [2], [2,3], [3], [1], [1,4], [1,4,6], [1,4,6,6], [4], [4,6], [4,6,6], [6], [6,6], [6]

Test Case 2:
All the valid subarrays are: [5]

Test Case 3:
All the valid subarrays are: [1], [1,3], [3], [2]
 */

import java.util.Scanner;

public class NonDecreasingSubArrays {

    /*
ALGO:
i represents the start of the current non-decreasing segment.
j represents the current ending index.
Compare adjacent elements:
If a[j - 1] <= a[j], the current non-decreasing segment can be extended.

Therefore, the number of valid subarrays ending at j is:
j - i + 1
Add this to cnt.
If a[j - 1] > a[j], the non-decreasing segment is broken.

The new segment starts at j, so:
i = j

Only [a[j]] is a valid subarray ending at j, so its contribution is:
j - i + 1 = 1
Move j forward.

cnt initially contains the first single-element subarray [a[0]].
     */

    public static long NDSubArrays(int a[], int n) {
        //this func returns the #NonDecSubArrays to me.
        long cnt = 1;

        //base case:
        if (a.length == 1) {
            return 1;
        }

        int i = 0, j = 1;
        while (i < n && j < n) {
            if (a[j - 1] <= a[j]) {
                cnt += j - i + 1;
                j++;   //expand window
            } else {
                i = j;
                cnt += j - i + 1;
                j++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }
            sb.append(NDSubArrays(a, n)).append("\n");
        }
        System.out.println(sb);
        s.close();
    }
}