
import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public boolean dfs(int node, int col, int[] color, int[][] graph) {

        color[node] = col;

        for (int neighbour : graph[node]) {

            if (color[neighbour] == -1) {

                if (!dfs(neighbour, 1 - col, color, graph))
                    return false;

            } else if (color[neighbour] == col) {

                return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {

            if (color[i] == -1) {

                if (!dfs(i, 0, color, graph))
                    return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //BLAHH BLAHH BLAHHH!!
    }
}