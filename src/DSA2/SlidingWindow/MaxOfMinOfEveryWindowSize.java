package DSA2.SlidingWindow;
import java.util.*;
import DSA2.BinaryTree.Pair;
/*
Approach:
1. Compute Next Smaller Element to Right
2. Compute Next Smaller Element to Left
3. For each i, calculate len = nsr[i]-nsl[i]-1
=> This means element nums[i] is the maximum for window of size len
4. Some entries might not be filled, propagate from right and fill them
 */
public class MaxOfMinOfEveryWindowSize {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 50, 10, 70, 30};
        System.out.println(maxOfMins(nums));
    }
    public static ArrayList<Integer> maxOfMins(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> res = new ArrayList<>();
        int[] ws = new int[n+1];

        List<Integer> nsl = nsl(nums);
        List<Integer> nsr = nsr(nums);

        for(int i=0;i<n;i++){
            int mx = nsr.get(i) - nsl.get(i) -1;
            ws[mx] = Math.max(ws[mx],nums[i]);
        }

        // filling in unvisited values
        for(int i=n-1;i>=1;i--){
            ws[i] = Math.max(ws[i],ws[i+1]);
        }
        for(int i=1;i<=n;i++){
            res.add(ws[i]);
        }
        return res;
    }
    /* Next Smaller to Left */
    public static List<Integer> nsl(int[] nums){
        int n = nums.length;
        Stack<Pair> st = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && st.peek().first>=nums[i]){
                st.pop();
            }

            if(st.isEmpty()) list.add(-1);
            else list.add(st.peek().second);

            st.add(new Pair(nums[i],i));
        }

        return list;
    }
    /* Next Smaller to Right */
    public static List<Integer> nsr(int[] nums){
        int n = nums.length;
        Stack<Pair> st = new Stack<>();
        List<Integer> list = new ArrayList<>(Collections.nCopies(n,0));

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek().first>=nums[i]){
                st.pop();
            }

            if(st.isEmpty()) list.set(i,n);
            else list.set(i,st.peek().second);

            st.add(new Pair(nums[i],i));
        }

        return list;
    }
    /* Solution using Heap => gives TLE
    public static ArrayList<Integer> maxOfMins(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;

        for(int x=1;x<=n;x++){
            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
                if (a.first != b.first) return a.first - b.first;  // smaller first → top
                return a.second - b.second;                        // tie → smaller second first
            });

            int max = Integer.MIN_VALUE; // calculates max of min

            int i=0,j=0;

            while(j<n){
                pq.add(new Pair(arr[j],j));
                if(j-i+1>x){
                    while(pq.size()>x && pq.peek().second<=i){
                        pq.poll();
                    }
                    i++;
                }
                if(j-i+1==x){
                    max = Math.max(max, pq.peek().first);
                }
                j++;
            }

            list.add(max);
        }
        return list;
    } */
}
