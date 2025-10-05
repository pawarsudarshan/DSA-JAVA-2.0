package DP;

public class MinimumSumPartition {
    public static void main(String[] args) {
        int[] arr = { 1, 6, 11, 5 };
        int n = arr.length;
        System.out.println(minDifference(arr, n));
    }

    static public int minDifference(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        // System.out.println("sum of all elements is: "+ sum);
        int originalSum = sum;
        sum = sum / 2;

        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int j = 0; j <= sum; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - arr[i - 1] >= 0) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]];
                }
                dp[i][j] = dp[i][j] || dp[i - 1][j];
            }
        }

        for (int i = sum; i >= 0; i--) {
            if (dp[n][i] == true) {
                // System.out.println("The value of i is : " + i);
                // System.out.println("The value of originalSum is : "+ originalSum);
                return originalSum - 2 * i;
            }
        }

        return -1;

        // for(int i=0;i<=n;i++){
        // for(int j=0;j<=sum;j++){
        // System.out.print(dp[i][j]+" ");
        // }
        // System.out.println();
        // }
    }
}
