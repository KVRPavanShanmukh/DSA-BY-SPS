
import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

    public static int[][] MergeIntervals(int intervals[][], int n) {
        List<int[]> ls = new ArrayList<>();

        int i = 0;
        while (i < n) {
            int st = intervals[i][0];
            int en = intervals[i][1];

            int j = i + 1;
            while (j < n && intervals[j][0] <= en) {
                en = Math.max(en, intervals[j][1]);
                j++;
            }
            i = j;
            ls.add(new int[]{st, en});
        }
        return ls.toArray(new int[n][]);
    }

    public static void main(String[] args) {
// A 3x3 matrix initialized directly
        int[][] matrix = {
            {1, 2},
            {1, 4},
            {4, 6},
            {7, 9}
        };
    }
}
