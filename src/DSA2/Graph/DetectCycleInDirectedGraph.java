package DSA2.Graph;
import java.util.*;
// maintain a currentPathVisited boolean array to mark the current path nodes

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0, 1}, {0, 3}, {1, 3}};
        System.out.println(isCyclic(V,edges));
    }

    public static boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[V];
        boolean[] currentPathVisited = new boolean[V];

        for(int i=0;i<V;i++){
            Arrays.fill(currentPathVisited,false);
            if(!visited[i]){
                if(isCycleDirectedGraphHelperDFS(adj,visited,currentPathVisited,i)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycleDirectedGraphHelperDFS(List<List<Integer>> adj, boolean[] visited, boolean[] currentPathVisited, int currNode){
        visited[currNode] = true;
        currentPathVisited[currNode] = true;

        for(int node: adj.get(currNode)){
            if(!visited[node]){
                if(isCycleDirectedGraphHelperDFS(adj,visited,currentPathVisited,node)){
                    return true;
                }
            }else if(currentPathVisited[node]){
                return true;
            }
        }

        currentPathVisited[currNode] = false;
        return false;
    }
}
