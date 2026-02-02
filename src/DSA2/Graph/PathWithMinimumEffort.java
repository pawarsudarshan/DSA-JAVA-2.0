package DSA2.Graph;
import java.util.*;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        int[][] mat = {{7, 2, 6, 5}, {3, 1, 10, 8}};
        System.out.println(minCostPath(mat));
    }

    public static int minCostPath(int[][] mat) {
        int m =  mat.length, n = mat[0].length;

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->{
            return a.distance - b.distance;
        });

        pq.add(new Tuple(0,0,0));
        int[][] dist = new int[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][0] = 0;

        // to move => left, up, right, down
        int[] dr = {0,-1,0,1};
        int[] dc = {-1,0,1,0};

        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            int row = t.row, col = t.col;

            if(row==m-1 && col==n-1){
                return t.distance;
            }

            for(int i=0;i<4;i++){
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n){
                    int absValue = Math.abs(mat[newRow][newCol] - mat[row][col]);
                    int newDist = Math.max(dist[row][col], absValue);
                    if(newDist < dist[newRow][newCol]){
                        dist[newRow][newCol] = newDist;
                        pq.offer(new Tuple(newDist, newRow, newCol));
                    }
                }
            }
        }

        return 0;
    }
}
class Tuple{
    int distance, row, col;
    public Tuple(int distance, int row, int col){
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}


