package DSA2.DynamicProgramming;
import java.util.*;

/* Coin Change 2 => How many ways we can have a amount using coins[] array, one coin can be used multiple times
=> Recursive approach
=> Print All Possible ways
=> DP Memoization
 */
public class CoinChange2 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};
        System.out.println(changeRecursive(amount,coins));
        System.out.println(printAllWaysOfCoinChange(amount,coins));
    }
    public static int changeRecursive(int amount, int[] coins) {
        return changeRecursiveHelper(amount, coins, 0);
    }
    public static int changeRecursiveHelper(int remainingAmount, int[] coins, int index){
        // base case
        if(remainingAmount == 0){
            return 1;
        }
        if(index == coins.length){
            return 0;
        }

        // exclude
        int ways = changeRecursiveHelper(remainingAmount, coins, index+1);

        // include
        if(coins[index] <= remainingAmount){
            ways += changeRecursiveHelper(remainingAmount-coins[index], coins, index);
        }

        return ways;
    }
    // Print all possible ways
    public static List<List<Integer>> printAllWaysOfCoinChange(int amount, int[] coins) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        printAllWaysOfCoinChangeHelper(amount, coins, 0, list, temp);
        return list;
    }
    public static int printAllWaysOfCoinChangeHelper(int remainingAmount, int[] coins, int index, List<List<Integer>> list, List<Integer> temp){
        // base case
        if(remainingAmount == 0){
            list.add(new  ArrayList<>(temp));
            return 1;
        }
        if(index == coins.length){
            return 0;
        }

        // exclude
        int ways = printAllWaysOfCoinChangeHelper(remainingAmount, coins, index+1,list,temp);

        // include
        if(coins[index] <= remainingAmount){
            temp.add(coins[index]);
            ways += printAllWaysOfCoinChangeHelper(remainingAmount-coins[index], coins, index,list,temp);
            temp.remove(temp.size()-1);
        }

        return ways;
    }
    // DP solution
    public static int change2(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(amount, coins, 0,dp);
    }
    public static int solve(int remainingAmount, int[] coins, int index, int[][] dp){
        // base case
        if(remainingAmount == 0){
            return 1;
        }
        if(index == coins.length){
            return 0;
        }

        if(dp[index][remainingAmount]!=-1){
            return  dp[index][remainingAmount];
        }

        // exclude
        int ways = solve(remainingAmount, coins, index+1,dp);

        // include
        if(coins[index] <= remainingAmount){
            ways += solve(remainingAmount-coins[index], coins, index, dp);
        }

        return dp[index][remainingAmount] = ways;
    }
}
