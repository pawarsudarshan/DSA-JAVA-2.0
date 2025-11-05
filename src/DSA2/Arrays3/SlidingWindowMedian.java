package DSA2.Arrays3;
import java.util.*;
/* Approach: using two heaps, minHeap & maxHeap
store indices instead of values=> this eliminates duplicated values problem
use comparator which compares nums[i] instead of i

maxHeap => stores first half sorted array
minHeap => stores second half of sorted array
main motive: to be able to access middle element at O(1) time
balanceHeaps() at every step, so that you can access middle element correctly

🔁 Insertion Logic
- Add new index to minHeap
- Move smallest from minHeap to maxHeap
- Call balanceHeaps() to maintain size property
if k is odd => median is minHeap.first()
if k is even => median is median of nums[minHeap.first()] & nums[maxHeap.first()]
 */
public class SlidingWindowMedian {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(medianSlidingWindow(nums,k)));
    }

    public static TreeSet<Integer> minHeap, maxHeap;

    public static double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] result = new double[n - k + 1];

        // Comparator to sort indices by value, then by index
        Comparator<Integer> cmp = (a, b) ->
                nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : Integer.compare(a, b);

        minHeap = new TreeSet<>(cmp);             // Holds larger half
        maxHeap = new TreeSet<>(cmp.reversed());  // Holds smaller half

        int i = 0, j = 0;
        while(j<n) {
            // Insert new index
            minHeap.add(j);
            maxHeap.add(minHeap.pollFirst());
            balanceHeaps();

            if(j-i+1>k){
                // Remove outgoing index
                if (!minHeap.remove(i)) {
                    maxHeap.remove(i);
                }
                balanceHeaps();
                i++;
            }

            if(j-i+1==k){
                result[i] = k % 2 == 1 ? nums[minHeap.first()]:
                        ((double) nums[minHeap.first()] + nums[maxHeap.first()]) / 2.0;
            }

            j++;
        }

        return result;
    }

    public static void balanceHeaps() {
        while (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.pollFirst());
        }
        while (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.pollFirst());
        }
    }
}
