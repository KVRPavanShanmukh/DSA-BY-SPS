
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/* 
Problem Statement:
Given an Undirected Graph having unit edge weight, find the shortest path from the source to
all other nodes in this graph. In this problem statement, we have assumed the source vertex
to be ‘0’. If a vertex is unreachable from the source node, then return -1 for that vertex.
 */
public class ShortestPath_UndirGraphs {

    public int[] ShortestPath_UNDIR_GRAPH(int V, List<List<Integer>> als, int Source) {
        int[] dist = new int[V];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        dist[Source] = 0;
        q.add(Source);

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int i : als.get(curr)) {
                if (dist[i] == -1) {
                    dist[i] = dist[curr] + 1;
                    q.add(i);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Vertices : ");
        int v = s.nextInt();
        System.out.println("Enter Edges : ");
        int e = s.nextInt();

        List<List<Integer>> als = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            als.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = s.nextInt();
            int b = s.nextInt();

            als.get(a).add(b);
            als.get(b).add(a);
        }

        System.out.println("Enter the Source Vertex : ");
        int Source = s.nextInt();

        ShortestPath_UndirGraphs spud = new ShortestPath_UndirGraphs();
        int ans[] = spud.ShortestPath_UNDIR_GRAPH(v, als, Source);
        System.out.print("The Shortest Path from source to each node is : ");
        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();

        s.close();
    }
}
