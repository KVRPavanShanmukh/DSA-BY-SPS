import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervals {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // 1. Add all intervals that end BEFORE newInterval starts (No overlap on left)
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 2. Merge all overlapping intervals with newInterval
        // Overlap condition: interval's start <= newInterval's end
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Add the fully merged newInterval
        result.add(newInterval);

        // 3. Add all remaining intervals that start AFTER newInterval ends (No overlap on right)
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert List<int[]> back to int[][]
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        InsertIntervals solver = new InsertIntervals();

        // Example 1
        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        int[][] res1 = solver.insert(intervals1, newInterval1);
        System.out.println("Example 1: " + Arrays.deepToString(res1)); // Output: [[1, 5], [6, 9]]

        // Example 2
        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        int[][] res2 = solver.insert(intervals2, newInterval2);
        System.out.println("Example 2: " + Arrays.deepToString(res2)); // Output: [[1, 2], [3, 10], [12, 16]]
    }
}