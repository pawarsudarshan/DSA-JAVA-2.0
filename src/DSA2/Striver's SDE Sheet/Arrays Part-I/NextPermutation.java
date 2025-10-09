import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1,5,1};
        System.out.println(Arrays.toString(arr));
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int curr = n-1;

        while(curr>0){
            if(nums[curr-1]<nums[curr]){
                sortArray(nums, nums[curr-1],curr, n-1);
                return;
            }
            curr--;
        }

        if(curr==0) Arrays.sort(nums);
    }
    public static void sortArray(int[] arr, int target, int startIndex, int endIndex){
        int justHigher = arr[startIndex];
        int indexOfjustHigher = startIndex;

        for(int i=endIndex;i>=startIndex;i--){
            if(arr[i]>target){
                if(arr[i]<justHigher){
                    justHigher = arr[i];
                    indexOfjustHigher = i;
                }
            }
        }

        int temp = arr[indexOfjustHigher];
        arr[indexOfjustHigher] =  arr[startIndex-1];
        arr[startIndex-1] = temp;

        Arrays.sort(arr,startIndex,endIndex+1);
    }
}
