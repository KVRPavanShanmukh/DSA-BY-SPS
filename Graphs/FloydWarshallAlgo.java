/*
Problem Statement: Given a graph of V vertices numbered from 0 to V-1. Find the shortest distances between every pai
 of vertices in a given edge-weighted directed graph. The graph is represented as an adjacency matrix of size n x n.
 Matrix[i][j] denotes the weight of the edge from i to j. If matrix[i][j]=-1, it means there is no edge from i to j.

Example 1:
Input: matrix = [[0, 2, -1, -1], [1, 0, 3, -1], [-1, -1, 0, 1], [3, 5, 4, 0]]  
Output: [[0, 2, 5, 6], [1, 0, 3, 4], [4, 6, 0, 1], [3, 5, 4, 0]]  
Explanation: The matrix stores the shortest distances between vertices. After applying the algorithm (like Floyd-Warshall), the shortest distances between all pairs of vertices are computed. The updated matrix shows the shortest distances, e.g., distance from vertex 0 to vertex 2 is 5, from vertex 1 to vertex 3 is 4, and so on.

Example 2:
Input: matrix = [[0, 25], [-1, 0]]  
Output: [[0, 25], [-1, 0]]  
Explanation: The matrix already contains the shortest distances. Since no further updates are needed, the matrix remains the same.
 */
public class FloydWarshallAlgo {

    public static int[][] FloydBroAlgo(int a[][]) {
        int n = a.length;

        //For each intermediary vertex 'k'
        for (int k = 0; k < n; k++) {

            //Iterating with each index
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // If no intermediate nodes have the ability to make a path from src to current corresponding pair vertex
                    if (a[i][k] == -1 || a[k][j] == -1) {
                        continue;
                    }

                    // No edge between the paired vertices, keep the dist added with intermediary vertex.
                    if (a[i][j] == -1) {
                        a[i][j] = a[i][k] + a[k][j];
                    } else {
                        // Else case we find the shortest distance and update the a[i][j]
                        a[i][j] = Math.min(a[i][j], a[i][k] + a[k][j]);
                    }
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 2, -1, -1},
            {1, 0, 3, -1},
            {-1, -1, 0, -1},
            {3, 5, 4, 0}
        };

        int n = matrix.length;
        int ans[][] = FloydWarshallAlgo.FloydBroAlgo(matrix);   //automatically the lengths of the matrix will be replaced!

        System.out.println("The shortest distance matrix is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ans[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
