/*
Path With Minimum Effort
Problem Statement: You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of the cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e.,0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
Example 1:
Input:
  
heights = [[1, 2, 2], [3, 8, 2], [5, 3, 5]]  
Output:
 2  
Explanation:
  The route [1, 3, 5, 3, 5] has a maximum absolute difference of 2 in consecutive cells.  
This is better than the route [1, 2, 2, 2, 5], where the maximum absolute difference is 3.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinDiff {

    public int PathWMD(int a[][]) {
        // Create a priority queue to store the cells and their respective distance from the source
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(k -> k[0]));
        int n = a.length;
        int m = a[0].length;

        //dist arr to calc distance
        int[][] dist = new int[n][m];
        for (int[] i : dist) {
            //All are unreachable initially (Dijkstra's algo)
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        dist[0][0] = 0; //src node
        pq.add(new int[]{0, 0, 0});   //pushing src cell into pq

        //up,right,down,left
        int directionOfRow[] = {-1, 0, 1, 0};
        int directionOfCol[] = {0, 1, 0, -1};

        // Start the Dijkstra algorithm
        while (!pq.isEmpty()) {
            int currentCell[] = pq.poll();
            int diff = currentCell[0];
            int row = currentCell[1];
            int col = currentCell[2];

            //If we reach destination cell, return it.
            if (row == n - 1 && col == m - 1) {
                return diff;
            }

            //If we still didn't reached destination cell. Check its frnds
            //Check in 4 directions specified in the problem.
            for (int i = 0; i < 4; i++) {
                int newRow = row + directionOfRow[i];
                int newCol = col + directionOfCol[i];

                //If I am in a valid cell,calc minEffort needed
                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m) {
                    int minEffort = Math.max(Math.abs(a[row][col] - a[newRow][newCol]), diff);

                    if (minEffort < dist[newRow][newCol]) {
                        dist[newRow][newCol] = minEffort;
                        pq.add(new int[]{minEffort, newRow, newCol});
                    }
                }
            }
        }
        //if no path found to dest
        return 0;
    }

    public static void main(String[] args) {
// Input grid (heights)
        int[][] heights = {
            {1, 2, 2},
            {3, 8, 2},
            {5, 3, 5}
        };
        // Find the minimum effort path
        PathWithMinDiff pwmd = new PathWithMinDiff();

        // Output the result
        System.out.println(pwmd.PathWMD(heights));
    }
}
