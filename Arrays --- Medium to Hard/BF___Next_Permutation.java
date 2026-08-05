
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BF___Next_Permutation {

    static List<List<Integer>> als = new ArrayList<>();

    public static void GeneratePermutations(int i, int a[]) {
        if (i == a.length) {
            List<Integer> ls = new ArrayList<>();
            for (int k = 0; k < a.length; k++) {
                ls.add(a[k]);
            }
            if (!als.contains(ls)) {
                als.add(ls);
            }
            return;
        }
        for (int i1 = i; i1 < a.length; i1++) {
            int temp = a[i];
            a[i] = a[i1];
            a[i1] = temp;
            GeneratePermutations(i + 1, a);
            int temp1 = a[i];
            a[i] = a[i1];
            a[i1] = temp1;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        List<Integer> originalInputList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
            originalInputList.add(a[i]);
        }
        Arrays.sort(a);
        GeneratePermutations(0, a);
        als.sort((list1, list2) -> {
            for (int i = 0; i < list1.size(); i++) {
                int cmp = list1.get(i).compareTo(list2.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return 0;
        });

        System.out.println("Permutations are : " + als);

        int targetIndex = als.indexOf(originalInputList);

        if (targetIndex != -1) {
            if (targetIndex == als.size() - 1) {
                System.out.println("Next Permutation: " + als.get(0));
            } else {
                System.out.println("Next Permutation: " + als.get(targetIndex + 1));
            }
        }
        s.close();
    }
}
