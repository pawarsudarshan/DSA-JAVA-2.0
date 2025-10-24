package DSA2.DynamicProgramming;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length, ans = 1;
        int[] dp = new int[n];
        dp[0] = 1;

        for(int i=1;i<n;i++){
            int maxL = 0;
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    maxL = Math.max(maxL,dp[j]);
                }
            }
            dp[i] = 1 + maxL;
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
