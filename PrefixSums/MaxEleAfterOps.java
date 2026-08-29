/*
Max Element with Queries:
You are given an array of integers of size N. You are also given Q queries consisting of three integers i, j, and x. For each query, increment each element of the array from index i to j by a value of x. At the end, print the largest element of the array.

Input Format
The first line of input contains T - the number of test cases. For each test case, the first line contains N - the size of the array. The second line contains N integers - the elements of the array. The third line contains Q - the number of queries. The Q subsequent lines each contain 3 integers i, j - the indices denoting the subarray and x - the value to be added to the elements of the subarray.
Output Format
For each test case, after processing all the queries, print the max element of the entire array, separated by a new line.

Constraints
1 <= T <= 100
1 <= N <= 105
1 <= Q <= 104

-105 <= A[i], x <= 105
0 <= i <= j < N

Example
Input
2
5
1 2 3 4 5
2
0 3 7
1 2 2
6
4 10 -1 2 8 -3
1
3 5 6

Output
12
14

Explanation

Test-Case 1
Query 1: Adding 7 to each element of the array from indices 0 to 3 will make the array [8, 9, 10, 11, 5].
Query 2: Adding 2 to each element of the array from indices 1 to 2 will make the array [8, 11, 12, 11, 5].
The max element of the array is 12.

 */

import java.util.Scanner;

public class MaxEleAfterOps {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Idhi chaala helpful mowa.
        StringBuilder sb = new StringBuilder();
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }

            // Using Difference Array
            long diff[] = new long[n + 1];

            long queries = s.nextInt();
            while (queries-- > 0) {
                int i = s.nextInt();
                int j = s.nextInt();
                int x = s.nextInt();   //plus plus

                diff[i] += x;
                diff[j + 1] -= x;
            }

            long curr = 0;
            long ans = Integer.MIN_VALUE;
            for (int k = 0; k < n; k++) {
                curr += diff[k];
                long val = a[k] + curr;
                ans = Math.max(ans, val);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
        s.close();
    }
}
