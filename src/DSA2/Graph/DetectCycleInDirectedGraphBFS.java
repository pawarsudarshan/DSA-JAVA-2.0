package DSA2.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInDirectedGraphBFS {
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0, 1}, {0, 3}, {1, 3}};
        System.out.println(isCyclic(V,edges));
    }

    public static boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[V];
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            count++;
            for(int adjNode: adj.get(node)){
                indegree[adjNode]--;
                if(indegree[adjNode]==0){
                    queue.offer(adjNode);
                }
            }
        }

        if(count==V){
            return false;
        }
        return true;
    }
}
