package DSA2.DynamicProgramming;
import java.util.*;

public class NumberOfLongestIncreasingSubsequences {
    public static void main(String[] args) {
        int[] nums = {1,2,4,3,5,4,7,2};
        System.out.println(findNumberOfLIS(nums));
    }
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length, max = 1;
        int[] dp = new int[n];
        int[] count = new int[n];

        Arrays.fill(dp,1);
        count[0] = 1;

        for (int i=0;i<n;i++)
            System.out.println(count[i]);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }

            for(int j=0;j<i;j++){
                if(dp[j]+1==dp[i] && nums[j]<nums[i]){
                    count[i] += count[j];
                }
            }
        }

        for(int i=0;i<n;i++)
            System.out.printf(dp[i]+" ");

        System.out.println();

        for(int i=0;i<n;i++)
            System.out.printf(count[i]+" ");

        int maxNum = 0, maxCount = 0;
        for(int i=0;i<n;i++){
            if(maxNum<=dp[i]){
                maxNum = dp[i];
                if(maxCount<count[i]) maxCount = count[i];
            }
        }
        System.out.println();
        return maxCount;
    }
}