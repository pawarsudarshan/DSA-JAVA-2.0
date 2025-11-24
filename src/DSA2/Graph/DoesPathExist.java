package DSA2.Graph;

import java.util.ArrayList;
import java.util.List;

public class DoesPathExist {
    public static void main(String[] args) {
        int[][] adj = {{2, 3, 1}, {0}, {0, 4}, {0}, {2}};
        List<List<Integer>> graph = new ArrayList<>();

        for (int[] arr : adj) {
            List<Integer> list = new ArrayList<>();
            for (int x : arr) {
                list.add(x);
            }
            graph.add(list);
        }
    }
//    GfG question solution
    public static boolean checkPath(int V, int[][] edges, int src, int dest) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[V];
        vis[src] = true;
        return dfs(graph,vis,src,dest);
    }
    public static boolean dfs(List<List<Integer>> graph, boolean[] vis, int src, int dest){
        if(src==dest) return true;

        for(int node:graph.get(src)){
            if(!vis[node]){
                vis[node] = true;
                if(dfs(graph,vis,node,dest)) return true;
            }
        }

        return false;
    }
}
