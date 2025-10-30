package DSA2.DynamicProgramming;

public class EqualSubsetSum {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        EqualSubsetSum obj = new EqualSubsetSum();
        System.out.println(obj.canPartition(nums));
    }

    // working bottom up dp solution
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;

        if ((sum & 1) == 1) return false; // odd sum can't be partitioned equally

        int target = sum / 2;
        boolean[][] dp =  new boolean[n][target + 1];

        for(int i=0;i<n;i++){
            for(int j=0;j<=target;j++){
                if(i==0&&j==0){
                    dp[i][j] = true;
                }
                if(i>0){
                    if(j-nums[i]>=0){
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                    }else dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n-1][target];
    }

    /* Pure Recursive Solution
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;

        if ((sum & 1) == 1) return false; // odd sum can't be partitioned equally

        int target = sum / 2;
        return check(nums, n - 1, 0, target);
    }

    public boolean check(int[] nums, int index, int currSum, int target) {
        if (currSum == target) return true;          // found a subset
        if (index < 0 || currSum > target) return false; // invalid path

        // include or exclude current element
        boolean include = check(nums, index - 1, currSum + nums[index], target);
        boolean exclude = check(nums, index - 1, currSum, target);

        return include || exclude;
    }
     */

}
