import java.util.*;

public class Divide2Numbers {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isPositive = (dividend < 0) == (divisor < 0);
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long ans = 0;
        // Bit manipulation approach
        for (int i = 31; i >= 0; i--) {
            // Check if (d << i) fits into current dividend
            if ((n >> i) >= d) {
                ans += (1L << i);
                n -= (d << i);
            }
        }
        // Apply sign
        return isPositive ? (int) ans : (int) -ans;
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t =s.nextInt();
        while(t-- >0){
            System.out.println("We are not using any '/' (or) '%' (or) '*' operator!");
            int dividend = s.nextInt();
            int divisor = s.nextInt();

            Divide2Numbers d2n = new Divide2Numbers();
            int res = d2n.divide(dividend, divisor);
            System.out.print("The result of the division is : "+res);
        }
    }
}