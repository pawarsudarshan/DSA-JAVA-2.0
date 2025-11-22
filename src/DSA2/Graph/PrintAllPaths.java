package DSA2.Graph;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPaths {
    public static void main(String[] args) {
        int[][] adj = {{1,2}, {0,3}, {0,3,4}, {1,2}, {2,5,6},{4,6},{4,5}};
        List<List<Integer>> graph = new ArrayList<>();

        for (int[] arr : adj) {
            List<Integer> list = new ArrayList<>();
            for (int x : arr) {
                list.add(x);
            }
            graph.add(list);
        }
        System.out.println(printAllPaths(graph,0,6));
    }
    public static List<String> printAllPaths(List<List<Integer>> graph, int src, int dest){
        // using DFS
        boolean[] visited = new boolean[graph.size()];
        List<String> allPaths = new ArrayList<>();
        dfs(graph,0,dest,String.valueOf(0),visited,allPaths);
        return allPaths;
    }
    public static void dfs(List<List<Integer>> graph, int curr, int dest, String path, boolean[] visited, List<String> allPaths){
        if(curr==dest){
            allPaths.add(path);
            return;
        }

        visited[curr] = true;

        for(int node: graph.get(curr)){
            if(!visited[node]){
                dfs(graph,node,dest,path+String.valueOf(node),visited,allPaths);
            }
        }
        visited[curr] = false;
    }
}
