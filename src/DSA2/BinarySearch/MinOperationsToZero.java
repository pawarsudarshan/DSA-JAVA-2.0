package DSA2.BinarySearch;
import java.util.Arrays;
import java.util.HashMap;

/* LC 2528
Binary Search on Answer Approach
Prefix Sum concept
 */
public class MinOperationsToZero {
    public static void main(String[] args) {
        int[] nums = {0,3,6,5};
        int n = nums.length, ops = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int zeros = 0, count = 0;

        while((count+zeros)<=n) {
            int i = 0, j = 0;
            while (i < n) {
                j = i;
                boolean flag = false;
                int min = Integer.MAX_VALUE;
                while (j < n && nums[j] != 0) {
                    min = Math.min(min, nums[j]);
                    System.out.printf(nums[j] + " ");
                    j++;
                    flag = true;
                }
                System.out.println();
                if (flag) {
                    for (int k = i; k < j; k++) {
                        if (nums[k] == min){
                            count++;
                            nums[k] = 0;
                        }
                    }
                    ops++;
                    i = j + 1;
                } else{
                    zeros++;
                    i++;
                }
            }
        }

        for(int num:nums) System.out.printf(num+" ");
        System.out.println("Minimum Operations: "+ops);
    }
    public static boolean isAllZeros(int[] nums){
        for (int num : nums) {
            if (num != 0) return false;
        }
        return true;
    }
}