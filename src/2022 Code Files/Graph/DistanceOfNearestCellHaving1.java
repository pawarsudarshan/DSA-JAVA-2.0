package Graph;
import java.util.*;

public class DistanceOfNearestCellHaving1 {
    public static void main(String[] args) {
        int[][] grid =  {{1,0,1},{1,1,0},{1,0,0}};
        int[][] output = nearest(grid);

        for (int[] ints : output) {
            for (int j:ints) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public static int[][] nearest(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) grid[i][j] = 0; // for 1 distance of nearest 1 is 0
                else grid[i][j] = 942824998;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){ // if it is 1 originally then start dfs and set values
                    dfs(grid,i+1,j,1);
                    dfs(grid,i,j+1,1);
                    dfs(grid,i-1,j,1);
                    dfs(grid,i,j-1,1);
                }
            }
        }

        return grid;
    }

    private static void dfs(int[][] grid, int i, int j, int dist) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length) return;
        if(grid[i][j]<=dist) return;
        grid[i][j] = dist;

        dfs(grid,i+1,j,dist+1);
        dfs(grid,i,j+1,dist+1);
        dfs(grid,i-1,j,dist+1);
        dfs(grid,i,j-1,dist+1);
    }
}
