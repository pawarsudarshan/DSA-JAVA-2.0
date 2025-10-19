package DSA2.Arrays2;

import java.util.HashMap;
import java.util.Map;

public class SumOfElementsWithFrequencyDivisibleByK {
    public static void main(String[] args) {
        int [] nums = {1,2,2,3,3,3,3,4};
        int k = 2;
        System.out.println(sumDivisibleByK(nums,k));
    }
    public static int sumDivisibleByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int freq = map.get(nums[i]) + 1;
                map.replace(nums[i],freq);
            }else{
                map.put(nums[i],1);
            }
        }

        int sum = 0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()%k==0){
                sum += entry.getKey() * entry.getValue();
            }
        }

        return sum;
    }
}
