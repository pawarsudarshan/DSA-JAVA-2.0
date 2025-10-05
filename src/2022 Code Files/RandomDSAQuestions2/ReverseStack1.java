package RandomDSAQuestions2;

import java.util.Scanner;
import java.util.Stack;

public class ReverseStack1 {
    public static void InsertAtBottom(Stack<Integer> st, int key){
        if(st.size()==0){
            st.add(key);
            return;
        }
        int top = st.pop();
        InsertAtBottom(st,key);
        st.add(top);
    }
    public static void ReverseMyStack(Stack<Integer> st){
        if(st.size()==0){
            return;
        }
        int top = st.pop();
        ReverseMyStack(st);
        InsertAtBottom(st,top);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        Scanner sc = new Scanner(System.in);

        for(int i=0;i<5;i++){
            int input = sc.nextInt();
            st.add(input);
        }

        System.out.println(st);
        ReverseMyStack(st);
        System.out.println(st);
    }
}
