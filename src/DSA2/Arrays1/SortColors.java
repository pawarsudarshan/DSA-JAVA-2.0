package DSA2.Arrays1;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortColors(int[] nums) {
//        ------------- Solution 1 (double pass)--------------------
//        int leftEnd = 0, rightEnd = nums.length-1;
//        for(int i=0;i<=nums.length-1;i++){
//            if(nums[i]==0){
//                int temp = nums[i];
//                nums[i] = nums[leftEnd];
//                nums[leftEnd] = temp;
//                leftEnd++;
//            }
//        }
//
//        for(int j=nums.length-1;j>=0;j--){
//            if(nums[j]==2){
//                int temp = nums[j];
//                nums[j] = nums[rightEnd];
//                nums[rightEnd] = temp;
//                rightEnd--;
//            }
//        }

//        ------------------- Solution 2 (single pass) ------------------
        int leftEnd = 0, i = 0, rightEnd = nums.length - 1;
        while(i<=rightEnd){
            if(nums[i]==0){
                int temp =  nums[leftEnd];
                nums[leftEnd] = nums[i];
                nums[i] = temp;
                leftEnd++;
                i++;
            }
            else if(nums[i]==2){
                int temp  =  nums[rightEnd];
                nums[rightEnd] = nums[i];
                nums[i] = temp;
                rightEnd--;
            }
            else { i++;}
        }
    }
}
