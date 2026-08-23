
import java.util.*;

class FindAllNumsDisapperedInArray2 {

    public List<List<Integer>> findDisappearedNumbers(int[] a, int l, int u) {
        int n = a.length;
        List<List<Integer>> als = new ArrayList<>();
        Arrays.sort(a);

        long i = l;
        for (int val : a) {
            if (val < l || val > u) {
                continue;
            }

            if (i < val) {
                als.add(Arrays.asList((int) i, val - 1));
            }

            i = Math.max(i, (long) val + 1);
        }
        if (i <= u) {
            als.add(Arrays.asList((int) i, u));
        }

        return als;
    }

    public static void main(String[] args) {
        int a[] = {3, 9, 7};
        int l = 1;
        int u = 12;
        FindAllNumsDisapperedInArray2 fan = new FindAllNumsDisapperedInArray2();
        System.out.println("Missing numbers are : " + fan.findDisappearedNumbers(a, l, u));
    }
}
