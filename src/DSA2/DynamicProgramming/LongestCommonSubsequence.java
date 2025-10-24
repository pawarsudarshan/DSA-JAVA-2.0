package DSA2.DynamicProgramming;
import java.util.*;
/*
if chars in both string match at i,j => search for i-1,j-1
else
max of => 1. i,j-1
          2. i-1,j
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ae";
        System.out.println(longestCommonSubsequence(text1, text2));
    }
    public static int longestCommonSubsequence(String text1, String text2){
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m][n];
        for(int[] row: dp) Arrays.fill(row,-1);
        return solve(text1,text2,m-1,n-1,dp);
    }

    public static int solve(String text1, String text2, int i, int j,int[][] dp){
        if(i<0||j<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(text1.charAt(i)==text2.charAt(j)){
            return dp[i][j] = 1 + solve(text1,text2,i-1,j-1,dp);
        }

        int ans1 = solve(text1,text2,i-1,j,dp);
        int ans2 = solve(text1,text2,i,j-1,dp);

        return dp[i][j] = Math.max(ans1,ans2);
    }
}
