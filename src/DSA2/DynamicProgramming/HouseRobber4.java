package DSA2.DynamicProgramming;
import java.util.*;

public class HouseRobber4 {
    public static void main(String[] args) {
        int[] nums = {2,3,5,9};
        int k = 2;
        System.out.println(minCapability(nums,k));
    }

    // Binary Search on Answer Solution
    public static int minCapability(int[] nums, int k) {
        int start = 0, end = 1_000_000_000, ans = end;
        while(start<=end){
            int mid = start + (end-start)/2;

            if(check(nums,mid,k)){
                ans = mid;
                end = mid-1;
            }
            else start = mid+1;
        }

        return ans;
    }
    public static boolean check(int[] nums, int target, int k){
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=target){
                k--;
                i+=1; // skip adjacent to maintain condition
            }
        }
        return k<=0;
    }

    /* Pure Recursive solution with backtracking
    public static int minCapability(int[] nums, int k) {
        int[] res = new int[1];
        res[0] = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        solve(nums,k,nums.length-1,list,res);
        return res[0];
    }
    public static void solve(int[] nums, int k, int n, List<Integer> list, int[] res){
        // Base case
        if(k==0){
            int max = Integer.MIN_VALUE;
            for(int num:list){
                max = Math.max(max,num);
            }
            if(res[0]>max) res[0] = max;
        }

        if(n<0) return;

        // skip
        solve(nums,k,n-1,list,res);

        // rob
        list.add(nums[n]);
        solve(nums,k-1,n-2,list,res);
        list.remove(list.size()-1); // Backtrack
    }
    */
    /* Elegant Binary Search on Answer with DP Solution
    public static int minCapability(int[] nums, int k) {
        int start = 0, end = 1_000_000_000, ans = end;
        while(start<=end){
            int mid = start + (end-start)/2;
            int[][] dp = new int[k+1][nums.length];
            for(int[] row:dp) Arrays.fill(row,-1);
            if(check(nums,mid,k,nums.length-1,dp)){
                ans = mid;
                end = mid-1;
            }
            else start = mid+1;
        }

        return ans;
    }
    public static boolean check(int[] nums, int target, int k, int n, int[][] dp){
        // Base case
        if(k==0) return true;
        if(n<0) return false;

        // memoization
        if(dp[k][n]!=-1)
            return dp[k][n] != 0;

        // rob
        boolean rob = false;

        if(nums[n]<=target)
            rob = check(nums,target, k-1,n-2,dp);

        // skip
        boolean skip = check(nums,target, k,n-1,dp);

        // return statements - true or false
        if(rob || skip) dp[k][n] = 1;
        else dp[k][n] = 0;

        return rob || skip;
    }
*/
}
