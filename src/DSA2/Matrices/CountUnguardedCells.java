package DSA2.Matrices;
import java.util.*;
/*

 */
public class CountUnguardedCells {
    public static void main(String[] args) {
        int m = 4, n = 6;
        int[][] guards = {{0,0},{1,1},{2,3}};
        int[][] walls = {{0,1},{2,2},{1,4}};
        System.out.println(countUnguarded(m,n,guards,walls)); // Expected output: 7
    }
    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        //Matrix to track walls, guards, guarded cells and unguarded cells
        int[][] mat = new int[m][n];

        //Marking positions of guards
        for(int[] arr:guards)
            mat[arr[0]][arr[1]] = -1;


        //Marking positions of walls
        for(int[] arr:walls)
            mat[arr[0]][arr[1]] = -2;

        //Marking guarded positions by every guard
        for(int[] arr:guards){
            mark(mat,m,n,arr[0],arr[1]);
        }

        //Finally counting unguarded cells
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0) count++;
            }
        }
        return count;
    }

    public static void mark(int[][] mat, int m, int n, int row, int col) {
        // Down
        for (int i = row + 1; i < m; i++) {
            if(mat[i][col]==-1 || mat[i][col]==-2) break;
            mat[i][col] = 1;
        }
        // Up
        for (int i = row - 1; i >= 0; i--) {
            if(mat[i][col]==-1 || mat[i][col]==-2) break;
            mat[i][col] = 1;
        }
        // Right
        for (int j = col + 1; j < n; j++) {
            if(mat[row][j]==-1 || mat[row][j]==-2) break;
            mat[row][j] = 1;
        }
        // Left
        for (int j = col - 1; j >= 0; j--) {
            if(mat[row][j]==-1 || mat[row][j]==-2) break;
            mat[row][j] = 1;
        }
    }
}
