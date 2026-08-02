import java.util.*;

public class Shortest_Path_DAG {
    /*
     * Performs DFS to generate the Topological Ordering of the graph.
     * A node is pushed into the stack only after all its outgoing
     * neighbours have been processed.
     */
    private void topoSort(int node, List<List<int[]>> ls, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;

        for (int[] neighbor : ls.get(node)) {
            // neighbor[0] -> Destination vertex
            // neighbor[1] -> Edge weight
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
        /*
         * Convert the edge list into an adjacency list.
            e[i][0] -> Source
            e[i][1] -> Destination
            e[i][2] -> Weight
         */
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
                // Traverse all outgoing edges.
                for (int[] neighbor : adj.get(node)) {
                    int v = neighbor[0];
                    int wt = neighbor[1];
                    /*
                     * Relax the edge.
                        If reaching 'v' through the current node
                        gives a shorter distance, update it.
                     */

                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
        }

        /*
         * Replace infinity with -1.
         * These vertices are unreachable from the source.
         */
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }

    public static void main(String[] args) {

        int N = 6;
        int M = 7;

        int[][] edges = {
            {0, 1, 2},
            {0, 4, 1},
            {4, 5, 4},
            {4, 2, 2},
            {1, 2, 3},
            {2, 3, 6},
            {5, 3, 1}
        };

        Shortest_Path_DAG spdag = new Shortest_Path_DAG();
        int[] result = spdag.shortestPath(N, M, edges);
        System.out.println("Shortest path from source vertex 0:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}