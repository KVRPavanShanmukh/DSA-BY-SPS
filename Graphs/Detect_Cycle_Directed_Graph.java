
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Detect_Cycle_Directed_Graph {

    public boolean Cycle_Baba(int V, List<List<Integer>> als) {
        int CountOfNodes = 0;

        int inDegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int j : als.get(i)) {
                inDegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int front = q.poll();
            CountOfNodes++;

            for (int i : als.get(front)) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    q.add(i);
                }
            }
        }
        return CountOfNodes != V;
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1);

        Detect_Cycle_Directed_Graph dcdg = new Detect_Cycle_Directed_Graph();
        if (dcdg.Cycle_Baba(V, adj)) {
            System.out.println("Cycle detected"); 
        }else {
            System.out.println("No cycle");
        }
    }
}
