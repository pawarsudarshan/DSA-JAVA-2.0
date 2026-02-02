package DSA2.Graph;
import java.util.*;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        int V = 3;
        int[][] edges = {{0, 1, 1}, {1, 2, 3}, {0, 2, 6}};
        int src = 2;
        System.out.println(Arrays.toString(dijkstra(V,edges, src)));
    }
    public static int[] dijkstra(int V, int[][] edges, int src) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
            adj.get(edge[1]).add(new  Pair(edge[0],edge[2]));
        }

        PriorityQueue<DistNode> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.dist != b.dist) {
                return a.dist - b.dist;   // smaller dist first
            }
            return a.node - b.node;       // tie-breaker: smaller node first
        });

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        minHeap.add(new DistNode(0, src));

        while(!minHeap.isEmpty()){
            DistNode dn = minHeap.poll();
            int distanceTillHere =  dn.dist;
            int node = dn.node;
            System.out.println(distanceTillHere+" "+node);
            for(Pair adjNode:adj.get(node)){
                if(adjNode.wt + distanceTillHere < dist[adjNode.node]){
                    dist[adjNode.node] = adjNode.wt + distanceTillHere;
                    minHeap.add(new DistNode(dist[adjNode.node], adjNode.node));
                }
            }
        }

        return dist;
    }
}
class DistNode{
    int dist, node;
    public DistNode(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}

