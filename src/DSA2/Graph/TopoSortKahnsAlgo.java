package DSA2.Graph;
import java.util.*;

// reduce indegree of nodes, if indegree becomes zero, put it in queue

public class TopoSortKahnsAlgo {
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{3,0},{1,0},{2,0}};
        System.out.println(topoSortKahn(V, edges));
    }
    public static ArrayList<Integer> topoSortKahn(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[V];
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            indegree[edges[i][1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);

            for(int adjnode:adj.get(node)){
                indegree[adjnode]--;
                if(indegree[adjnode]==0){
                    q.offer(adjnode);
                }
            }
        }

        return res;
    }
}
