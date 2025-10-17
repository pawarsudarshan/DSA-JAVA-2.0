package DSA2.Stack;
import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "{[])}";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                st.push(s.charAt(i));
            }else{
                if(!st.empty()){
                    char top = st.peek();
                    if(s.charAt(i)==')' && top =='('){
                        st.pop();
                    } else if(s.charAt(i)==']' && top =='['){
                        st.pop();
                    }else if(s.charAt(i)=='}' && top == '{'){
                        st.pop();
                    }
                    else return false;
                }
                else return false;
            }
        }
        return st.empty();
    }
}
