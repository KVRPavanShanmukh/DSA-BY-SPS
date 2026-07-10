
import java.util.ArrayList;
import java.util.Scanner;

public class GenerateOnlyOneSubSeqWithSumK {

    public boolean GeneSubseqSumK(int i, int a[], ArrayList<Integer> ls, int sum, int k) {
        if (i == a.length) {
            if (sum == k) {
                print(ls);
                return true;
            } else {
                return false;
            }
        }

        ls.add(a[i]);
        sum += a[i];
        if (GeneSubseqSumK(i + 1, a, ls, sum, k) == true) {
            return true;
        }

        ls.remove(ls.size() - 1);
        sum -= a[i];
        if (GeneSubseqSumK(i + 1, a, ls, sum, k) == true) {
            return true;
        }
        return false;
    }

    public void print(ArrayList<Integer> ls) {
        for (int i : ls) {
            System.out.print(i + " ");
        }
        System.out.println();
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
        GenerateOnlyOneSubSeqWithSumK gosk = new GenerateOnlyOneSubSeqWithSumK();
        ArrayList<Integer> ls = new ArrayList<>();

        boolean found = gosk.GeneSubseqSumK(0, a, ls, 0, k);
        if (!found) {
            System.out.println("No subsequence found");
        }

        s.close();
    }
}
