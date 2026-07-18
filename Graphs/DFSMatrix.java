
import java.util.Scanner;

public class DFSMatrix {

    public static void dfs(int node, int[][] graph, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbour = 0; neighbour < graph.length; neighbour++) {
            if (graph[node][neighbour] == 1 && !visited[neighbour]) {
                //i.e If there is an edge b/w node and neighboring node, and it is not visited. Then,
                dfs(neighbour, graph, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] graph = new int[V][V];
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        boolean[] visited = new boolean[V];
        dfs(0, graph, visited);
    }
}
