package DSA2.Graph;
import java.util.*;

// using BFS

public class ShortestPathInUndirectedGraph {
    public static void main(String[] args) {
        int V = 9;
        int E = 10;
        int[][] edges = {{0, 1}, {0, 3}, {1, 2}, {3, 4}, {4, 5}, {2, 6}, {5, 6}, {6, 7}, {6, 8}, {7, 8}};
        int src = 0;
        System.out.println(Arrays.toString(shortestPath(V, edges,src)));
    }
    public static int[] shortestPath(int V, int[][] edges, int src) {
        // creating adj list
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]); // bcoz it is undirected graph
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];

        int[] dist = new int[V];

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        q.offer(src);
        visited[src]=true;

        while(!q.isEmpty()){
            int node =  q.poll();
            for(int adjNode : adj.get(node)){
                if(!visited[adjNode]){
                    visited[adjNode]=true;
                    q.offer(adjNode);
                    if(dist[node]!=Integer.MAX_VALUE) {
                        dist[adjNode] = Math.min(dist[adjNode], dist[node] + 1);
                    }
                }
            }
        }

        for(int i=0;i<V;i++){
            if(dist[i]==Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }
}
