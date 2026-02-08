package DSA2.Graph;
import java.util.*;

public class BellmanFordAlgorithm {
    public static void main(String[] args) {

    }
    public static int[] bellmanFord(int V, int[][] edges, int src) {
        // create adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2])); // directed graph
        }

        // distance array
        int[] dist = new int[V];
        Arrays.fill(dist, 100000000);
        dist[src] = 0;

        for (int j = 0; j < V; j++) {
            for (int i = 0; i < V; i++) {
                int u = i;
                for (Pair p : adj.get(i)) {
                    int v = p.node;
                    int wt = p.wt;
                    if (dist[u] != 100000000 && dist[u] + wt < dist[v]) {
                        if (j == V - 1) return new int[]{-1}; // negative cycle is present, so return {-1}
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        return dist;
    }
}
class Tuple3{
    int from, to, wt;
    public Tuple3(int from, int to, int wt){
        this.from = from;
        this.to = to;
        this.wt = wt;
    }
}
