package DP;
import java.util.*;

// you're just too good to be true
// can't take my eyes off you,
// you'll be like heaven to touch
// thank god I'm alive

public class DivisibleByM {
    public static void main(String[] args) {
        int[] arr = {7,12,8,13,11};
        int m = 16;
        System.out.println(DivisibleByM(arr,m));
    }

    static public int DivisibleByM(int [] arr, int m) {
//
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][m+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0){
                    if(i==0) dp[i][j] = false;
                    if(j==0) dp[i][j] = true;
                } else{
                    int x = arr[i-1]%m;
                    if(x==0) return 1;
                    dp[i][j] = dp[i-1][j];
                    if(j<x){
                        if(dp[i-1][m+j-x]) dp[i][j] = true;
                    }
                    if(j>=x) {
                        dp[i][j] = dp[i][j] || dp[i-1][j-x];
                    }
                }
            }
        }

        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(dp[i][j])
                System.out.print(1+" ");
                else System.out.print(0+" ");
            }
            System.out.println();
        }

        if(dp[n][m]) return 1;
        return 0;
    }

}
/*
 int n = arr.length;
//        int sum = 0;
//        for(int i=0;i<n;i++){
//            sum+=arr[i];
//        }
//        boolean[][] dp = new boolean[n+1][sum+1];
//
//        for(int i=0;i<=n;i++){
//            for(int j=0;j<=m;j++){
//                if (i == 0 || j == 0) {
//                    if(i==0) dp[i][j] = false;
//                    if(j==0) dp[i][j] = true;
//                }
//                else {
////                    dp[i][j] = dp[i - 1][j] || dp[i - 1][Math.abs((j - arr[i - 1]%m)%m)];
//                    if(arr[i-1]<=j)
//                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j-arr[i-1]];
//                    else
//                        dp[i][j] = dp[i-1][j];
//                }
//            }
//        }
//
////        for(int i=0;i<=n;i++){
////            for(int j=0;j<=m;j++){
////                if(dp[i][j])
////                System.out.print(1+" ");
////                else System.out.print(0+" ");
////            }
////            System.out.println();
////        }
//
////        for(int j=0;j<=n;j++){
////            if(dp[m][j]==true) return 1;
////        }
////        return 0;
//        if(dp[n][m]) return 1;
//        return 0;
//        int sum = 0, n = arr.length;
//        for(int val:arr) sum+= val;
//
//        boolean [][] t = new boolean[n+1][sum+1];
//
//        for(int i=0;i<n+1;i++){
//            for(int j=0;j<sum+1;j++)
//            {
//                if(i==0 || j==0){
//                if(i==0)
//                    t[i][j]=false;
//
//                if(j==0)
//                    t[i][j]=true;
//            }
//                else{
//                if(arr[i-1]<=j)
//                    t[i][j]=t[i-1][j-arr[i-1]] || t[i-1][j];
//
//                else t[i][j]=t[i-1][j];
//            }
//            }
//        }
//
//        for(int i=0;i<=n;i++){
//            for(int j=0;j<=sum;j++){
//                if(t[i][j])
//                System.out.print(1+" ");
//                else System.out.print(0+" ");
//            }
//            System.out.println();
//        }
//
//        for(int i=1;i<=sum;i++){
//            if(i%m==0 && t[n][i]) return 1;
//        }
//
//        return 0;

//        int n = arr.length;
//        boolean[][] dp = new boolean[n][m];
//        dp[0][arr[0]%m] = true;
//
//        for(int i=1;i<n;i++){
//            for(int j=0;j<m;j++){
//                if(j==(arr[i]%m)) dp[i][j] = true;
//                dp[i][j] = dp[i-1][j] || dp[i-1][m-(arr[i]%m)];
//            }
//        }
//
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
//
//        if(dp[n-1][m-1]) return 1;
//        return 0;
 */