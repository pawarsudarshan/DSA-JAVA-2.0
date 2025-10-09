package DP;
import java.util.*;

public class Knapsack1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] weights = new int[n];
        int[] values = new int[n];

        for(int i=0;i<n;i++){
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }
        System.out.println(knapsack(weights,values,n,w));
    }

    public static long knapsack(int[] weights, int[] values, int n, int w){
        long[][] dp = new long[n+1][w+1];
        for(long[] arr:dp)
            Arrays.fill(arr,-1);
        return solve(weights,values, n-1, w, dp);
    }

    public static long solve(int[] weights, int[] values, int idx, int w, long[][] dp){
        if(idx<0) return 0;
        if(dp[idx][w]!=-1) return dp[idx][w];
        long ans = 0;

        // taken
        if(weights[idx]<=w){
            ans = Math.max(ans,values[idx]+solve(weights,values,idx-1,w-weights[idx],dp));
        }

        // not taken
        ans = Math.max(ans,solve(weights,values,idx-1,w,dp));
        return dp[idx][w] = ans;
    }
}
