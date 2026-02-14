package DSA2.Graph;

import java.util.*;

public class PrintAllBridgesInGraph {
    private static int time = 0;

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{1, 2}, {2, 0}, {0, 1}, {0, 3}, {3, 4}};
        printBridges(V, edges);
    }

    public static void printBridges(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // undirected
        }

        int[] dis = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];
        List<Pair4> bridges = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adj, visited, dis, low, bridges, i, -1);
            }
        }

        // bridges will be populated with all bridges in the graph
        for (Pair4 p : bridges) {
            System.out.println(p.from + " -> " + p.to);
        }

        if (bridges.isEmpty()) {
            System.out.println("No Bridges");
        }
    }

    public static void dfs(List<List<Integer>> adj, boolean[] visited, int[] dis, int[] low, List<Pair4> bridges, int node, int parent) {
        visited[node] = true;
        dis[node] = low[node] = ++time;

        for (int adjNode : adj.get(node)) {

            if (adjNode == parent) continue;

            if (!visited[adjNode]) {
                dfs(adj, visited, dis, low, bridges, adjNode, node);

                low[node] = Math.min(low[node], low[adjNode]);

                // Bridge condition
                if (low[adjNode] > dis[node]) {
                    bridges.add(new Pair4(node, adjNode));
                }
            } else {
                // Back edge
                low[node] = Math.min(low[node], low[adjNode]);
            }
        }
    }
}














