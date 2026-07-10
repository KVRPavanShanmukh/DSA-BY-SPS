import java.util.*;

public class XORInAGivenRange {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int number1 = s.nextInt();
        int number2 = s.nextInt();

        int res = 0;
        for (int i = number1; i <= number2; i++) {
            res ^= i;
        }
        System.out.println("XOR of the given range is : " + res);
    }
}
