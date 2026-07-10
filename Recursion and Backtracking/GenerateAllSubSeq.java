
import java.util.ArrayList;
import java.util.Scanner;

public class GenerateAllSubSeq {

    public void GeneAllSubSeq(int i, int a[], ArrayList ls) {
        //the moment I reach the array size is my base case
        if (i >= a.length) {
            print(ls);
            return;
        }
        // i have to add ele
        ls.add(a[i]);
        GeneAllSubSeq(i + 1, a, ls);

        // i have to remove ele
        ls.remove(ls.size() - 1);
        GeneAllSubSeq(i + 1, a, ls);
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
        System.out.println("Enter ele's of array: ");
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        System.out.println("The Subsequences are : ");

        GenerateAllSubSeq gs = new GenerateAllSubSeq();
        gs.GeneAllSubSeq(0, a, new ArrayList<>());

        ArrayList<Integer> ls = new ArrayList<>();
        gs.print(ls);
        s.close();
    }
}
