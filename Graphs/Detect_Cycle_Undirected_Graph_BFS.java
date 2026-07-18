
import java.util.*;

class Pair {
    int node;
    int parent;

    Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

public class Detect_Cycle_Undirected_Graph_BFS {

    private boolean detectCycle(int start, ArrayList<ArrayList<Integer>> adj,
            boolean[] visited) {

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(start, -1));
        visited[start] = true;

        while (!q.isEmpty()) {
            Pair current = q.poll();

            int node = current.node;
            int parent = current.parent;

            for (int neighbour : adj.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.offer(new Pair(neighbour, node));
                } else if (neighbour != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycle(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter number of Vertices: ");
            int V = s.nextInt();
            
            System.out.print("Enter number of Edges: ");
            int E = s.nextInt();
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            
            System.out.println("Enter the edges:");
            for (int i = 0; i < E; i++) {
                int u = s.nextInt();
                int v = s.nextInt();
                
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            
            Detect_Cycle_Undirected_Graph_BFS obj = new Detect_Cycle_Undirected_Graph_BFS();
            if (obj.isCycle(V, adj)) {
                System.out.println("Cycle Detected");
            } else {
                System.out.println("No Cycle");
            }
        }catch(Exception e){
            System.out.println("Not possible to find a cycle! Good Night!!");
        }
    }
}
