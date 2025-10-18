package DSA2.Recursion;
import java.util.*;

public class RatInAMaze {
    public static void main(String[] args) {
        int [][] grid = {{1,0,0,0},
                         {1,1,0,1},
                         {1,1,0,0},
                         {0,1,1,1}};
        System.out.println(ratInMaze(grid));
    }
    public static ArrayList<String> ratInMaze(int[][] grid) {
        int n = grid[0].length;
        int[][] visited = new int[n][n];
        StringBuilder sb = new StringBuilder();
        ArrayList<String> allPaths = new ArrayList<>();
        findAllPaths(grid,visited,0,0,n,sb, allPaths);
        Collections.sort(allPaths);
        return allPaths;
    }
    public static void findAllPaths(int[][] grid, int[][] visited, int row, int col, int n, StringBuilder sb, ArrayList<String> allPaths) {
        if(row==n-1 && col==n-1){
            allPaths.add(sb.toString());
            return;
        }

        if(visited[row][col]==1) return;
        if(grid[row][col]==0) return;

        // up
        if(row-1>=0 && grid[row-1][col]!=0){
            sb.append('U');
            visited[row][col] = 1;
            findAllPaths(grid,visited,row-1,col,n,sb,allPaths);
            visited[row][col] = 0;
            sb.deleteCharAt(sb.length()-1);
        }

        // down
        if(row+1<n && grid[row+1][col]!=0){
            sb.append('D');
            visited[row][col] = 1;
            findAllPaths(grid,visited,row+1,col,n,sb, allPaths);
            visited[row][col] = 0;
            sb.deleteCharAt(sb.length()-1);
        }

        // right
        if(col+1<n && grid[row][col+1]!=0){
            sb.append('R');
            visited[row][col] = 1;
            findAllPaths(grid,visited,row,col+1,n,sb, allPaths);
            visited[row][col] = 0;
            sb.deleteCharAt(sb.length()-1);
        }

        // left
        if(col-1>=0 && grid[row][col-1]!=0){
            sb.append('L');
            visited[row][col] = 1;
            findAllPaths(grid,visited,row,col-1,n,sb,allPaths);
            visited[row][col] = 0;
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
