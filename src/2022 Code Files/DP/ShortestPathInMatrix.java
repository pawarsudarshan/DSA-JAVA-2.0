package DP;

import java.util.*;

public class ShortestPathInMatrix {
    public static void main(String[] args) {
        int[][] grid = { { 0, 0 }, { 1, 0 }, { 1, 0 }, { 1, 0 }, { 1, 0 }, { 1, 0 }, { 0, 0 }, { 0, 1 }, { 0, 1 },
                { 0, 1 }, { 0, 0 }, { 1, 0 }, { 1, 0 }, { 0, 0 } };
        int k = 4;
        System.out.println(shortestPath(grid, k));
    }

    static public int shortestPath(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][][] dp = new int[n][m][k + 100];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int x = 0; x <= k; x++) {
                    dp[i][j][x] = -1;
                }
            }
        }

        int ans = solve(grid, vis, k, 0, 0, dp);

        // for(int i=0;i<n;i++){
        // for(int j=0;j<m;j++){
        // System.out.print(vis[i][j]);
        // }
        // System.out.println();
        // }

        if (ans == Integer.MAX_VALUE)
            return -1;
        return ans;
    }

    static int solve(int[][] grid, int[][] vis, int k, int i, int j, int[][][] dp) {
        int n = grid.length, m = grid[0].length;
        if (k < 0)
            return Integer.MAX_VALUE;
        if (i < 0 || j < 0 || i >= n || j >= m)
            return Integer.MAX_VALUE;
        if (vis[i][j] == 1)
            return Integer.MAX_VALUE;

        if (dp[i][j][k] != -1)
            return dp[i][j][k];

        if (grid[i][j] == 1 && k > 0) {
            k--;
        }

        vis[i][j] = 1;
        if (i == n - 1 && j == m - 1)
            return 0;
        int ans = Integer.MAX_VALUE;

        // down
        int b = solve(grid, vis, k, i + 1, j, dp);
        if (b != Integer.MAX_VALUE)
            ans = Math.min(ans, 1 + b);

        // right
        int d = solve(grid, vis, k, i, j + 1, dp);
        if (d != Integer.MAX_VALUE)
            ans = Math.min(ans, 1 + d);

        // up
        int a = solve(grid, vis, k, i - 1, j, dp);
        if (a != Integer.MAX_VALUE)
            ans = Math.min(ans, 1 + a);

        // left
        int c = solve(grid, vis, k, i, j - 1, dp);
        if (c != Integer.MAX_VALUE)
            ans = Math.min(ans, 1 + c);

        vis[i][j] = 0;
        return dp[i][j][k] = ans;
    }
}

/*
 * This solution is pure recursion (bfs)
 * and it is giving TLE.
 * use dp to optimise
 * 
 * 
 * package DP;
 * import java.util.*;
 * 
 * public class ShortestPathInMatrix {
 * public static void main(String[] args) {
 * int[][] grid = {{0,1,1},{1,1,1},{1,0,0}};
 * int k = 1;
 * System.out.println(shortestPath(grid,k));
 * }
 * static public int shortestPath(int[][] grid, int k) {
 * int n = grid.length, m = grid[0].length;
 * int[][] vis = new int[n][m];
 * int ans = solve(grid,vis,k,0,0);
 * 
 * // for(int i=0;i<n;i++){
 * // for(int j=0;j<m;j++){
 * // System.out.print(vis[i][j]);
 * // }
 * // System.out.println();
 * // }
 * 
 * if(ans == Integer.MAX_VALUE) return -1;
 * return ans;
 * }
 * static int solve(int[][] grid, int[][] vis, int k, int i, int j){
 * int n = grid.length, m = grid[0].length;
 * 
 * // for(int i=0;i<n;i++){
 * // for(int j=0;j<m;j++){
 * // System.out.print(vis[i][j]);
 * // }
 * // System.out.println();
 * // }
 * 
 * if(grid[i][j]==1 && k>0) k--;
 * else if(grid[i][j]==1 && k<=0) return Integer.MAX_VALUE;
 * 
 * vis[i][j] = 1;
 * if(i==n-1 && j==m-1) return 0;
 * int ans = Integer.MAX_VALUE;
 * 
 * 
 * 
 * // down
 * if(i<n-1 && vis[i+1][j]==0){
 * int b = solve(grid,vis,k,i+1,j);
 * if(b!=Integer.MAX_VALUE) ans = Math.min(ans,1+b);
 * }
 * 
 * // right
 * if(j<m-1 && vis[i][j+1]==0){
 * int d = solve(grid,vis,k,i,j+1);
 * if(d!=Integer.MAX_VALUE) ans = Math.min(ans,1+d);
 * }
 * 
 * // left
 * if(j>0 && vis[i][j-1]==0){
 * int c = solve(grid,vis,k,i,j-1);
 * if(c!=Integer.MAX_VALUE) ans = Math.min(ans,1+c);
 * }
 * 
 * // up
 * if(i>0 && vis[i-1][j]==0){
 * int a = solve(grid,vis,k,i-1,j);
 * if(a!=Integer.MAX_VALUE) ans = Math.min(ans,1+a);
 * }
 * 
 * vis[i][j] = 0;
 * // System.out.println(i+" "+j+" "+ans);
 * return ans;
 * }
 * }
 * 
 */
