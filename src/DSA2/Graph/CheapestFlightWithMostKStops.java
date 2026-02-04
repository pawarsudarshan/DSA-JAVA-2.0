package DSA2.Graph;
import java.util.*;

public class CheapestFlightWithMostKStops {
    public static void main(String[] args) {
        int n = 5;
        int[][] flights = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        int src = 0;
        int dest = 2;
        int k = 2;
        System.out.println(cheapestFlight(n, flights, src, dest, k));
    }
    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k) {
        // creating adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight: flights){
            adj.get(flight[0]).add(new Pair(flight[1], flight[2])); // directed graph
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Tuple2> q = new LinkedList<>();
        q.add(new Tuple2(0,0,src));

        while(!q.isEmpty()){
            Tuple2 t = q.poll();
            int node = t.node;
            int stopsToReachNode = t.stops;
            int costToReachNode = t.cost;

            if(stopsToReachNode > k){
                continue;
            }

            for(Pair p: adj.get(node)){
                int edgeWeight = p.wt;
                int adjNode = p.node;
                if(costToReachNode + edgeWeight < dist[adjNode]){
                    dist[adjNode] = costToReachNode + edgeWeight;
                    q.add(new Tuple2(stopsToReachNode+1,dist[adjNode],adjNode));
                }
            }
        }

        if(dist[dest] == Integer.MAX_VALUE){
            return -1;
        }

        return dist[dest];
    }
}
class Tuple2{
    int stops,cost,node;
    public Tuple2(int stops, int cost, int node){
        this.stops = stops;
        this.cost = cost;
        this.node = node;
    }
}
