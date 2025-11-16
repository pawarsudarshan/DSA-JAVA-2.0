package DSA2.Graph;
import java.util.*;

public class DFS {
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

        System.out.println(dfs(graph));
    }

    public static List<Integer> dfs(List<List<Integer>> graph) {
        List<Integer> res = new ArrayList<>(); // for storing DFS of graph
        boolean[] visited = new boolean[graph.size()]; // for tracking visited nodes
        int n = graph.size();

        for(int i = 0; i < n; i++){
            if(!visited[i]){ // check if the nodes is previously explored
                visited[i] = true; // add to visited
                res.add(i); // add to DFS
                dfsHelper(graph,i,visited,res);
            }
        }
        return res;
    }

    public static void  dfsHelper(List<List<Integer>> graph, int i, boolean[] visited, List<Integer> res){
        for(int node: graph.get(i)){
            if(!visited[node]){
                visited[node] = true; // add to visited
                res.add(node); // add to DFS
                dfsHelper(graph,node,visited,res);
            }
        }
    }
}
