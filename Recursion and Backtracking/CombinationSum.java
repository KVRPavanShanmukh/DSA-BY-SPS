
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationSum {

    private List<List<Integer>> CombinationSumAns(int[] a, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        CombiSum(a, 0, target, ans, new ArrayList<>());
        return ans;
    }

    private void CombiSum(int[] a, int i, int target, List<List<Integer>> ans, List<Integer> ls) {
        if (i == a.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ls));
            }
            return;
        }

        if (a[i] <= target) {
            ls.add(a[i]);
            CombiSum(a, i, target - a[i], ans, ls);
            ls.remove(ls.size() - 1);
        }
        CombiSum(a, i + 1, target, ans, ls);
    }

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter size of array: ");
            int n = s.nextInt();
            int[] a = new int[n];

            System.out.print("Enter array elements: ");
            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }

            System.out.print("Enter target: ");
            int target = s.nextInt();

            CombinationSum cs = new CombinationSum();
            System.out.println("The combinations are:");
            System.out.println(cs.CombinationSumAns(a, target));
        } catch (Exception e) {
            System.err.println("Invalid input");
        }
    }

    boolean CombinationSum2(int[] a, int target) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
