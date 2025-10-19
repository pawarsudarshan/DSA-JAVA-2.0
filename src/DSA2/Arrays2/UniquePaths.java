package DSA2.Arrays2;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 2;
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return solve(m,n,dp);
    }

    public static int solve(int m, int n, int[][] dp){
        if(m==1 || n==1) return 1;

        if(dp[m-1][n-1]!=0) return dp[m-1][n-1];

        int ans = solve(m,n-1,dp) + solve(m-1,n,dp);

        dp[m-1][n-1] = ans;

        return ans;
    }

}
