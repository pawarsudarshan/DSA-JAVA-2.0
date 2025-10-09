package RandomDSAQuestions2;

import java.util.Scanner;
import java.util.Stack;

public class ValidString {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{')
                st.add(s.charAt(i));
            else if(st.size()>0 && s.charAt(i)==')'){
                if(st.peek()=='(') st.pop();
            }
            else if(st.size()>0 && s.charAt(i)==']'){
                if(st.peek()=='[') st.pop();
            }
            else if(st.size()>0 && s.charAt(i)=='}'){
                if(st.peek()=='{') st.pop();
            }
            else return false;
        }
        if(st.size()==0) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        if(isValid(s))
            System.out.println("The string is valid..");
        else
            System.out.println("The string is not valid");
    }
}
