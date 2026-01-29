package DSA2.Graph;

import java.util.*;

// if cycle forms, then it is not a safe state node

public class SafeStates {
    public static void main(String[] args) {
        int V = 6;
        int[][] edges = {{0, 3}, {0, 4}, {1, 5}, {5, 2}, {1, 2}, {2, 1}};
        System.out.println(safeNodes(V, edges));
    }

    public static ArrayList<Integer> safeNodes(int V, int[][] edges) {
        // convert into adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]); // directed graph
        }

        // markers for visited, pathVisited and safeState
        boolean[] visited = new boolean[V];
        boolean[] currentPathVisited = new boolean[V];
        boolean[] safeState = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                isCycleDirectedGraphHelperDFS(adj, visited, currentPathVisited, safeState, i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (safeState[i]) {
                result.add(i);
            }
        }
        return result;
    }

    public static boolean isCycleDirectedGraphHelperDFS(List<List<Integer>> adj, boolean[] visited, boolean[] currentPathVisited, boolean[] safeState, int currNode) {
        visited[currNode] = true;
        currentPathVisited[currNode] = true;
        safeState[currNode] = false;

        for (int node : adj.get(currNode)) {
            if (!visited[node]) {
                if (isCycleDirectedGraphHelperDFS(adj, visited, currentPathVisited, safeState, node)) {
                    return true;
                }
            } else if (currentPathVisited[node]) {
                return true;
            }
        }

        currentPathVisited[currNode] = false;
        safeState[currNode] = true;
        return false;
    }
}
