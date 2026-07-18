
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/* 
Idea: Visit all immediate neighbors first, then their neighbors, and so on.

You will need:
Queue
visited[] array

 */
public class BFS {

    public void BreadthFirstSearch(int node, Queue<Integer> q, ArrayList<ArrayList<Integer>> als, boolean[] visitedNodes) {
        //as we start from here, we already visited it
        visitedNodes[node] = true;
        q.add(node);

        while (!q.isEmpty()) {
            int CurrentNode = q.poll();
            System.out.print(CurrentNode + " ");

            //For each node, we explore its neighbors.
            for (int i : als.get(CurrentNode)) {
                if (!visitedNodes[i]) {
                    visitedNodes[i] = true;
                    q.add(i);
                }
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

        Queue<Integer> q = new LinkedList<>();
        boolean visitedNodes[] = new boolean[v];
        BFS bfs = new BFS();
        System.out.println("BFS is : ");
        bfs.BreadthFirstSearch(0, q, als, visitedNodes);
        s.close();
    }
}
