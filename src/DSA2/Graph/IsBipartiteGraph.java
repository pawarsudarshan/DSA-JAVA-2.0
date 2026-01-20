package DSA2.Graph;
import java.util.*;
/*
can color with two colors such that NO two adjacent nodes have the same color
*/
public class IsBipartiteGraph {
    public static void main(String[] args) {
        int V = 7;
        int[][] edges = {{0,1},{1,2},{2,3},{3,4},{4,5},{4,6},{1,5}};
        System.out.println(isBipartiteBFS(V,edges));
        System.out.println(isBipartiteDFS(V,edges));
    }

    // Using BFS
    public static boolean isBipartiteBFS(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] colors =  new int[V];
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0] = true;
        colors[0] = 1;

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            for (int node : adj.get(currNode)) {
                if (!visited[node]) {
                    visited[node] = true;
                    if (colors[currNode] == 1) {
                        colors[node] = 2;
                    } else {
                        colors[node] = 1;
                    }
                    queue.add(node);
                } else if (colors[currNode] == colors[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Using DFS
    public static boolean isBipartiteDFS(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] colors =  new int[V];
        boolean[] visited = new boolean[V];

        colors[0] = 1;
        return isBipartiteDFSHelper(adj,visited,colors,0);
    }

    public static boolean isBipartiteDFSHelper(List<List<Integer>> adj, boolean[] visited, int[] colors, int currNode) {
        visited[currNode] = true;

        for(int node: adj.get(currNode)){
            if(!visited[node]) {
                if(colors[currNode] == 1) {
                    colors[node] = 2;
                }else{
                    colors[node] = 1;
                }
                if (!isBipartiteDFSHelper(adj, visited, colors, node)) {
                    return false;
                }
            }else if(colors[node] == colors[currNode]) {
                return false;
            }
        }

        return true;
    }
}
