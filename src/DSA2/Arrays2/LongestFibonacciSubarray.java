package DSA2.Arrays2;

public class LongestFibonacciSubarray {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,5,8,23,98};
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int allTimeMax = 2, currMax = 2, prevsum;
        for(int i=2;i<nums.length;i++){
            prevsum = nums[i-1]+nums[i-2];
            if(nums[i]==prevsum){
                currMax ++;
                if(currMax>allTimeMax) allTimeMax = currMax;
            }else{
                currMax = 2;
            }
        }
        return allTimeMax;
    }
}
