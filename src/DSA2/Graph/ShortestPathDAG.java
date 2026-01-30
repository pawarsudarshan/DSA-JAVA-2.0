package DSA2.Graph;
import java.util.*;

// do a TopoSort
// calculate distances

public class ShortestPathDAG {
    public static void main(String[] args) {
    }
    public static int[] shortestPath(int V, int E, int[][] edges) {
        List<List<Pair>> adj = new  ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
        }

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<V;i++){
            if(!visited[i]){
                topoSort(adj,i,visited,stack);
            }
        }

        int src = 0;
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        while(!stack.isEmpty()){
            int node = stack.peek();
            stack.pop();
            for(Pair p:adj.get(node)){
                if(dist[node]!= Integer.MAX_VALUE && dist[p.node]>dist[node]+p.wt){
                    dist[p.node]=dist[node]+p.wt;
                }
            }
        }
        for(int i=0;i<V;i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        return dist;
    }

    public static void topoSort(List<List<Pair>> adj, int node, boolean[] visited, Stack<Integer> st){
        visited[node] = true;

        for(Pair p:adj.get(node)){
            if(!visited[p.node]){
                topoSort(adj,p.node,visited,st);
            }
        }

        st.push(node);
    }
}
class Pair{
    int node, wt;
    public Pair(int node, int wt){
        this.node = node;
        this.wt = wt;
    }
}
