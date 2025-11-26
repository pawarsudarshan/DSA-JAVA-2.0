package DSA2.Graph;

import java.util.ArrayList;
import java.util.List;

public class DoesPathExist {
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
    }
//    GfG question solution
    public static boolean checkPath(int V, int[][] edges, int src, int dest) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[V];
        vis[src] = true;
        return dfs(graph,vis,src,dest);
    }
    public static boolean dfs(List<List<Integer>> graph, boolean[] vis, int src, int dest){
        if(src==dest) return true;

        for(int node:graph.get(src)){
            if(!vis[node]){
                vis[node] = true;
                if(dfs(graph,vis,node,dest)) return true;
            }
        }

        return false;
    }

    // Solution of Find whether path exist on GfG
    public boolean is_Possible(int[][] grid) {
        int m = grid.length, n = grid[0].length, sr = 0, sc = 0, dr = 0, dc = 0;
        boolean[][] visited = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    sr = i;
                    sc = j;
                }
                if(grid[i][j]==2){
                    dr = i;
                    dc = j;
                }
            }
        }

        return isPathPossible(grid, sr, sc, dr, dc, m, n, visited);
    }
    boolean isPathPossible(int[][] grid, int sr, int sc, int dr, int dc, int m, int n, boolean[][] vis){
        if(vis[sr][sc]) return false;
        if(grid[sr][sc]==0) return false;
        if(sr==dr && sc==dc) return true;

        vis[sr][sc] = true;

        if(sc-1>=0){ // left
            if(isPathPossible(grid,sr,sc-1,dr,dc,m,n,vis)) return true;
        }

        if(sc+1<n){ // right
            if(isPathPossible(grid,sr,sc+1,dr,dc,m,n,vis)) return true;
        }

        if(sr-1>=0){ // up
            if(isPathPossible(grid,sr-1,sc,dr,dc,m,n,vis)) return true;
        }

        if(sr+1<m){ // down
            if(isPathPossible(grid,sr+1,sc,dr,dc,m,n,vis)) return true;
        }

        return false;
    }
}
