package DSA2.Heaps;
import java.util.*;
/*

*/
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> (a.first == b.first) ? a.second - b.second : b.first - a.first);

        int n = nums.length, j = 0;
        int[] res = new int[n-k+1];

        // add first k elements in heap
        for(int i=0;i<k;i++){
            pq.add(new Pair(nums[i],i));
        }

        res[j++] = pq.peek().first;

        for(int i=k;i<n;i++){
            pq.add(new Pair(nums[i],i));
            while(pq.peek().second<=i-k){
                pq.poll();
            }
            res[j++] = pq.peek().first;
        }

        return res;
    }
}
