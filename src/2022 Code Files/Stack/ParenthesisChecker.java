package Stack;
import java.util.Stack;

public class ParenthesisChecker {
    public static void main(String[] args) {
        String s = "([]";
        System.out.println(ispar(s));
    }
    static boolean ispar(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                st.add(s.charAt(i));
            }
            else if(s.charAt(i)==')' && (!st.empty() && st.peek()=='(')){
                st.pop();
            }else if(s.charAt(i)==']' && !st.empty() && st.peek()=='['){
                st.pop();
            }else if(s.charAt(i)=='}' && !st.empty() && st.peek()=='{'){
                st.pop();
            }
            else return false;
        }

        return st.empty();
    }
}
