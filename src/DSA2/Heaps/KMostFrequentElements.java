package DSA2.Heaps;
import java.util.*;
/*
Learn about map.compute in Java8+ HashMap
 */

public class KMostFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,5,2,2,1,1,3,3,2,2,4,2};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums,k)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.second - b.second);
        int[] ans = new int[k];

        for(int i=0;i<nums.length;i++){
            map.compute(nums[i], (key, val) -> val == null ? 1 : val + 1);
        }

        for(Map.Entry<Integer,Integer> pair : map.entrySet()){
            int key = pair.getKey();
            int value = pair.getValue();
            pq.add(new Pair(key,value));
            if(pq.size()>k) pq.poll();
        }

        for(int i=0;i<k;i++){
            ans[i] = pq.poll().first;
        }

        return ans;
    }
}

class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
