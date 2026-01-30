package DSA2.Graph;
import java.util.*;

// first reverse the direction of edges, doing this we can better do cycle detection
// use topological sort

public class SafeStatesBFS {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        List<List<Integer>> adj = new  ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[V];
        // Reversing the graph
        for(int[] edge:edges){
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        ArrayList<Integer> safeNodes = new ArrayList<>();

        while(!queue.isEmpty()){
            int node = queue.poll();
            safeNodes.add(node);

            for(int adjNode:adj.get(node)){
                indegree[adjNode]--;
                if(indegree[adjNode]==0){
                    queue.add(adjNode);
                }
            }
        }

        Collections.sort(safeNodes);
        return  safeNodes;
    }
}
