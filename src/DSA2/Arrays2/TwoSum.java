package DSA2.Arrays2;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int [] nums = {2,5,5,11};
        int target = 10;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int [] ans = new int[2];
        int [] newNums = new int[n];

        System.arraycopy(nums, 0, newNums, 0, n);

        Arrays.sort(newNums);

        int start = 0, end = n-1;
        while(start<=end){
            int sum = newNums[start]+ newNums[end];

            if(sum==target) {
                if(newNums[start]==newNums[end]){
                    boolean foundFirst = false;
                    for(int i=0;i<n;i++) {
                        if (!foundFirst && newNums[start] == nums[i]) {
                            ans[0] = i;
                            foundFirst = true;
                        }
                        else if (foundFirst && newNums[end] == nums[i]) {
                            ans[1] = i;
                        }
                    }
                    return ans;
                }
                for(int i=0;i<n;i++) {
                    if (newNums[start] == nums[i]) {
                        ans[0] = i;
                    }
                    if (newNums[end] == nums[i]) {
                        ans[1] = i;
                        System.out.println(i);
                    }
                }

                return ans;
            }
            if(sum>target){
                end--;
            }
            else start++;
        }
        return ans;
    }
}
