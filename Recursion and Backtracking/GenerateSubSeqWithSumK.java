
import java.util.ArrayList;
import java.util.Scanner;

public class GenerateSubSeqWithSumK {

    public void GeneSubseqSumK(int i, int a[], ArrayList<Integer> ls, int sum, int k) {
        if (i == a.length) {
            if (sum == k) {
                print(ls);
            }
            return;
        }

        ls.add(a[i]);
        sum += a[i];
        GeneSubseqSumK(i + 1, a, ls, sum, k);

        ls.remove(ls.size() - 1);
        sum -= a[i];
        GeneSubseqSumK(i + 1, a, ls, sum, k);
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
        GenerateSubSeqWithSumK gsk = new GenerateSubSeqWithSumK();
        ArrayList<Integer> ls = new ArrayList<>();

        gsk.GeneSubseqSumK(0, a, ls, 0, 2);
        gsk.print(ls);
        s.close();
    }
}
