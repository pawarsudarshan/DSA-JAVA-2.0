package DSA2.DynamicProgramming;
import java.util.*;

public class Knapsack01 {
    public static void main(String[] args) {
        int[] wt = {1, 2, 3};
        int[] value = {6,10,12};
        int knapsack = 5;
        System.out.println(maxValue(wt,value,knapsack));
    }
    public static int maxValue(int[] wt, int[] value, int knapsack){
        int[][] dp = new int[wt.length+1][knapsack+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(wt, value, 0,knapsack, dp);
    }
    public static int solve(int[] wt, int[] value, int index, int knapsack, int[][] dp){
        if(index == wt.length || knapsack<=0){
            return 0;
        }

        if(dp[index][knapsack]!=-1) return dp[index][knapsack];

        int include = 0;
        if(wt[index]<=knapsack){
            include = value[index] + solve(wt, value, index+1, knapsack-wt[index], dp);
        }

        int exclude = solve(wt,value,index+1, knapsack, dp);
        dp[index][knapsack] = Math.max(include,exclude);
        return dp[index][knapsack];
    }
}
