package DSA2.Stack;
import java.util.*;

public class NextGreaterElement1 {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int[] nextGreater = new int[nums1.length];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=nums2.length-1;i>=0;i--){
            while(!st.empty() && st.peek()<nums2[i]){
                st.pop();
            }
            if(st.empty()){
                map.put(nums2[i],-1);
            }else{
                map.put(nums2[i], st.peek());
            }
            st.push(nums2[i]);
        }

        for(int i=0;i<nums1.length;i++){
            nextGreater[i] = map.get(nums1[i]);
        }

        return nextGreater;
    }
}

