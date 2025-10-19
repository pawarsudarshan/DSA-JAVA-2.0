package DSA2.Arrays2;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {1,0,1,2};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        // working solution using map  O(N^2)
//        int n = nums.length, max = 0;
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int num:nums){
//            int left = 0, right = 0;
//            if(map.containsKey(num)){
//                continue;
//            }
//            if(map.containsKey(num-1)){
//                left = map.get(num-1);
//            }
//            if(map.containsKey(num+1)){
//                right = map.get(num+1);
//            }
//            int currMax = left+right+1;
//            if(currMax > max) max = currMax;
//            map.put(num,currMax);
//            while(left>0){
//                map.put(num-left, currMax);
//                left--;
//            }
//            while(right>0){
//                map.put(num+right, currMax);
//                right--;
//            }
//        }
//
//        return max;

        // using set
        int n =  nums.length;
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int num : nums){
            set1.add(num);
        }

        for(int num:set1){
            if(!set1.contains(num-1)){
                set2.add(num);
            }
        }

        int max = 0;
        for(int num:set2){
            int curr = 1;
            while(set1.contains(num+1)){
                num++;
                curr++;
            }
            if(curr>max) max = curr;
        }

        return max;
    }
}
