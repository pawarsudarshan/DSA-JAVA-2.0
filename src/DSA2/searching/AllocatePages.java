package DSA2.searching;

public class AllocatePages {
    public static void main(String[] args) {
        int[] nums = {12,34,67,90};
        int k = 2;
        System.out.println(findPages(nums,k));
    }
    public static int findPages(int[] nums, int k){
        int start = 1_000_000_000, end = 0, ans = 0;
        if(k>nums.length || k<=0) return -1;

        for(int i=0;i<nums.length;i++){
            if(nums[i]<start) start = nums[i];
            end += nums[i];
        }

        while(start<=end){
            int mid = start + (end-start)/2;

            if(isAllocationPossible(nums,k,mid)){
                ans = mid;
                end = mid-1;
            }else start = mid+1;
        }
        return ans;
    }

    public static boolean isAllocationPossible(int[] nums, int k, int mid){
        int sum = nums[0], count = 1;

        for(int i=1;i<nums.length;i++){
            sum+=nums[i];
            if(sum>mid){
                sum = nums[i];
                count++;
            }
        }

        return count <= k;
    }
}
