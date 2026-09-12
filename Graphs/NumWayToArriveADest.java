/*
You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any
intersection from any other intersection and that there is at most one road between any two intersections.
You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between
intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from
intersection 0 to intersection n - 1 in the shortest amount of time.
Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large,
return it modulo 109 + 7.

Example 1:
Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
Output: 4
Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
The four ways to get there in 7 minutes are:
- 0 ➝ 6
- 0 ➝ 4 ➝ 6
- 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
- 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6

Example 2:
Input: n = 2, roads = [[1,0,10]]
Output: 1
Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.

Constraints:
1 <= n <= 200
n - 1 <= roads.length <= n * (n - 1) / 2
roads[i].length == 3
0 <= ui, vi <= n - 1
1 <= timei <= 109
ui != vi
There is at most one road connecting any two intersections.
You can reach any intersection from any other intersection.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NumWayToArriveADest {
    public static final int mod = (int) (1e9 + 7);

    public int countPaths(int n, int[][] roads) {
        List<List<long[]>> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ls.add(new ArrayList<>());
        }

        for (int[] i : roads) {
            ls.get(i[0]).add(new long[]{i[1], i[2]});
            ls.get(i[1]).add(new long[]{i[0], i[2]});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;

        // PriorityQueue storing {cost, node}, ordered by cost
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long cost = current[0];
            int node = (int) current[1];

            if (cost > dist[node]) {
                continue;
            }

            for (long[] i : ls.get(node)) {
                int next = (int) i[0];
                long edW = i[1];

                if (cost + edW < dist[next]) {
                    dist[next] = cost + edW;
                    ways[next] = ways[node];
                    pq.add(new long[]{dist[next], next});
                } else if (cost + edW == dist[next]) {
                    ways[next] = (ways[next] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1];
    }

    public static void main(String[] args) {
        NumWayToArriveADest solver = new NumWayToArriveADest();
        int n = 7;
        int[][] roads = {
            {0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3},
            {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1},
            {0, 4, 5}, {4, 6, 2}
        };
        System.out.println("Output: " + solver.countPaths(n, roads)); // Expected: 4
    }
}
