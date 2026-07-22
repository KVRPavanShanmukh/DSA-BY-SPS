
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Is_Bipartite_ListOfLists {

    public static boolean dfs(int node, int col, int[] color, ArrayList<ArrayList<Integer>> adj) {
        color[node] = col;

        for (int neighbour : adj.get(node)) {
            if (color[neighbour] == -1) {
                if (!dfs(neighbour, 1 - col, color, adj)) {
                    return false;
                }
            } else if (color[neighbour] == col) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, adj)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);

        }
        System.out.println(isBipartite(V, adj));
    }
}
