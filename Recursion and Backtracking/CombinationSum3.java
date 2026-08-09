
import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    class Solution {

        public void Combinations(int sum, int last, List<Integer> ls, int k, List<List<Integer>> als) {
            if (ls.size() == k && sum == 0) {
                als.add(new ArrayList<>(ls));
                return; //  backtracking starts here with returning.
            }

            if (sum <= 0 || ls.size() > k) {
                return;
            }

            for (int j = last; j <= 9; j++) {
                if (j <= sum) {
                    ls.add(j); //adding this into my list==a[0] kind of...
                    Combinations(sum - j, j + 1, ls, k, als); //exploring other possible subsequences
                    ls.remove(ls.size() - 1); //last ele removed for backtracking
                } else {
                    break;
                }
            }
        }

        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> als = new ArrayList<>();
            List<Integer> ls = new ArrayList<>();
            Combinations(n, 1, ls, k, als);
            return als;
        }
    }
    //write main func please!!
}
