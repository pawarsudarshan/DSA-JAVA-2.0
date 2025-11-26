package DSA2.DynamicProgramming;
import java.util.*;

public class NumberOfPaths {
    public static void main(String[] args) {
        int[][] grid = {{5,2,4},{3,0,5},{0,7,2}};
        int k = 1;
        System.out.println(numberOfPaths(grid,k));
    }
    public static int numberOfPaths(int[][] grid, int k){
        int m = grid.length, n = grid[0].length;
        long[][][] dp = new long[m][n][k];
        int MOD = 1_000_000_007;

        // Base Case
        int rem = grid[0][0]%k;
        dp[0][0][rem] = 1;

        for(int i=1;i<m;i++){
            rem = (rem+grid[i][0])%k;
            dp[i][0][rem] = 1;
        }

        rem = grid[0][0]%k;
        for(int j=1;j<n;j++){
            rem = (rem+grid[0][j])%k;
            dp[0][j][rem] = 1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                for(int x=0;x<k;x++){
                    int rem2 = (x + grid[i][j])%k;
                    dp[i][j][rem2] = dp[i-1][j][x] + dp[i][j-1][x];
                }
            }
        }

        return (int)dp[m-1][n-1][0];
    }
}