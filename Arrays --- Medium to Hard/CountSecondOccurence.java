/*
Second Occurrence
Problem Description:
You are given an array A of N integers and an integer X. Find the 0-based index of the second occurrence of X in the array.
Print the 0-based index of the second occurrence of X, if it exists.
Print -1 if X does not appear in the array.
Print -2 if X appears exactly once in the array.

Input Format
The first line contains an integer N — the size of the array.
The second line contains N space-separated integers A_0, A_1, ..., A_{N-1}.
The third line contains an integer X.

Output Format
Print a single integer representing the result based on the conditions above.

Constraints
1 <= N <= 1000
0 <= A_i <= 100
0 <= X <= 100

Examples:

Sample 1
Input:
5
45 56 98 56 32
56
Output: 3
Explanation: The value 56 occurs at indices 1 and 3. Its second occurrence is at index 3.

Sample 2
Input:
4
71 52 63 94
89
Output: -1
Explanation: The value 89 does not appear in the array.
 */
import java.util.*;

public class CountSecondOccurence {

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            int n = s.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }
            int x = s.nextInt();
            
            int count = 0;
            int secondIdx = -1;
            
            for (int i = 0; i < n; i++) {
                if (a[i] == x) {
                    count++;
                    if (count == 2) {
                        secondIdx = i;
                        break; // Stop once the second occurrence is found
                    }
                }
            }
            
            if (count == 0) {
                System.out.println(-1);
            } else if (count == 1) {
                System.out.println(-2);
            } else {
                System.out.println(secondIdx);
            }
        }
    }
}