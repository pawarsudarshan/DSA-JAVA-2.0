package DSA2.Graph;
import java.util.*;

// store the parent(from where we are coming from) to every node

public class ShortestPathInWeightedUndirectedGraph {
    public static void main(String[] args) {
        int n = 5, m = 6;
        int[][] edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        System.out.println(shortestPath(n, m, edges));
    }

    // Dijkstra's algorithm to find the shortest path from 1 to n and return path + distance
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // Build adjacency list: 1-indexed, weighted, undirected (u <----w----> v)
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(new Pair(e[1], e[2]));
            adj.get(e[1]).add(new Pair(e[0], e[2]));
        }

        int src = 1, dest = n;

        // --- Distance array: dist[i] = shortest distance from src to i ---
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // --- Parent array for path reconstruction ---
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        // --- Min-heap by (distance, node) ---
        PriorityQueue<DistNode2> pq = new PriorityQueue<>((a, b) -> {
            if (a.dist != b.dist) return a.dist - b.dist;
            return a.node - b.node;
        });

        pq.add(new DistNode2(0, src));

        // --- Dijkstra's main loop ---
        while (!pq.isEmpty()) {
            DistNode2 cur = pq.poll();
            int u = cur.node;

            // Relax edges from u
            for (Pair p : adj.get(u)) {
                int v = p.node, wt = p.wt;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    parent[v] = u;
                    pq.offer(new DistNode2(dist[v], v));
                }
            }
        }

        // --- If dest unreachable, return [-1] ---
        List<Integer> ans = new ArrayList<>();
        if (dist[dest] == Integer.MAX_VALUE) {
            ans.add(-1);
            return ans;
        }

        // --- Reconstruct path: dest -> ... -> src ---
        int t = dest;
        while (t != -1) {
            ans.add(t);
            t = parent[t];
        }

        ans.add(dist[dest]);
        Collections.reverse(ans);
        return ans;
    }
}
