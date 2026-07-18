
import java.util.ArrayList;
import java.util.Scanner;

public class Read_Graph_As_ListOfLists_And_Edge_Weigths {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of Nodes in Graph : ");
        int n = s.nextInt();
        System.out.println("Enter number of Edges in Graph : ");
        int m = s.nextInt();
        //Adjacency List:
        // List<List<Integer>> ls = new ArrayList<>();
        /*
        Hence, we stored all the neighbors in the particular indexes. In this representation,
        for an undirected graph, each edge data appears twice. For example, nodes 1 and 2 are
        adjacent hence node 2 appears in the list of node 1, and node 1 appears in the list of
        node 2. So, the space needed to represent an undirected graph using its adjacency list
        is 2 x E locations, where E denotes the number of edges. The Space Complexity is O(2*E).
        
        This representation is much better than the adjacency matrix, as matrix representation
        consumes n²locations, and most of them are unused.
         */

        // For Un-Directed Graphs:
        ArrayList<Integer>[] als = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            als[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = s.nextInt();
            int v = s.nextInt();

            als[u].add(v);
            als[v].add(u);
        }

        // For Directed Graphs:
        // ArrayList<Integer>[] dals = new ArrayList[n + 1];
        // for (int i = 0; i <= n; i++) {
        //     dals[i] = new ArrayList<>();
        // }

        // for (int i = 0; i < m; i++) {
        //     int u = s.nextInt();
        //     int v = s.nextInt();

        //     dals[u].add(v);
        //     dals[v].add(u);
        // }

        // To read as List of Lists:
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        System.out.println("Enter number of Nodes in Graph : ");
        int V = s.nextInt();
        int E = s.nextInt();
        System.out.println("Enter number of Edges in Graph : ");
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {

            int u = s.nextInt();
            int v = s.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        /*
        But how are we going to implement it in the adjacency list?
        
        Earlier in the adjacency list, we were storing a list of integers in each index, but for
        weighted graphs, we will store pairs (node, edge weight) in it.
         */
        class Pair {

            int node;
            int weight;

            Pair(int node, int weight) {
                this.node = node;
                this.weight = weight;
            }
        }

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Pair(1, 4));
        graph.get(1).add(new Pair(0, 4));

        graph.get(0).add(new Pair(2, 2));
        graph.get(2).add(new Pair(0, 2));

        s.close();
    }
}
