package DSA2.Recursion;
import java.util.*;

public class MinimumSumPathInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        MinimumSumPathInMatrix obj = new MinimumSumPathInMatrix();
        System.out.println("Minimum Path Sum = " + obj.minPathSum(matrix));
    }

    /* Pure Recursive Solution
    public int minPathSum(int[][] matrix) {
        List<Integer> minSum = new ArrayList<>();
        minSum.add(Integer.MAX_VALUE);
        check(matrix, 0, 0, 0, minSum);
        return minSum.get(0);
    }

    public void check(int[][] grid, int row, int col, int sum, List<Integer> minSum) {
        int m = grid.length, n = grid[0].length;
        if (row >= m || col >= n) return;

        sum += grid[row][col];

        if (row == m - 1 && col == n - 1) {
            if (sum < minSum.get(0)) {
                minSum.set(0, sum);
            }
            return;
        }

        check(grid, row + 1, col, sum, minSum); // Down
        check(grid, row, col + 1, sum, minSum); // Right
    }
    */
    // Tabulation
    public int minPathSum(int[][] matrix) {
        int m =  matrix.length, n =  matrix[0].length;
        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[i][j] = matrix[i][j];
                    continue;
                }
                int top = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;

                if(i>0) top = dp[i-1][j];
                if(j>0) left = dp[i][j-1];

                if(top>left) dp[i][j] = left + matrix[i][j];
                else  dp[i][j] = top + matrix[i][j];
            }
        }

        return dp[m-1][n-1];
    }

    /* Tabulation => In-place
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for(int i=1;i<m;i++)
            grid[i][0] += grid[i-1][0];

        for(int j=1;j<n;j++)
            grid[0][j] += grid[0][j-1];

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }

        return grid[m-1][n-1];
    }
     */

}
