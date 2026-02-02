package DSA2.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInBinaryMaze {
    public static void main(String[] args) {

    }
    public static int shortestPath(int[][] grid, int[] source, int[] destination) {
        int m  = grid.length;
        int n = grid[0].length;

        Queue<Cell> q = new LinkedList<>();
        q.add(new Cell(source[0], source[1]));
        int level = 0;

        boolean[][] visited = new boolean[m][n];

        while(!q.isEmpty()){
            int levelLength = q.size();
            for(int i = 0; i < levelLength; i++){
                Cell c = q.poll();
                int row = c.row, col =  c.col;

                if(row==destination[0] && col==destination[1]){
                    return level;
                }

                // right
                if(col+1<n && !visited[row][col+1] && grid[row][col+1] == 1){
                    visited[row][col+1] = true;
                    q.add(new Cell(row, col+1));
                }

                // left
                if(col-1>=0 &&!visited[row][col-1] && grid[row][col-1] == 1){
                    visited[row][col-1] = true;
                    q.add(new Cell(row, col-1));
                }

                // up
                if(row-1>=0 && !visited[row-1][col] && grid[row-1][col] == 1){
                    visited[row-1][col] = true;
                    q.add(new Cell(row-1, col));
                }

                // down
                if(row+1<m && !visited[row+1][col] && grid[row+1][col] == 1){
                    visited[row+1][col] = true;
                    q.add(new Cell(row+1, col));
                }
            }
            level++;
        }

        return -1;
    }
}
class Cell{
    int row, col;
    Cell(int row, int col){
        this.row = row;
        this.col = col;
    }
}
