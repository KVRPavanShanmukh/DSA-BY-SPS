// /*
// https://leetcode.com/problems/shortest-path-in-binary-matrix/description/

// DFS(current cell, count)

//     if current cell is destination:
//         update minimum
//         return

//     mark current as visited

//     for all 8 directions:

//         calculate next row/column

//         if next cell is valid
//            AND it is 0
//            AND it is not currently visited:

//               DFS(next cell, count + 1)

//     unmark current cell       ← BACKTRACK
//  */

// import java.util.LinkedList;
// import java.util.Queue;

// class ShortestPathInBinMatrixDFS {

//     int ans;
//     int n;

//     int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

//     public int shortestPathBinaryMatrix(int[][] grid) {
//         n = grid.length;
//         // Start or destination is blocked
//         if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
//             return -1;
//         }

//         ans = Integer.MAX_VALUE;

//         boolean[][] visited = new boolean[n][n];
//         dfs(grid, 0, 0, 1, visited);

//         return ans == Integer.MAX_VALUE ? -1 : ans;
//     }

//     void dfs(int[][] grid, int row, int col, int count, boolean[][] visited) {
//         // No point continuing if this path is already
//         // longer than the best answer found
//         if (count >= ans) {
//             return;
//         }

//         // Destination reached
//         if (row == n - 1 && col == n - 1) {
//             ans = count;
//             return;
//         }

//         visited[row][col] = true;

//         for (int[] dir : directions) {

//             int newRow = row + dir[0];
//             int newCol = col + dir[1];

//             // Check boundaries
//             if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) {
//                 continue;
//             }

//             // Check whether cell is available and unvisited
//             if (grid[newRow][newCol] == 0 && !visited[newRow][newCol]) {
//                 dfs(grid, newRow, newCol, count + 1, visited);
//             }
//         }
//         // BACKTRACK
//         visited[row][col] = false;
//     }
// }

// class ShortestPathInBinMatrixBFS {

//     static class Pair {

//         int row, col, dist;

//         public Pair(int row, int col, int dist) {
//             this.row = row;
//             this.col = col;
//             this.dist = dist;
//         }
//     }

//     public int shortestPathBinaryMatrix(int[][] grid) {
//         int n = grid.length;

//         int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
//         // if we cannot move
//         if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
//             return -1;
//         }

//         boolean[][] visited = new boolean[n][n];
//         Queue<Pair> q = new LinkedList<>();
//         q.add(new Pair(0, 0, 1));
//         visited[0][0] = true;

//         while (!q.isEmpty()) {
//             Pair curr = q.poll();
//             int roww = curr.row;
//             int coll = curr.col;
//             int distance = curr.dist;

//             if (roww == n - 1 && coll == n - 1) {
//                 return distance;
//             }

//             for (int[] dir : directions) {
//                 int newRow = roww + dir[0];
//                 int newCol = coll + dir[1];

//                 if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) {
//                     continue;
//                 }

//                 if (grid[newRow][newCol] == 0 && !visited[newRow][newCol]) {
//                     visited[newRow][newCol] = true;
//                     q.add(new Pair(newRow, newCol, distance + 1));
//                 }
//             }
//         }
//         return -1;
//     }
// }

// public class ShortestPathInBinMatrix {

//     public static void main(String[] args) {
//         //blah blah blah!!
//         ShortestPathInBinMatrixBFS bfs = new ShortestPathInBinMatrixBFS();
        
//         bfs.shortestPathBinaryMatrix(grid);

//     }

// }
