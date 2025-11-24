package DSA2.Graph;
import java.util.*;

public class BFS {
    public static void main(String[] args) {
        int[][] adj = {{2, 3, 1}, {0}, {0, 4}, {0}, {2}};
        List<List<Integer>> graph = new ArrayList<>();

        for (int[] arr : adj) {
            List<Integer> list = new ArrayList<>();
            for (int x : arr) {
                list.add(x);
            }
            graph.add(list);
        }
        System.out.println(bfs(graph));
    }

    public static List<Integer> bfs(List<List<Integer>> graph) {
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[graph.size()]; /* Faster than set bcoz of direct index access,
        no int to Integer object conversion overhead, no hashing overhead
        [] array provides contiguous memory */
        Queue<Integer> q = new ArrayDeque<>(); // Faster than LinkedList implementation

        q.add(0);
        visited[0] = true;

        while(!q.isEmpty()) {
            int currNode = q.poll();
            res.add(currNode);

            for(int node:graph.get(currNode)) {
                if(!visited[node]) {
                    visited[node] = true;
                    q.add(node);
                }
            }
        }

        return res;
    }

}
