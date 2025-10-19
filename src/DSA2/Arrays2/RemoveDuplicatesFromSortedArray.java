package DSA2.Arrays2;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,4};
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length==1) return 1;
        int start = 1, count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]!=nums[i]){
                count++;
                nums[start] = nums[i];
                start++;
            }
        }
        return count;
    }
}
