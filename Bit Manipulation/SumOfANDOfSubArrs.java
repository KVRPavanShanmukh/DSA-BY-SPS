
import java.util.Scanner;

/*
You are given an array of size N. Find the sum of the results of bitwise AND of all the subarrays.

Input Format
The first line of input contains T - the number of test cases. It is followed by 2T lines, the first line contains N - the size of the array. The second line contains the elements of the array.

Output Format
For each test case, print the result separated by a newline.

Constraints
10 points
1 <= T <= 100
1 <= N <= 100
0 <= A[i] <= 105

20 points
1 <= T <= 100
1 <= N <= 1000
0 <= A[i] <= 105

70 points
1 <= T <= 1000
1 <= N <= 104
0 <= A[i] <= 105

Example
Input
2
4
3 2 0 1
6
1 9 8 1 12 0

Output
8
40

Explanation

Example 1:
The sum of bitwise AND of all subarrays is 3 + 2 + 0 + 1 + 3&2 + 2&0 + 0&1 + 3&2&0 + 2&0&1 + 3&2&0&1 = 8
 */
public class SumOfANDOfSubArrs {

    public static long SumOfANDOfSubArrays(int a[], int n) {
        long sum = 0;

        for (int i = 0; i < n; i++) {
            long and = a[i];
            for (int j = i; j < n; j++) {
                and = (and & a[j]);
                sum += and;
            }
        }
        return sum;
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
            sb.append(SumOfANDOfSubArrays(a, n)).append("\n");
        }
        System.out.println(sb);
        s.close();
    }
}
