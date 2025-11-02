package DSA2.Stack;
import java.util.*;
/* Using Recursion:
1. pop top element and save it
2. sort the remaining stack using recursion
3. place the saved top element at it's correct position in sorted stack
 */
public class SortStack {
    /* Using Recursion */
    public void sort(Stack<Integer> st){
        if(st.isEmpty()) return;

        int top = st.pop();
        sort(st);

        Stack<Integer> st2 = new Stack<>();
        while(!st.isEmpty() && st.peek()>top){
            st2.add(st.pop());
        }
        st.add(top);
        while(!st2.isEmpty()){
            st.add(st2.pop());
        }
    }
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
