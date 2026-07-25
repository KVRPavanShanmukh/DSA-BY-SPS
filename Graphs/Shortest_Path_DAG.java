
import java.util.*;

public class Shortest_Path_DAG {

    private void topoSort(int node, List<List<int[]>> ls, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;

        for (int[] neighbor : ls.get(node)) {
            if (!vis[neighbor[0]]) {
                topoSort(neighbor[0], ls, vis, st);
            }
        }
        st.push(node);
    }

    public int[] shortestPath(int N, int M, int[][] e) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = e[i][0];
            int v = e[i][1];
            int wt = e[i][2];
            adj.get(u).add(new int[]{v, wt});
        }

        boolean[] vis = new boolean[N];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                topoSort(i, adj, vis, st);
            }
        }

        int[] dist = new int[N];
        Arrays.fill(dist, (int) 1e9);
        dist[0] = 0;

        while (!st.isEmpty()) {
            int node = st.pop();

            if (dist[node] != (int) 1e9) {
                for (int[] neighbor : adj.get(node)) {
                    int v = neighbor[0];
                    int wt = neighbor[1];

                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }
}

class Main {

    public static void main(String[] args) {
        int N = 6, M = 7;
        int[][] edges = {
            {0, 1, 2}, {0, 4, 1}, {4, 5, 4},
            {4, 2, 2}, {1, 2, 3}, {2, 3, 6}, {5, 3, 1}
        };

        Shortest_Path_DAG spdag = new Shortest_Path_DAG();
        int[] result = spdag.shortestPath(N, M, edges);
        System.out.println("Shortest path from 0(as it was assumed to be src) is : ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
