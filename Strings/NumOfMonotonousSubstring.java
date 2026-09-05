/*
Given a string S, print the number of monotonous substrings of S. Since the answer may be too large, print answer modulo 1e9 + 7. A string is monotonous if all the characters of the string are the same.

Input Format
The first line of input will contain a single integer T, denoting the number of test cases. The first line of each test case contains an integer N - denoting the size of string.
The second line of each test case contains the string S consisting of lowercase characters.

Output Format
Print the number of monotonous substrings of S.

Constraints
20 points
1 <= N <= 102

30 points
1 <= N <= 103

50 points
1 <= N <= 105

General Constraints
1 <= T <= 100
'a' <= S[i] <= 'z'

Example
Input
2
8
abbcccaa
4
aaaa

Output
13
10

 */
import java.util.Scanner;

public class NumOfMonotonousSubstring {

    public static long mod = (long) (1e9 + 7);

    public static long MonoStrings(String s) {
        int n = s.length();
        if (n == 1) {
            return 1;
        }

        long cnt = 0;
        int st = 0, end = 1;
        while (end < n) {
            if (s.charAt(st) == s.charAt(end)) {
                end++;
            } else {
                /*
                by the time the chars mismatch, the end pointer is
                on the mismatching char. so as we need only the matching char len.
                we use end - st;
                 */
                long length = end - st;
                long NumOfSubStrs = (length * (length + 1) / 2) % mod;
                cnt = (cnt + NumOfSubStrs) % mod;
                st = end;
            }
        }

        //last block: but its out of loop as the end exceeded n
        long length = end - st;
        long NumOfSubStrs = (length * (length + 1) / 2) % mod;
        cnt = (cnt + NumOfSubStrs) % mod;
        return cnt;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            String str = s.next();

            sb.append(MonoStrings(str)).append("\n");
        }
        System.out.println(sb);
        s.close();
    }
}
