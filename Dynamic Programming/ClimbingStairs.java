
public class ClimbingStairs {

    public int ClimbingStairs(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println("Number of ways to climb " + n + " stairs is : " + cs.ClimbingStairs(n));
    }
}
