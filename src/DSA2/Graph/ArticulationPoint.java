package DSA2.Graph;
import java.util.*;

public class ArticulationPoint {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[][] edges = {{0, 1}, {1, 4}, {4, 3}, {4, 2}, {2, 3}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        System.out.println(articulationPoints(V, adj));
    }

    private static int time;

    public static ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        boolean[] visited = new boolean[V];
        int[] tin = new int[V];
        int[] low = new int[V];

        time = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adj, visited, tin, low, set, i, -1);
            }
        }

        res.addAll(set);
        if (res.isEmpty()) {
            res.add(-1);
            return res;
        }
        
        res.sort(null);
        return res;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] tin, int[] low, Set<Integer> set, int node, int parent) {
        visited[node] = true;
        tin[node] = low[node] = ++time;
        int child = 0;

        for (int adjNode : adj.get(node)) {
            if (adjNode == parent) continue;

            if (!visited[adjNode]) {
                child++;
                dfs(adj, visited, tin, low, set, adjNode, node);

                low[node] = Math.min(low[node], low[adjNode]);

                if (parent != -1 && low[adjNode] >= tin[node]) {
                    // this is a cut vertex
                    set.add(node);
                }
            } else {
                // back edge
                low[node] = Math.min(low[node], tin[adjNode]);
            }
        }

        if (parent == -1 && child > 1) {
            set.add(node);
        }
    }
}
