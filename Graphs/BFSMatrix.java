
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSMatrix {

    public static void bfs(int start, int[][] graph, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int current = q.poll();
            System.out.print(current + " ");

            for (int neighbour = 0; neighbour < graph.length; neighbour++) {
                if (graph[current][neighbour] == 1 && !visited[neighbour]) {
                    visited[neighbour] = true;
                    q.offer(neighbour);
                }
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
        bfs(0, graph, visited);
    }
}
