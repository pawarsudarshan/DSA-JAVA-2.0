package DSA2.Graph;
import DSA2.BinaryTree.Pair;
import java.util.*;

/* Store all different islands using Strings - for ex. s for source, u for up, r for right
11
00
String representation of above island will be:snrnnnnnn => s(0,0), n (as nothing above), r(0,1), n(nothing down), n(nothing left)
 */

public class CountDistinctIslands {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1}};
        System.out.println(countDistinctIslands(grid));
    }
    public static int countDistinctIslands(int[][] grid) {
        int m =  grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<String> uniqueIslands = new HashSet<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    System.out.println("value of i= "+ i+ " j= "+j);
                    System.out.println(countIslandsBFS(grid,m,n,i,j,visited));
                    uniqueIslands.add(countIslandsBFS(grid,m,n,i,j,visited));
                }
            }
        }
        return uniqueIslands.size();
    }
    public static String countIslandsBFS(int[][] grid,int m, int n, int row,int col, boolean[][] visited){
        Queue<Pair> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        q.add(new Pair(row,col));
        visited[row][col] = true;
        sb.append('s');

        while(!q.isEmpty()){
            Pair p = q.poll();
            int i = p.first, j = p.second;

            // up
            if(i-1>=0 && grid[i-1][j]==1 && !visited[i-1][j]){
                visited[i-1][j] = true;
                q.add(new Pair(i-1,j));
                sb.append('u');
            } else{
                sb.append('n');
            }

            // right
            if(j+1<n && grid[i][j+1] == 1 &&  !visited[i][j+1]){
                visited[i][j+1] = true;
                q.add(new Pair(i,j+1));
                sb.append('r');
            }else{
                sb.append('n');
            }

            // down
            if(i+1<m && grid[i+1][j] == 1 && !visited[i+1][j]){
                visited[i+1][j] = true;
                q.add(new Pair(i+1,j));
                sb.append('d');
            }else{
                sb.append('n');
            }

            // left
            if(j-1>=0 && grid[i][j-1] == 1 &&  !visited[i][j-1]){
                visited[i][j-1] = true;
                q.add(new Pair(i,j-1));
                sb.append('l');
            }else{
                sb.append('n');
            }
        }

        return sb.toString();
    }
}
