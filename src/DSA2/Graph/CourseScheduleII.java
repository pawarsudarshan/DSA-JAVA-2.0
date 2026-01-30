package DSA2.Graph;
import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args) {

    }
    public ArrayList<Integer> findOrder(int N, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[N];

        for(int[] pre:prerequisites){
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<N;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();

        while(!queue.isEmpty()){
            int node = queue.poll();
            res.add(node);
            for(int adjNode:adj.get(node)){
                indegree[adjNode]--;
                if(indegree[adjNode]==0){
                    queue.offer(adjNode);
                }
            }
        }

        if(res.size()!=N) return new ArrayList<>();
        return res;
    }
}
