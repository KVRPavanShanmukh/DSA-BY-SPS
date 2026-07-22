
import java.util.ArrayList;
import java.util.Scanner;

/*

DFS(node)
Mark node visited
Print node
For every neighbour
    if neighbour not visited
         DFS(neighbour)

 */
public class DFS {

    public void DepthFirstSearch(int node, ArrayList<ArrayList<Integer>> als, boolean[] visitedNodes) {
        //as we start from here, we already visited it
        visitedNodes[node] = true;

        //print the nodes as Only one node will be printed for each func call.
        System.out.print(node + " ");

        //For each node, we explore its neighbors, with a recursive call.
        //After the exploration of neighbors, as we have to come back to the initial node, we use recursion.
        for (int neighbor : als.get(node)) {
            if (!visitedNodes[neighbor]) {
                DepthFirstSearch(neighbor, als, visitedNodes);
            }
        }
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
        DFS dfs = new DFS();

        System.out.println("DFS is : ");
        dfs.DepthFirstSearch(0, als, visitedNodes);
    }
}
