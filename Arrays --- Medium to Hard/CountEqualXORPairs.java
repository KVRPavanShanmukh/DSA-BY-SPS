/*
You are given 2 arrays A and B of same size N. A pair is said to be a valid if and only if A[i] ^ A[j] == B[i] ^ B[j]. You have to count total number of valid pairs.
Input Format
First line of input contains T - number of test cases. First line of each test case contains N - size of the array. The second and third line of each test case contains N integers - elements of the array A and B.
Output Format
For each test case, print the count of number of valid pairs, separated by newline.

General Constraints
1 <= T <= 100
0 <= A[i], B[i] <= 109

Example
Input
2
3
1 2 3
3 2 1
5
1 3 7 4 9
8 1 0 13 0

Output
1
3

Explanation
Test Case 1:
There is only one valid pair - (0, 2). This is because A[0] ^ A[2] == B[0] ^ B[2].
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountEqualXORPairs {

    public static int CountPairs_BF(int a[], int b[], int n) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((a[i] ^ a[j]) == (b[i] ^ b[j])) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static long CountPairs(int a[], int b[], int n) {
        long cnt = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int xor = (a[i] ^ b[i]);
            cnt += hm.getOrDefault(xor, 0);
            hm.put(xor, hm.getOrDefault(xor, 0) + 1);
        }
        return cnt;
    }

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
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = s.nextInt();
            }
            sb.append(CountPairs(a, b, n)).append("\n");
        }
        System.out.println(sb);
        s.close();
    }
}