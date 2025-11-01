package DSA2.Stack;
import java.util.*;
/*

 */
public class NextSmallerElement {
    public static void main(String[] args) {
        int[] nums = {4, 8, 5, 2, 25};
        System.out.println(nextSmallerEle(nums));
    }
    public static ArrayList<Integer> nextSmallerEle(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> nextSmaller = new ArrayList<>(Collections.nCopies(n, 0));

        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            // pop elements from stack if top >= curr
            while(!st.isEmpty() && st.peek()>=arr[i]){
                st.pop();
            }

            if(st.isEmpty()) nextSmaller.set(i,-1);
            else nextSmaller.set(i,st.peek());

            st.add(arr[i]);
        }

        return nextSmaller;
    }
}
