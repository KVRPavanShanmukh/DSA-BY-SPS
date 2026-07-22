
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortUsing_BFS {

    public int[] TOPOSORT_BFS(int V, ArrayList<ArrayList<Integer>> als) {
        int indegree[] = new int[V];

        //first add ele into list.
        for (int i = 0; i < V; i++) {
            for (int j : als.get(i)) {
                indegree[j]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int topo[] = new int[V];
        int idx = 0;

        while (!q.isEmpty()) {
            int frontNode = q.poll();
            topo[idx++] = frontNode;

            for (int i : als.get(frontNode)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }
        return topo;
    }
    public static void main(String[] args) {
         int V = 6;

        ArrayList<java.util.ArrayList<Integer>> adj = new java.util.ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new java.util.ArrayList<>());
        }

        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        TopologicalSortUsing_BFS tsbfs = new TopologicalSortUsing_BFS();
        int[] ans = tsbfs.TOPOSORT_BFS(V, adj);
        
        System.out.print("Topological Sort using BFS : ");
        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
}