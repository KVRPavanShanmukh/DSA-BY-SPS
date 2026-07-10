
import java.util.Scanner;

public class MultipleRecursionCalls1 {

    public int Nth_fibonacci_Num(int n) {
        if (n <= 1) {
            return n;
        }
        return Nth_fibonacci_Num(n - 1) + Nth_fibonacci_Num(n - 2);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter num : ");
        int n = s.nextInt();
        MultipleRecursionCalls1 mrc = new MultipleRecursionCalls1();
        System.out.println(mrc.Nth_fibonacci_Num(n));
        s.close();
    }
}
