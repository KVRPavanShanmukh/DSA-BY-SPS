/*
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed
edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal
to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it
is impossible for all the n nodes to receive the signal, return -1.

Example 1:
Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2

Example 2:
Input: times = [[1,2,1]], n = 2, k = 1
Output: 1

Example 3:
Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class NetworkDelay {

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> ls = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            ls.add(new ArrayList<>());
        }
        for (int i[] : times) {
            int u = i[0];
            int v = i[1];
            int w = i[2];
            ls.get(u).add(new int[]{v, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(grid -> grid[0]));
        pq.add(new int[]{0, k});

        int distance[] = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        while (!pq.isEmpty()) {
            int curr[] = pq.poll();
            int dist = curr[0];
            int node = curr[1];
            for (int[] frnd : ls.get(node)) {
                int v = frnd[0];
                int wt = frnd[1];
                if (distance[v] > dist + wt) {
                    distance[v] = dist + wt;
                    pq.add(new int[]{distance[v], v});
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(distance[i], ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter number of nodes (n): ");
            int n = s.nextInt();

            System.out.print("Enter starting node (k): ");
            int k = s.nextInt();

            System.out.print("Enter number of edges: ");
            int edgesCount = s.nextInt();

            int[][] grid = new int[edgesCount][3];
            System.out.println("Enter each edge as 'u v w' (source, destination, weight):");
            for (int i = 0; i < edgesCount; i++) {
                grid[i][0] = s.nextInt();
                grid[i][1] = s.nextInt();
                grid[i][2] = s.nextInt();
            }

            NetworkDelay nd = new NetworkDelay();
            System.out.println("Network Delay Time : " + nd.networkDelayTime(grid, n, k));
        } catch (Exception e) {
            System.err.println("Invalid input format.");
        }
    }
}
