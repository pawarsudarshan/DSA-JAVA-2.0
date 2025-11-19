package DSA2.Arrays3;
import java.util.*;

public class KeepMultiplyingFoundValues {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,8,9,16,23,98};
        int original = 1;
        System.out.println(findFinalValue(nums,original));
    }
    public static int findFinalValue(int[] nums, int original) {
        Set<Integer> s = new HashSet<>();
        for(int num:nums) s.add(num);
        int i=0;
        while(i<nums.length){
            if(s.contains(original)){
                original *= 2;
                i++;
            }else break;
        }
        return original;
    }
}
