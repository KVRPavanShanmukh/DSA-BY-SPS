/*
Companies asked:
 Amazon ✯   Microsoft ✯   Facebook ✯   Bloomberg ✯   Google ✯   LinkedIn   Apple   Oracle   Uber   Salesforce   ByteDance   tiktok   DoorDash   Docusign   SAP   Karat   Adobe   Qualtrics   Goldman Sachs   Paypal   Nvidia   VMware   ServiceNow   Shopee   eBay   Snapchat   Dropbox   Square   Twitch   Cruise Automation   Yandex   Tesla   Samsung   Siemens   turing   Yahoo   Walmart Labs   Disney   Citadel   Snowflake   Ozon  

Ques:
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the
number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 
 
 */

import java.util.Scanner;

public class NumberOfIslands {

    public void dfs(int row, int col, char[][] grid, boolean[][] visited) {
        // Boundary Check
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }

        // Water or Already Visited
        if (grid[row][col] == '0' || visited[row][col]) {
            return;
        }

        // Mark Visited
        visited[row][col] = true;

        // Visit 4 Directions
        dfs(row - 1, col, grid, visited); // Up
        dfs(row + 1, col, grid, visited); // Down
        dfs(row, col - 1, grid, visited); // Left
        dfs(row, col + 1, grid, visited); // Right
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int islands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, grid, visited);
                    islands++;
                }
            }
        }
        return islands;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of Rows : ");
        int rows = s.nextInt();

        System.out.print("Enter number of Columns : ");
        int cols = s.nextInt();

        char[][] grid = new char[rows][cols];
        System.out.println("Enter Grid (0 or 1) : ");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = s.next().charAt(0);
            }
        }

        NumberOfIslands noi = new NumberOfIslands();
        int islands = noi.numIslands(grid);
        System.out.println("Number of Islands : " + islands);
        s.close();
    }
}


/*
Pattern Recognition

You now know two DFS patterns.

Pattern 1: Graph
visited[node] = true;

for (int neighbour : adj.get(node)) {

    if (!visited[neighbour]) {

        dfs(neighbour);

    }

}
Pattern 2: Grid
visited[row][col] = true;

dfs(up);
dfs(down);
dfs(left);
dfs(right);

or the cleaner direction-array version.

This is the Big Realization ⭐

Graph problems are of two types:

Type 1: Explicit Graph

You are given:

Adjacency List
Adjacency Matrix

Examples:

DFS
BFS
Connected Components
Number of Provinces
Type 2: Implicit Graph (Grid)

The graph is hidden inside a matrix.

Examples:

Number of Islands
Flood Fill
Rotten Oranges
Surrounded Regions
Pacific Atlantic Water Flow

Once you realize every cell is a node and adjacent cells are neighbours, these problems become much easier.

 */
