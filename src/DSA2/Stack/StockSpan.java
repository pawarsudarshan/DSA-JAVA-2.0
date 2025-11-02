package DSA2.Stack;
import java.util.*;
import DSA2.BinaryTree.Pair;
/*
No need for notes, understand the problem statement and
you'll get the intuition.
 */

public class StockSpan {
    public static void main(String[] args) {
        int[] nums = {100,80,60,70,60,75,85};
        System.out.println(stockSpan(nums));
    }
    public static List<Integer> stockSpan(int[] nums){
        List<Integer> list = new ArrayList<>();
        Stack<Pair> st = new  Stack<>();
        for(int i=0;i<nums.length;i++){
            int days = 1;
            while(!st.isEmpty() && st.peek().first<=nums[i]){
                days += st.pop().second;
            }
            st.push(new Pair(nums[i],days));
            list.add(days);
        }
        return list;
    }
}
