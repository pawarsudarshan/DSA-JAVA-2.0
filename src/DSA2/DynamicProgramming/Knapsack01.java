package DSA2.DynamicProgramming;

public class Knapsack01 {
    public static void main(String[] args) {
        int[] wt = {1, 2, 3};
        int[] value = {6,10,12};
        int knapsack = 5;
        System.out.println(maxValue(wt,value,knapsack));
    }
    public static int maxValue(int[] wt, int[] value, int knapsack){
        return solve(wt, value, 0,knapsack);
    }
    public static int solve(int[] wt, int[] value, int index, int knapsack){
        if(index == wt.length || knapsack<=0){
            return 0;
        }

        int include = 0;
        if(wt[index]<=knapsack){
            include = value[index] + solve(wt, value, index+1, knapsack-wt[index]);
        }

        int exclude = solve(wt,value,index+1, knapsack);
        return Math.max(include,exclude);
    }
}
