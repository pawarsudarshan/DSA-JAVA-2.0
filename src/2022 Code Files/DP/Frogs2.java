package DP;
import java.util.*;

public class Frogs2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.println(solve(arr,n,k));
    }
    static int solve(int[] arr, int n, int k){
        int [] dp = new int[n+3];
        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[0] = 0;
        dp[1] = Math.abs(arr[1]-arr[0]);
        for(int i=2;i<n;i++){
            for(int j=Math.max(0,i-k);j<i;j++){
                    dp[i] = Math.min(dp[i],Math.abs(arr[j]-arr[i])+dp[j]);
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }
}
