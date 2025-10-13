package DSA2.arrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
        List<List<Integer>> output = threeSum(arr);
        System.out.println(output);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n-2;i++){

            if(i>0){
                if(nums[i]==nums[i-1]){
                    continue;
                }
            }
            int start = i+1, end = n-1, sum = 0;
            while(start<end){
                sum = nums[i] + nums[start] + nums[end];
                if(start>i+1 && nums[start-1]==nums[start]){
                    start++;
                    continue;
                }
                if(end<n-1 && nums[end]==nums[end+1]){
                    end --;
                    continue;
                }
                if(sum==0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    ans.add(temp);
                    start++;
                    end--;
                }else if(sum<0){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return ans;
    }
}
