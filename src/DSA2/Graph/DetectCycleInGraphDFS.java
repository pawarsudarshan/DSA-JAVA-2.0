package DSA2.Graph;
import java.util.*;

// Detect Cycle in Undirected Graph using DFS
// After deep exploring one edge, backtrack to explore other edges as well

public class DetectCycleInGraphDFS {
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{1,2},{2,3}};
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

        boolean[] visited = new boolean[V];
        int[] parent = new int[V];

        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                parent[i] = -1;
                if(isCycleDFS(i, visited, adj, parent))
                    return true;
            }
        }

        return false;
    }

    public static boolean isCycleDFS(int currNode, boolean[] visited, List<List<Integer>> adj, int[] parent){
        visited[currNode] = true;

        for(int node:adj.get(currNode)){
            if (!visited[node]) {
                parent[node] = currNode;
                if (isCycleDFS(node, visited, adj, parent))
                    return true;
            }
            else if(node!=parent[currNode]){
                return true;
            }
        }

        return false;
    }
}
