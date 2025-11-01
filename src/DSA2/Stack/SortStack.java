package DSA2.Stack;
import java.util.*;
/*

 */
public class SortStack {
    /* Sorting a stack using a helper stack and output stack */
    public void sortStack(Stack<Integer> st) {
        Stack<Integer> output = new Stack<>();
        Stack<Integer> helper = new Stack<>();

        while(!st.isEmpty()){
            int num = st.pop();
            while(!output.isEmpty() && output.peek()<num){
                helper.push(output.pop());
            }
            output.push(num);
            while(!helper.isEmpty()){
                output.push(helper.pop());
            }
        }

        while(!output.isEmpty()){
            st.push(output.pop());
        }
    }
}
