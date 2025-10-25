package DSA2.DynamicProgramming;

public class LongestSumIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100};
        System.out.println(maxSumIS(arr));
    }
    public static int maxSumIS(int arr[]) {
        int n = arr.length, max = Integer.MIN_VALUE;
        int[] dp = new int[n];
        for(int i=0;i<n;i++)
            dp[i] = arr[i];

        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+arr[i]);
                }
            }
        }

        for(int i=0;i<n;i++)
            max = Math.max(dp[i],max);
        return max;
    }
}
