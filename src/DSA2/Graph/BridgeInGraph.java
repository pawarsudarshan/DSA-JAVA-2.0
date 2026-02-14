package DSA2.Graph;

import java.util.*;

public class BridgeInGraph {
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{1, 2}, {2, 0}, {0, 1}, {0, 3}, {3, 4}};
        int c = 2, d = 0;
        System.out.println(isBridge(V, edges, c, d));
    }

    private static int time = 0;

    public static boolean isBridge(int V, int[][] edges, int c, int d) {
        boolean[] visited = new boolean[V];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // undirected
        }

        int[] tin = new int[V];
        int[] low = new int[V];


        List<Pair4> bridges = new ArrayList<>();

        dfs(adj, visited, tin, low, bridges, 0, 0);

        for (Pair4 pair : bridges) {
            int from = pair.from;
            int to = pair.to;

            if ((from == c && to == d) || (from == d && to == c)) {
                return true;
            }
        }

        return false;
    }

    public static void dfs(List<List<Integer>> adj, boolean[] visited, int[] tin, int[] low, List<Pair4> bridges, int node, int parent) {
        visited[node] = true;
        tin[node] = low[node] = ++time;

        for (int adjNode : adj.get(node)) {
            if (!visited[adjNode]) {
                dfs(adj, visited, tin, low, bridges, adjNode, node);
            }
        }

        // backtracking
        for (int adjNode : adj.get(node)) {
            if (adjNode != parent) {
                low[node] = Math.min(low[node], low[adjNode]);
            }
        }

        if (low[node] > tin[parent]) {
            System.out.println("Found a Bridge: " + parent + " -> " + node);
            bridges.add(new Pair4(parent, node));
        }
    }
}

class Pair4 {
    int from, to;

    public Pair4(int from, int to) {
        this.from = from;
        this.to = to;
    }
}

// solution from gfg, must read and understand the approach
class Solution {
    public int time;
    public int c, d;

    public boolean isBridge(int V, int[][] edges, int c, int d) {
        // creation of adj list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // undirected
        }

        // helper data storages
        boolean[] visited = new boolean[V];
        int[] dis = new int[V];
        int[] low = new int[V];

        // initializing global variables
        time = 0;
        this.c = c;
        this.d = d;

        for (int i = 0; i < V; i++) {
            if (dfs(adj, visited, dis, low, i, -1)) return true;
        }
        return false;
    }

    public boolean dfs(List<List<Integer>> adj, boolean[] visited, int[] dis, int[] low, int node, int parent) {
        visited[node] = true;
        dis[node] = low[node] = ++time;

        for (int adjNode : adj.get(node)) {
            if (adjNode == parent) continue;

            if (!visited[adjNode]) {
                if (dfs(adj, visited, dis, low, adjNode, node)) {
                    return true;
                }
                low[node] = Math.min(low[node], low[adjNode]);

                // check for bridge
                if (low[adjNode] > dis[node]) {
                    if ((adjNode == c && node == d) || (adjNode == d && node == c)) return true;
                }
            } else {
                // back edge
                low[node] = Math.min(low[node], dis[adjNode]);
            }
        }

        return false;
    }
}
