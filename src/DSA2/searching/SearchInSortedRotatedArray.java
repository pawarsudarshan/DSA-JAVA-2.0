package DSA2.searching;

public class SearchInSortedRotatedArray {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6,7,8,1};
        int target = 3;
        System.out.println(search(arr,target));
    }
    public static int search(int[] nums, int target) {
        int n = nums.length;
        if(nums[0]==target) return 0;
        if(nums[n-1]==target) return n-1;
        int start = 0, end = n-1;

        while(start<=end){
            int mid = start + (end-start)/2;
            int left= (mid-1+n)%n, right = (mid+1+n)%n;

            if(nums[mid]==target) return mid;

            if(nums[left]>nums[mid] && nums[right]>nums[mid]){
                    int reverseBSResult = binarySearch(nums,0,mid-1,target);
                    if(reverseBSResult!=-1) return reverseBSResult;
                    return binarySearch(nums,mid+1,n-1,target);
            }

            if(nums[mid]>nums[end]) start = mid + 1;
            else end = mid-1;
        }
        return -1;
    }
    public static int binarySearch(int[] nums, int start, int end, int target){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) end = mid-1;
            else start = mid+1;
        }
        return -1;
    }
}
