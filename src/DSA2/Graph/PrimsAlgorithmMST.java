package DSA2.Graph;
import java.util.*;

public class PrimsAlgorithmMST {
    public static void main(String[] args) {

    }
    public int spanningTree(int V, int[][] edges) {
        // create adj list
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected graph
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];

            adj.get(u).add(new Edge(v, wt));
            adj.get(v).add(new Edge(u, wt));
        }

        // Prims Algorithm
        boolean[] inMST = new boolean[V];

        // Min-heap based on edge weight
        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> a.weight - b.weight);

        // Start from node 0
        pq.add(new Node(0, 0));

        int mstWeight = 0;

        while (!pq.isEmpty()) {

            Node curr = pq.poll();
            int u = curr.vertex;
            int wt = curr.weight;

            // Skip if already included in MST
            if (inMST[u]) continue;

            // Include node in MST
            inMST[u] = true;
            mstWeight += wt;

            // Explore adjacent edges
            for (Edge edge : adj.get(u)) {
                int v = edge.to;
                int edgeWt = edge.weight;

                if (!inMST[v]) {
                    pq.add(new Node(v, edgeWt));
                }
            }
        }

        return mstWeight;
    }
}
class Edge {
    int to;
    int weight;

    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

class Node {
    int vertex;
    int weight;

    Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}
