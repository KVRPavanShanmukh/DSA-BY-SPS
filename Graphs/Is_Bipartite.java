
import java.util.ArrayList;
import java.util.Scanner;

public class Is_Bipartite {

    public static boolean isBipartite(int node, int col, int color[], ArrayList<ArrayList<Integer>> ls) {
        color[node] = col;

        for (int i : ls.get(node)) {
            if (color[i] == -1) {
                isBipartite(i, col, color, ls);
            } else if (color[i] == col) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite_Final(int V, ArrayList<ArrayList<Integer>> adj) {
        int color[] = new int[V];
        for (int i = 0; i < V; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (isBipartite(i, 0, color, adj) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of Rows : ");
        int v = s.nextInt();

        System.out.print("Enter number of Columns : ");
        int a[] = new int[v];

        Is_Bipartite isb = new Is_Bipartite();
        isb.isBipartite(0, 0, a, new ArrayList<>());
    }
}
