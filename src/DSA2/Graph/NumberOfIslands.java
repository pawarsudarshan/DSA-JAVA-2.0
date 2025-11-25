package DSA2.Graph;
import java.util.*;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {{'L', 'L', 'W', 'W', 'W'},
                        {'W', 'L', 'W', 'W', 'L'},
                        {'L', 'W', 'W', 'L', 'L'},
                        {'W', 'W', 'W', 'W', 'W'},
                        {'L', 'W', 'L', 'L', 'W'}};
//        char[][] grid = {{'W','L'},{'L','W'},{'L','L'},{'L','W'}};
        System.out.println(countIslands(grid));
    }
    public static int countIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;
        boolean[][] visited = new boolean[m+1][n+1];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 'L' && !visited[i][j]){
                    dfs(grid,i,j,m,n,visited);
                    count++;
                }
            }
        }

        return count;
    }
    public static void dfs(char[][] grid, int i, int j, int m, int n, boolean[][] visited){
        if(visited[i][j]) return;

        visited[i][j] = true;

        if(i-1>=0 && grid[i-1][j] == 'L'){ // Up
            dfs(grid,i-1,j,m,n,visited);
        }

        if(j-1>=0 && grid[i][j-1] == 'L'){ // Left
            dfs(grid,i,j-1,m,n,visited);
        }

        if(i-1>=0 && j-1>=0 && grid[i-1][j-1] == 'L'){ // Left Upper Diagonal
            dfs(grid,i-1,j-1,m,n,visited);
        }

        if(i-1>=0 && j+1<n && grid[i-1][j+1] == 'L'){ // Right Upper Diagonal
            dfs(grid,i-1,j+1,m,n,visited);
        }

        if(j+1<n && grid[i][j+1] == 'L'){ // Right
            dfs(grid,i,j+1,m,n,visited);
        }
        if(i+1<m && j-1>=0 && grid[i+1][j-1] == 'L'){ // Down Left Diagonal
            dfs(grid,i+1,j-1,m,n,visited);
        }
        if(i+1<m && grid[i+1][j] == 'L'){ // Down
            dfs(grid,i+1,j,m,n,visited);
        }
        if(i+1<m && j+1<n && grid[i+1][j+1] == 'L'){ // Down Right Diagonal
            dfs(grid,i+1,j+1,m,n,visited);
        }
    }
}
