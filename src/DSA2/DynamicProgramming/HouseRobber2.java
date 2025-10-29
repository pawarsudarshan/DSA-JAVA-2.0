package DSA2.DynamicProgramming;
/*
PS:
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed.
All houses at this place are arranged in a circle.
That means the first house is the neighbor of the last one.
Meanwhile, adjacent houses have a security system connected,
and it will automatically contact the police if two adjacent houses were broken into on the same night.

Approach:
Max of:
1. all houses except the last one
2. all houses except the first one
 */
public class HouseRobber2 {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);

        return Math.max(rob1(nums,0,nums.length-2),rob1(nums,1,nums.length-1));
    }

    public int rob1(int[] nums, int st, int end){
        if(end-st+1==1) return nums[st];
        if(end-st+1==2) return Math.max(nums[st],nums[end]);

        int firstPrev = Math.max(nums[st],nums[st+1]), secondPrev = nums[st], ans;
        for(int i=st+2;i<=end;i++){
            ans = Math.max(firstPrev,secondPrev+nums[i]);
            secondPrev = firstPrev;
            firstPrev = ans;
        }

        return firstPrev;
    }
}
