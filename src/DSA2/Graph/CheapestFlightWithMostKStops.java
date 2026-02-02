package DSA2.Graph;
import java.util.*;

public class CheapestFlightWithMostKStops {
    public static void main(String[] args) {
//        int n = 4;
//        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
//        int src = 0;
//        int dest = 3;
//        int k = 1;
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

        // creating minHeap
        PriorityQueue<Tuple2> pq = new PriorityQueue<>((a,b)->{
            if(a.cost!=b.cost) return a.cost-b.cost;
            return a.stops-b.stops;
        });

        pq.add(new Tuple2(0,src,0));

        // for storing total flight cost
        int[][] cost = new int[n][k+1];
        for(int i=0;i<n;i++){
            Arrays.fill(cost[i],Integer.MAX_VALUE);
        }
        cost[src][0] = 0;

        // moving through the graph
        while(!pq.isEmpty()){
            Tuple2 t = pq.poll();
            int u = t.node;
            int stopsTillHere = t.stops;
            int nextStop = stopsTillHere + 1;
            int currCost = t.cost;
            System.out.println("node: "+t.node+", dist: "+t.cost);

            if(t.stops>=k){
                continue;
            }

            // relaxing edges
            for(Pair p: adj.get(t.node)){
                int v = p.node;
                int newCost = currCost + p.wt;
                if(newCost < cost[v][nextStop]){
                    cost[v][nextStop] = newCost;
                    pq.add(new Tuple2(newCost,v,nextStop));
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<=k;i++){
            ans = Math.max(ans,cost[dest][i]);
        }
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}
class Tuple2{
    int cost,node,stops;
    public Tuple2(int cost, int node, int stops){
        this.cost = cost;
        this.node = node;
        this.stops = stops;
    }
}
