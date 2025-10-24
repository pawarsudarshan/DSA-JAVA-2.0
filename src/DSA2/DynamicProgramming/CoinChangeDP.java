package DSA2.DynamicProgramming;
import java.util.*;

public class CoinChangeDP {
    public static void main(String[] args) {
        int[] coins = {5,2,1};
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }

    public static int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int[][] dp = new  int[coins.length][amount+1];
        for(int[] arr: dp) Arrays.fill(arr,-1);
        if(solve(coins,0,amount,dp)==Integer.MAX_VALUE) return -1;
        return solve(coins,0,amount,dp);
    }

    public static int solve(int[] coins, int index, int rem, int[][] dp){
        if(rem<0 || index>=coins.length) return Integer.MAX_VALUE;
        if(rem==0) return 0;

        if(dp[index][rem]!=-1) return dp[index][rem];

        int exclude = solve(coins,index+1,rem,dp);

        int include = solve(coins,index,rem-coins[index],dp);
        if(include!=Integer.MAX_VALUE) include++;

        dp[index][rem] = Math.min(include, exclude);
        return dp[index][rem];
    }
}
