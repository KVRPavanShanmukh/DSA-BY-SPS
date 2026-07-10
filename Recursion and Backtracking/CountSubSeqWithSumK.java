
import java.util.ArrayList;
import java.util.Scanner;

public class CountSubSeqWithSumK {

    public int C_S_K(int i, int a[], ArrayList<Integer> ls, int sum, int k) {
        if (i == a.length) {
            if (sum == k) {
                return 1;
            } else {
                return 0;
            }
        }

        ls.add(a[i]);
        sum += a[i];
        int l = C_S_K(i + 1, a, ls, sum, k);

        ls.remove(ls.size() - 1);
        sum -= a[i];
        int r = C_S_K(i + 1, a, ls, sum, k);
        return l + r;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = s.nextInt();

        System.out.println("Enter sum to find in the array: ");
        int k = s.nextInt();

        System.out.println("Enter ele's of array: ");
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        System.out.println("The Subsequences with sum K are : ");
        CountSubSeqWithSumK gosk = new CountSubSeqWithSumK();
        ArrayList<Integer> ls = new ArrayList<>();

        System.out.println(gosk.C_S_K(0, a, ls, 0, k));
        s.close();
    }
}
