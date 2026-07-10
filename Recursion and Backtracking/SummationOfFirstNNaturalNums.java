
import java.util.Scanner;

public class SummationOfFirstNNaturalNums {

    //Functional Recursion!
    public long SumOfNums(long n) {
        if (n == 0) {
            return 0;
        }
        return n + SumOfNums(n - 1);
    }

    /*
    TC = O(N)
    SC = O(N)
    */

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter num: ");
        long n = s.nextLong();
        SummationOfFirstNNaturalNums sm = new SummationOfFirstNNaturalNums();
        System.out.println("Sum of " + n + " Natural Numbers is : " + sm.SumOfNums(n));
        s.close();
    }
}
