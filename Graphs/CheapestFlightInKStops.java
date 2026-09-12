/*
Problem Statement: There are n cities and m edges connected by some number of flights. You are given an array of flights where flights[i] = [ fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost price. You have also given three integers src, dst, and k, and return the cheapest price from src to dst with at most k stops.
If there is no such route, return -1.

Example 1:
Input:
  n = 4  
flights = [[0, 1, 100], [1, 2, 100], [2, 0, 100], [1, 3, 600], [2, 3, 200]]  
src = 0  
dst = 3  
k = 1  
Output:
 700  
Explanation:
 The optimal path with at most 1 stop from city 0 to 3 is through cities [0, 1, 3] with a total cost of 100 + 600 = 700.  
Note that the path [0, 1, 2, 3] is cheaper but is invalid because it uses 2 stops.
 */
import java.util.*;

public class CheapestFlightInKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ls.add(new ArrayList<>());
        }

        // Add edges for the flights to the adjacency list
        for (int[] i : flights) {
            ls.get(i[0]).add(new int[]{i[1], i[2]});
        }

        //dist array to keep track of distance upto itslef.
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, src, 0});

        while (!q.isEmpty()) {
            int current[] = q.poll();
            int stops = current[0];
            int node = current[1];
            int cost = current[2];

            if (stops > k) {
                continue;
            }

            for (int[] i : ls.get(node)) {
                int next = i[0];
                int edW = i[1];

                if (cost + edW < dist[next] && stops <= k) {
                    dist[next] = cost + edW;
                    q.add(new int[]{stops + 1, next, cost + edW});
                }
            }
        }
        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return dist[dst];
    }

    public static void main(String[] args) {
        int n = 4, src = 0, dst = 3, K = 1;

        // Flight routes and their costs
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600},
        {2, 3, 200}};

        CheapestFlightInKStops obj = new CheapestFlightInKStops();

        // Call the method to find the cheapest flight
        int ans = obj.findCheapestPrice(n, flights, src, dst, K);

        // Output the result
        System.out.println("Cheapest Price from Source " + src + " to Destination " + dst + " is : " + ans);
    }
}
