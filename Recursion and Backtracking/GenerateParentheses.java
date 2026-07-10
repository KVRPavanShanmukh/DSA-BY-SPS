
import java.util.Scanner;

public class GenerateParentheses {

    private static void GenPara(int i, int n, char a[], int oc, int cc, StringBuilder sb) {
        if (i == 2 * n) {
            sb.append(a).append("\n");
        }

        if (oc < n) {
            a[i] = '{';
            GenPara(i + 1, n, a, oc + 1, cc, sb);
        }
        if (cc < oc) {
            a[i] = '}';
            GenPara(i + 1, n, a, oc, cc + 1, sb);
        }
    }

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter number of pairs to be generated: ");
            int n = s.nextInt();

            StringBuilder sb = new StringBuilder();
            char[] a = new char[2 * n];

            GenPara(0, n, a, 0, 0, sb);

            System.out.println("The parentheses are:");
            System.out.print(sb);
        } catch (Exception e) {
            System.err.println("Invalid input");
        }
    }
}
