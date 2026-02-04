package DSA2.Graph;
import java.util.*;

public class MinimumNumberOfWaysToArriveAtDestination {
    public static void main(String[] args) {

    }
    public int countPaths(int V, int[][] edges) {
        // creating adj list
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2])); // undirected graph
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.wt == b.wt) return a.node - b.node;
            return a.wt - b.wt;
        });
        pq.add(new Pair(0,0));

        int src = 0, dest = V-1;

        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        int[] ways = new int[V];
        ways[src] = 1;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int timeTillNode = p.wt;
            int node = p.node;

            for(Pair adjNode: adj.get(node)){
                int travelTime = adjNode.wt;
                if(timeTillNode + travelTime < dist[adjNode.node]){
                    dist[adjNode.node] = timeTillNode + travelTime;
                    pq.add(new Pair(adjNode.node,dist[adjNode.node]));
                    ways[adjNode.node] = ways[node];
                } else if(dist[adjNode.node]==timeTillNode+travelTime){
                    ways[adjNode.node] += ways[node];
                }
            }

        }

        return ways[dest];
    }
}
