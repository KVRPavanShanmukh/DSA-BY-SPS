/*
Bellman Ford Algorithm:
Problem Statement: Given a weighted, directed and connected graph of V vertices and E edges, Find the shortest distance
of all the vertices from the source vertex S.
Note: If the Graph contains a negative cycle then return an array consisting of only -1.
Example 1:
Input Format: 
V = 6, 
E = [[3, 2, 6], [5, 3, 1], [0, 1, 5], [1, 5, -3], [1, 2, -2], [3, 4, -2], [2, 4, 3]], 
S = 0
 */
import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordAlgo {

    public int[] BellmanBroAlgo(int V, ArrayList<ArrayList<Integer>> edges, int src) {
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        //for all vertices we iterate.
        for (int i = 0; i < V - 1; i++) {
            //for each vertex.
            for (ArrayList<Integer> ai : edges) {
                //check 
                int currentNode = ai.get(0);
                int nextNode = ai.get(1);
                int CstBtwCurAndNxt = ai.get(2);

                /*
                In the process of relaxation, if the current node's cost from the source plus next node's distance is less than the next
                nodes cost,Then I will update the next node's cost as the sum of the current nodes cost and the distance between both the nodes.*/
                if (dist[currentNode] != Integer.MAX_VALUE && dist[currentNode] + CstBtwCurAndNxt < dist[nextNode]) {
                    dist[nextNode] = dist[currentNode] + CstBtwCurAndNxt;
                }
            }
        }

        //relaxation for last node!!
        for (ArrayList<Integer> ai : edges) {
            int currentNode = ai.get(0);
            int nextNode = ai.get(1);
            int CstBtwCurAndNxt = ai.get(2);

            if (dist[currentNode] != Integer.MAX_VALUE && dist[currentNode] + CstBtwCurAndNxt < dist[nextNode]) {
                int temp[] = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 6;
        int S = 0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
            {
                add(new ArrayList<>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
            }
        };

        BellmanFordAlgo bfa = new BellmanFordAlgo();
        int dist[] = bfa.BellmanBroAlgo(V, edges, S);

        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println("");
    }
}
