package DSA2.Arrays3;
import java.util.*;

public class MaximumSumSubarrayWithLengthDivByK {
    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5};
        int k = 4;
        System.out.println(maxSubarraySum(nums,k));
    }
    public static long maxSubarraySum(int[] nums, int k) {
        long ans = Long.MIN_VALUE, sum = 0;
        int n = nums.length;
        HashMap<Long,Long> map = new HashMap<>();
        map.put(sum,0L);
        for(int i=0;i<n;i++){
            sum += nums[i];
            long rem = (i+1)%k;
            if(map.containsKey(rem)){
                ans = Math.max(ans,sum-map.get(rem));
                map.put((long) rem,Math.min(map.get(rem),sum));
            }
            else map.put((long) rem,sum);
        }
        return ans;
        /*int n = nums.length;
        if(k==1) {
            long maxSum = Long.MIN_VALUE, sum = 0;
            for(int i=0;i<n;i++){
                sum += nums[i];
                maxSum = Math.max(maxSum,sum);
                if(sum<0) sum = 0;
            }
            return maxSum;
        }

        long[]dp1 = new long[k];
        long[]dp2 = new long[k];

        dp1[1] = nums[0];
        long maxSum = Long.MIN_VALUE;

        for(int i=k;i<n;i++){
            for(int x=0;x<k;x++){
                dp2[x] = nums[i] + dp1[(x-1+k)%k];
                if(i>=k-1 && x==0) maxSum = Math.max(maxSum,dp2[x]);
                System.out.print(dp2[x]+" ");
            }
            for(int j=0;j<k;j++){
                long temp = dp1[j];
                dp1[j] = dp2[j];
                dp2[j] = temp;
            }
            System.out.print(" | ");
        }

        return maxSum;*/
    }

    /* A little more optimised solution TC: O(n*k) SC = O(n*k)
    public static long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if(k==1) {
            long maxSum = 0;
            for(int i=0;i<n;i++){
                maxSum += nums[i];
                if(maxSum<0) maxSum = 0;
            }
            return maxSum;
        }

        long[][] dp = new long[n][k];
        dp[0][1] = nums[0];
        long maxSum = Long.MIN_VALUE;

        for(int i=1;i<n;i++){
            for(int x=0;x<k;x++){
                dp[i][x] = nums[i] + dp[i-1][(x-1+k)%k];
            }
        }

        for(int i=k;i<=n;i++){
            maxSum = Math.max(maxSum,dp[i-1][0]);
        }

        return maxSum;
    }*/
    /* Brute Force Approach => calculate maxSum for every subarray length for which %k=0
    public static long maxSubarraySum(int[] nums, int k) {
        long n = nums.length, maxSum = Long.MIN_VALUE;
        for(int i=k;i<=n;i+=k){
            maxSum = Math.max(maxSum,solve(nums,i));
        }
        return maxSum;
    }
    public static long solve(int[] nums, int k){
        long n = nums.length, sum = 0, maxSum = Long.MIN_VALUE;
        int i=0,j=0;

        while(j<n){
            sum += nums[j];

            if(j-i+1>k){
                sum -= nums[i];
                i++;
            }

            if(j-i+1==k){
                maxSum = Math.max(maxSum,sum);
            }

            j++;
        }

        return maxSum;
    }*/
}
