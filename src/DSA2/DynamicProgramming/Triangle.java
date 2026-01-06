package DSA2.DynamicProgramming;
import java.util.*;
/* LeetCode Tip: Initialize DP with INT_MAX instead of -1, as it has negative numbers as well */
public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        int[][] arr = {{2},{3,4},{5,6,7},{8,9,10,11}};
        for(int[] innerArr: arr){
            List<Integer> innerList = new ArrayList<>();
            for(int i: innerArr){
                innerList.add(i);
            }
            triangle.add(innerList);
        }
        System.out.println(minimumTotal(triangle));
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int[] row:dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        return solve(triangle,dp,0,0);
    }

    public static int solve(List<List<Integer>> triangle, int[][] dp, int i, int j){
        if(i==triangle.size()){
            return 0;
        }

        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];

        int way1 = solve(triangle,dp,i+1,j);
        int way2 = solve(triangle,dp,i+1,j+1);

        return dp[i][j] = triangle.get(i).get(j) + Math.min(way1,way2);
    }
}
