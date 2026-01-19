package DSA2.Graph;
import DSA2.BinaryTree.Pair;
import java.util.*;

// Graph can have multiple components

public class DetectCycleInGraph {
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{1,2},{1,0},{0,2},{2,3}};
        System.out.println(isCycle(V,edges));
    }

    public static boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Pair> q = new LinkedList<>();
        boolean[] visited = new boolean[V];

        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                q.add(new Pair(i,-1));
                visited[i] = true;
            }

            while (!q.isEmpty()) {
                Pair p = q.poll();
                for (int node : adj.get(p.first)) {
                    if (!visited[node]) {
                        visited[node] = true;
                        q.add(new Pair(node, p.first));
                    } else if (visited[node] && node != p.second) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
