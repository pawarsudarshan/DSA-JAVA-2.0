package DP;

import java.util.Arrays;

public class MaximumKadaneSum {
    public static void main(String[] args) {
        int[] arr = { -59, -91, -230, -114, -492 };
        int n = arr.length;
        System.out.println(maximumSum(arr, n));
    }

    static long maximumSum(int arr[], int n) {
        long[] dp = new long[n + 1];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(arr[i] + dp[i - 2], Math.max(arr[i], dp[i - 1]));
        }

        System.out.println(Arrays.toString(dp));
        return Math.max(dp[n - 1], dp[n - 2]);
    }
}
