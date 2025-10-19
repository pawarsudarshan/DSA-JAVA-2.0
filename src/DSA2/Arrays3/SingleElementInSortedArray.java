package DSA2.Arrays3;

// Sorted Array - Binary Search

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,1,2};
        System.out.println(singleNonDuplicate(arr));
    }

    public static int singleNonDuplicate(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums[0]!=nums[1]) return nums[0];
        if(nums[nums.length-1]!=nums[nums.length-2]) return nums[nums.length-1];

        int start = 0, end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;

            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]) return nums[mid];

            if(mid%2==0){
                if(nums[mid]==nums[mid+1]) start = mid+1;
                else end = mid-1;
            }else{
                if(nums[mid]==nums[mid+1]) end = mid-1;
                else start = mid+1;
            }
        }
        return -1;
    }
}
