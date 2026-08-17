
import java.util.Arrays;


public class Non_Overlapping_Intervals {

    public static int NonOVerlappingIntervals(int intervals[][], int n) {
        int c = 0;
        int i = 0;
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

        while (i < n) {
            int st = intervals[i][0];
            int en = intervals[i][1];

            int j = i + 1;
            while (j < n && intervals[j][0] < en) { //here the <= doesn't mean to be overlapping.
                c++;
                j++;
            }
            i = j;
        }
        return c;
    }

    public static void main(String[] args) {
        // A 3x3 matrix initialized directly
        int[][] matrix = {
            {1, 2},
            {2, 3},
            {3, 4},
            {1, 3}
        };
        System.out.println(NonOVerlappingIntervals(matrix, matrix.length));
    }
}


                                        
                                        // GREEDY COMPLETED