package DSA2.Arrays1;

public class MaximumSubArray {
    public static void main(String[] args) {
        // run code
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        int sum = 0, maxsum = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(sum > maxsum){maxsum = sum;}
            if(sum<0) sum =0;
        }

        return maxsum;
    }
}