/*
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Example 1:
Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 */
import java.util.Arrays;

public class Fibonacci {

    // if n <= 20
    public static int Fib(int n) {
        if (n <= 1) {
            return n;
        }
        return Fib(n - 1) + Fib(n - 2);
    }

    // Memoization : Recursion + Storing Calculated Data
    // Why? : To avoid recomputations and to avoid increasing the spread of recursive tree.  
    //Top Down Approach
    public static int Fib_Memoization(int n, int dp[]) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = Fib_Memoization(n - 1, dp) + Fib_Memoization(n - 2, dp);
    }

    // Tabulation : Iteration of instances + Storing the values
    // Why? : To avoid recomputations and to avoid increasing the spread of recursive tree.  
    //Bottom Up Approach
    public static int Fib_Tabulation(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 100;
        // for n <= 40
        System.out.println(Fib(n));
        // for n >= 40 and n <= 47 (fib(47) > Integer.MAX_VALUE)
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(Fib_Memoization(n, dp));
        System.out.println(Fib_Tabulation(n));
    }
}
