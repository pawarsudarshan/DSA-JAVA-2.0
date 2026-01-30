package DSA2.Graph;
import java.util.*;

// if there is cycle, then it's not possible to schedule the courses

public class CourseSchedule {
    public static void main(String[] args) {

    }
    public boolean isPossible(int N, int P, int[][] prerequisites) {
        // Your Code goes here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[N];

        for(int[] pre:prerequisites){
            adj.get(pre[0]).add(pre[1]);
            indegree[pre[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<N;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            count++;
            int node = queue.poll();
            for(int adjNode:adj.get(node)){
                indegree[adjNode]--;
                if(indegree[adjNode]==0){
                    queue.offer(adjNode);
                }
            }
        }

        if(count==N) return true;
        return false;
    }
}
