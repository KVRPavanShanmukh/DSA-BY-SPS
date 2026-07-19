
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Matrix01 {

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] visited = new int[n][m];
        int[][] distance = new int[n][m];

        Queue<int[]> q = new LinkedList<>();

        // Start BFS from all 0's
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j, 0});
                    visited[i][j] = 1;
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];
            int dis = curr[2];

            distance[row][col] = dis;

            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if (newRow >= 0 && newRow < n
                        && newCol >= 0 && newCol < m
                        && visited[newRow][newCol] == 0) {

                    visited[newRow][newCol] = 1;
                    q.add(new int[]{newRow, newCol, dis + 1});
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of Rows : ");
        int n = s.nextInt();
        int grid[][] = new int[n][n];
        System.out.println("Enter Grid (0/1):");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.nextInt();
            }
        }

        Matrix01 m01 = new Matrix01();
        int ans[][] = m01.updateMatrix(grid);

        System.out.println("Distance grid is : ");

        for (int[] i : ans) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
