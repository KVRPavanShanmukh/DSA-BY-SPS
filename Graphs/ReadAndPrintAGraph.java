/*
Problem Statement:
Given an undirected graph with V vertices and E edges, read the graph and print its
adjacency list.

Input Format
5 6
0 1
0 2
1 2
1 3
2 4
3 4
First line:
V = Number of vertices
E = Number of edges
Next E lines contain one edge each.
Expected Output
0 -> 1 2
1 -> 0 2 3
2 -> 0 1 4
3 -> 1 4
4 -> 2 3
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ReadAndPrintAGraph {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        System.out.println("Enter number of Nodes in Graph : ");
        int V = s.nextInt();
        System.out.println("Enter number of Edges in Graph : ");
        int E = s.nextInt();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {

            int u = s.nextInt();
            int v = s.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        //To print:
        //for each vertex
        for (int i = 0; i < V; i++) {
            System.out.print(i + "-->");
            for (int node : adj.get(i)) {
                System.out.print(node + " ");
            }
            System.out.println();
        }

        s.close();
    }
}
