package DSA2.Graph.DisjointSet;

import java.util.HashSet;
import java.util.Set;

public class MaximumConnectedGroup {
    public static void main(String[] args) {
        int[][] grid = {{1,1},{0,1}};
        System.out.println(MaxConnection(grid));
    }
    public static int MaxConnection(int grid[][]) {
        int m = grid.length, n = grid[0].length;
        int V = m * n;
        DisjointSet2 ds = new DisjointSet2(V);

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==1) {
                    int u = i * n + j;
                    // left, top, right, down
                    int[] dr = {0,-1,0,1};
                    int[] dc = {-1,0,1,0};

                    for(int k=0;k<4;k++) {
                        int row = i + dr[k], col = j + dc[k];
                        if(isValid(row,col,m,n) && grid[row][col]==1){
                            int v = row * n + col;
                            ds.union(v, u);
                        }
                    }
                }
            }
        }

        int largest = 0;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {

                if(grid[i][j]==0) {
                    Set<Integer> set = new HashSet<>();
                    int[] dr = {0,-1,0,1};
                    int[] dc = {-1,0,1,0};

                    for (int k = 0; k < 4; k++) {
                        int row = i + dr[k], col = j + dc[k];
                        if (isValid(row, col, m, n) &&  grid[row][col] == 1) {
                            int v = row * n + col;
                            set.add(ds.findParent(v));
                        }
                    }

                    int currentLargest = 1;
                    for(int ele:set){
                        currentLargest += ds.size[ele];
                    }
                    largest = Math.max(largest, currentLargest);
                }
            }
        }
        for(int i=0;i<(m*n);i++){
            largest = Math.max(largest,ds.size[i]);
        }

        return largest;
    }

    public static boolean isValid(int row, int col, int m, int n){
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}
