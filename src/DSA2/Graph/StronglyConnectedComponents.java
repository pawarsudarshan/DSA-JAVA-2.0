package DSA2.Graph;
import java.util.*;

public class StronglyConnectedComponents {
    public static void main(String[] args) {

    }

    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // 1. get nodes based on discovery time
        int V = adj.size();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }


        // 2. reverse the graph
        ArrayList<ArrayList<Integer>> reverseAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            reverseAdj.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            visited[i] = false; // resetting visited array for re-use
            for (int it : adj.get(i)) {
                reverseAdj.get(it).add(i);
            }
        }

        int scc = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                dfs2(node, reverseAdj, visited);
                scc++;
            }
        }
        return scc;
    }

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int ele : adj.get(node)) {
            if (!visited[ele]) {
                dfs(ele, adj, visited, stack);
            }
        }

        stack.push(node);
    }

    public void dfs2(int node, ArrayList<ArrayList<Integer>> reverseAdj, boolean[] visited) {
        visited[node] = true;
        for (int it : reverseAdj.get(node)) {
            if (!visited[it]) {
                dfs2(it, reverseAdj, visited);
            }
        }
    }
}
