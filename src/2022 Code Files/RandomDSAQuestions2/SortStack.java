package RandomDSAQuestions2;

import java.util.Scanner;
import java.util.Stack;

public class SortStack {

    public static void InsertAtCorrectPosition(Stack<Integer> st, int key){
        if(st.size()==0 || st.peek()<key){
            st.add(key);
            return;
        }

        int top = st.pop();
        InsertAtCorrectPosition(st,key);
        st.add(top);
    }
    public static void SortMyStack(Stack<Integer> st){
        if(st.size()==0){
            return;
        }
        int top = st.pop();
        SortMyStack(st);
        InsertAtCorrectPosition(st,top);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<5;i++){
            int input = sc.nextInt();
            st.add(input);
        }

        System.out.println(st);
        SortMyStack(st);
        System.out.println(st);
    }
}
