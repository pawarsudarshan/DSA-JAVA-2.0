package DP;
import java.util.*;

public class Frogs1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.println(minCost(arr,n));
    }
//      Recursive + Memoization
//    static int solve(int[] arr, int idx, int n, int[] dp){
//        if(idx==n-1) return 0;
//
//        if(dp[idx]!=-1) return dp[idx];
//
//        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
//
//        if(idx+1<n){
//            first = Math.abs(arr[idx+1]-arr[idx]) + solve(arr,idx+1, n, dp);
//        }
//        if(idx+2<n){
//            second = Math.abs(arr[idx+2]-arr[idx]) + solve(arr,idx+2,n,dp);
//        }
//        return dp[idx] = Math.min(first,second);
//    }
//    static int minCost(int[] arr , int n){
//        int[] dp = new int[n+1];
//        Arrays.fill(dp,-1);
//        return solve(arr,0,n,dp);
//    }

    // bottom up approach
    static int minCost(int[] arr, int n){
        int [] dp = new int[n+2];
        dp[0] = 0;
        dp[1] = Math.abs(arr[1]-arr[0]);
        for(int i=2;i<n;i++){
            dp[i] = Math.min(Math.abs(arr[i]-arr[i-1])+dp[i-1], Math.abs(arr[i]-arr[i-2])+ dp[i-2]);
        }
//        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }
}
