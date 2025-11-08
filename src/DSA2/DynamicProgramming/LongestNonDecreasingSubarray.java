package DSA2.DynamicProgramming;
/* Problem Statement: You are given an integer array nums.
You are allowed to replace at most one element in the array with any other integer value of your choice.
Return the length of the longest non-decreasing subarray that can be obtained after performing at most one replacement.

Approach:
store longest non-decreasing subarray length at each index from left and right into an array
and calculate the final answer accordingly
 */
public class LongestNonDecreasingSubarray {
    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(longestSubarray(nums));
    }
    public static int longestSubarray(int[] nums) {
        if(nums.length==0 || nums.length==1) return nums.length;
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for(int i=1;i<n;i++){
            if(nums[i-1]<=nums[i]){
                left[i] = 1 + left[i-1];
            }else left[i] = 1;
        }

        right[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<=nums[i+1]){
                right[i] = 1 + right[i+1];
            }else right[i] = 1;
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            int way1 = 0, way2 = 0, way3 = 0;
            // way 1 => integrate with left
            if(i-1>=0) way1 = left[i-1] + 1;

            // way 2 => integrate with right
            if(i+1<n) way2 = right[i+1] +1;

            // way 3 => join left and right
            if(i-1>=0 && i+1<n && nums[i+1]>=nums[i-1])
                way3 = left[i-1]+right[i+1]+1;

            ans = Math.max(ans,Math.max(way1,Math.max(way2,way3)));
        }
        return ans;
    }
}
