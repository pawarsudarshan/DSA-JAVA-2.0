package DSA2.Graph;
import java.util.*;
// Topological sorting is only possible for DAG (Directed Acyclic Graph)
// after completing the DFS call for a node, put it in stack
// this way we ensure, a node will appear before all the nodes after it

public class TopologicalSort {
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{3,0},{1,0},{2,0}};
        System.out.println(topoSort(V, edges));
    }
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfsTopoSort(adj,i,visited,stack);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
    public static void dfsTopoSort(List<List<Integer>> adj, int currNode, boolean[] visited, Stack<Integer> stack){
        visited[currNode] = true;
        for(int node:adj.get(currNode)){
            if(!visited[node]){
                dfsTopoSort(adj, node, visited, stack);
            }
        }
        stack.push(currNode);
    }
}
