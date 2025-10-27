package DSA2.Heaps;
import java.util.*;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {2,3,5,1,9};
        int k = 2;
        System.out.println(findKthLargest(nums,k));
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k) pq.poll();
        }
        return pq.poll();
    }
}
