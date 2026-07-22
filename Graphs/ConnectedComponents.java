
import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents extends DFS {

    public int ConnectedComponentsInAGraph(ArrayList<ArrayList<Integer>> als, int V, boolean visited[]) {
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DepthFirstSearch(i, als, visited);
                // because i is the first unvisited node of the next component.
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of Vertices in Graph : ");
        int v = s.nextInt();

        System.out.println("Enter number of Edges in Graph : ");
        int e = s.nextInt();

        System.out.println("Creating the paths for each node in the Graph : ");
        ArrayList<ArrayList<Integer>> als = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            als.add(new ArrayList<>());
        }

        System.out.println("Enter Vertices and Edges of the Graph : ");
        for (int i = 0; i < e; i++) {
            int st = s.nextInt();
            int en = s.nextInt();

            als.get(st).add(en);
            als.get(en).add(st);
        }

        boolean visitedNodes[] = new boolean[v];
        ConnectedComponents cc = new ConnectedComponents();

        int components = cc.ConnectedComponentsInAGraph(als, v, visitedNodes);

        System.out.println("Number of Connected Components : ");
        System.out.println(components);
    }
}
