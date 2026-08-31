/*
Problem Statement:
Rohit is working on a new programming challenge. He needs to write a program that reads a matrix of integers and prints its elements in a special zigzag pattern. The zigzag pattern alternates between printing the elements of each row from left to right and from right to left.
Help Rohit by writing a program that reads a matrix of integers, prints its elements in the desired zigzag pattern, and then outputs the result.

Input format :
The first line of input consists of two space-separated integers m and n, representing the order of the matrix.
The next m lines consist of n space-separated integers, representing the elements of the matrix.

Output format :
The output prints space-separated integers, representing the elements of the matrix in the zigzag pattern.
Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ m, n ≤ 5

Sample test cases :
Input 1 :
4 4
13 23 32 43 
15 25 35 45 
18 28 38 48 
51 62 73 81
Output 1 :
13 23 32 43 45 35 25 15 18 28 38 48 81 73 62 51 

Input 2 :
3 1
41
24
53
Output 2 :
41 24 53 
Input 3 :
2 2
3 4 
8 7
Output 3 :
3 4 7 8 
 */
import java.util.*;

public class ZigZagTraversalOfMatrix {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        int a[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = s.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < m; j++) {
                    System.out.print(a[i][j] + " ");
                }
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    System.out.print(a[i][j] + " ");
                }
            }
        }
    }
}
