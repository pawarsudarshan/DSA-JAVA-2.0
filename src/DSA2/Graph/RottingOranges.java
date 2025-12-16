package DSA2.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {

    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length, maxTime = 0;
        Queue<CellData> q = new LinkedList<>();

        // fill in the queue initially
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new CellData(i,j,0));
                }
            }
        }

        while(!q.isEmpty()){
            CellData orange = q.poll();
            int row = orange.row, col = orange.col, time = orange.time;

            // set values for current cell
            maxTime = Math.max(maxTime,time);

            if(row+1<m && grid[row+1][col]==1){
                grid[row+1][col] = 2;
                q.add(new CellData(row+1,col,time+1));
            }
            if(row-1>=0 && grid[row-1][col]==1){
                grid[row-1][col] = 2;
                q.add(new CellData(row-1,col,time+1));
            }
            if(col+1<n && grid[row][col+1]==1){
                grid[row][col+1] = 2;
                q.add(new CellData(row,col+1,time+1));
            }
            if(col-1>=0 && grid[row][col-1]==1){
                grid[row][col-1] = 2;
                q.add(new CellData(row,col-1,time+1));
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) return -1;
            }
        }

        return maxTime;
    }
}
class CellData{
    int row, col, time;
    CellData(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
