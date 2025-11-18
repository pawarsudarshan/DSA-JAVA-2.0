package DSA2.BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,3,4,5,8,9,12};
        int target = 8;
        System.out.println(binarySearch(nums,target));
    }
    public static boolean binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return true;
            } else if(nums[mid] < target){
                low = mid + 1;
            } else high = mid - 1;
        }

        return false;
    }
}
