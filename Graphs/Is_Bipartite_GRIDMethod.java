
import java.util.Arrays;
import java.util.Scanner;

class Is_Bipartite_GRIDMethod {

    public static boolean dfs(int node, int col, int[] color, int[][] graph) {

        color[node] = col;

        for (int neighbour = 0; neighbour < graph.length; neighbour++) {
            if (graph[node][neighbour] == 1) {
                if (color[neighbour] == -1) {
                    if (!dfs(neighbour, 1 - col, color, graph)) {
                        return false;
                    }
                } else if (color[neighbour] == col) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter vertices and edges : ");
        int vertices = s.nextInt();
        int edgessss = s.nextInt();

        int[][] graph = new int[vertices][vertices];
        for (int i = 0; i < edgessss; i++) {
            int u = s.nextInt();
            int v = s.nextInt();

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        System.out.println(isBipartite(graph));
    }
}
