package DSA2.Greedy;

public class MinimumOperations {
    public static void main(String[] args) {
        int[] nums = {3,1,5,4,2};
        System.out.println(minNumberOperations(nums));
    }
    /*
    🔎 Why This Works:
    - You only need to increment when the current value is greater than the previous.
    - This captures the net increase needed at each step.
   */
    public static int minNumberOperations(int[] nums) {
        int ops = nums[0];

        for(int i=1;i<nums.length;i++)
            ops += Math.max(0,nums[i]-nums[i-1]);

        return ops;
    }

    /*
    My Intuitive solution using recursion (works but gives TLE because of O(n^2) TC)

    public static int minNumberOperations(int[] nums) {
        return solve(nums,nums.length-1);
    }

    public static int solve(int[] nums, int n){
        // Base Case
        if(n<0) return 0;

        int j=n, recur = 0, ans1 = 0;
        boolean flag = false;

        while(j>=0){
            if(nums[j]==0){
                flag = true;
                recur += solve(nums,j-1);
                break;
            }
            j--;
        }

        if(flag || j<0){
            int i = j+1;
            j = n;
            if(!isAllZeros(nums,i,j)) {
                int min = Integer.MAX_VALUE;

                for(int k=i;k<=j;k++)
                    min = Math.min(min,nums[k]);

                for(int k=i;k<=j;k++)
                    nums[k] -= min;


                ans1 = min + solve(nums,n);
            }
        }

        return recur+ans1;
    }

    public static boolean isAllZeros(int[] nums, int start, int end){
        for(int i=start;i<=end;i++){
            if(nums[i]!=0) return false;
        }
        return true;
    }
     */
}
