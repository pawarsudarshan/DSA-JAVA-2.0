package DSA2.Graph;
import java.util.*;

// use ordered set, if we find min distance to a node, remove previous entry of that node from the set

public class DijkstraAlgorithmSetVersion {
    public static void main(String[] args) {

    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        // creating adj list
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0],edge[2]));
        }

        // distance calculation array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        TreeSet<DistNode2> set = new  TreeSet<DistNode2>((a,b)->{
            if(a.dist!=b.dist) return a.dist-b.dist;
            return a.node-b.node;
        });

        set.add(new DistNode2(0, src));

        while(!set.isEmpty()){
            DistNode2 d = set.pollFirst();
            int distanceTillNode = d.dist;
            int u = d.node;

            for(Pair p:adj.get(u)){
                int wt = p.wt;
                int v = p.node;

                if(distanceTillNode + wt < dist[v]){
                    set.remove(new  DistNode2(dist[v],v));
                    dist[v] = distanceTillNode + wt;
                    set.add(new  DistNode2(dist[v],v));
                }
            }
        }

        return dist;
    }
}
class DistNode2{
    int dist, node;
    DistNode2(int dist, int node){
        this.dist = dist;
        this.node = node;
    }
}
