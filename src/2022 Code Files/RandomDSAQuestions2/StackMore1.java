package RandomDSAQuestions2;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class StackMore1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<5;i++){
            int input = sc.nextInt();
            st.add(input);
        }

        Iterator it = st.iterator();
        System.out.println("printing the elements of stack -> ");
        System.out.print("using iterator: ");
        while(it.hasNext()){
            System.out.print(it.next()+ " ");
        }
        System.out.println();
        System.out.print("using while loop : ");
        while(st.size()>0){
            System.out.print(st.pop()+" ");
        }
    }
}
