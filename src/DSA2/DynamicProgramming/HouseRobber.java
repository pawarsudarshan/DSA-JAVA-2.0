package DSA2.DynamicProgramming;
/*
Tip:
Think how a problem can be optimized, think if the space you are using, can be reduced?
the time can be minimized using fewer loops/iterations, few operations?
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }
/* This was my first intuition - build a dp array, but as we are referring to only two values
from that dp array dp[i-1] & dp[i-2], the space can be optimized using two variables instead of
n length dp array;

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        if(nums.length==1) return dp[0];

        dp[1] = Math.max(nums[0],nums[1]);
        if(nums.length==2) return dp[1];

        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        return dp[nums.length-1];
    }
*/
    public static int rob(int[] nums){
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);

        int firstPrev = Math.max(nums[0],nums[1]), secondPrev = nums[0], ans;
        for(int i=2;i<nums.length;i++){
            ans = Math.max(firstPrev,secondPrev+nums[i]);
            secondPrev = firstPrev;
            firstPrev = ans;
        }

        return firstPrev;
    }
}
