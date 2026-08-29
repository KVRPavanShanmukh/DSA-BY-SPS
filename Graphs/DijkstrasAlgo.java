
import java.util.*;

public class DijkstrasAlgo {

    static class Pair {

        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int[] Dijkstra(List<List<Pair>> graph, int V, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        //tells which pair should come first
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        //initially we get a dist of 0 (src to src)
        dist[src] = 0;
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int currentDist = curr.weight;

            if (currentDist > dist[node]) {
                continue;
            }

            for (Pair edge : graph.get(node)) {
                int neighbor = edge.node;
                int weight = edge.weight;

                int newDist = dist[node] + weight;
                if (newDist < dist[neighbor]) {
                    dist[neighbor] = newDist;
                    pq.add(new Pair(neighbor, newDist));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();

        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            int u = s.nextInt();
            int v = s.nextInt();
            int w = s.nextInt();
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));

            // For directed graph, use ONLY:
            // graph.get(u).add(new Pair(v, w));
        }
        int source = s.nextInt();
        DijkstrasAlgo obj = new DijkstrasAlgo();

        int[] dist = obj.Dijkstra(graph, V, source);
        System.out.println("Shortest distances:");

        for (int i = 0; i < V; i++) {
            System.out.println(source + " -> " + i + " = " + dist[i]);
        }
        s.close();
    }
}
