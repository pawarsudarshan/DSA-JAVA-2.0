package RandomDSAQuestions2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class StackAndQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        Queue<Integer> q = new LinkedList<>();

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<5;i++){
            arr[i] = sc.nextInt();
            st.add(arr[i]);
            q.add(arr[i]);
        }

        System.out.println("The size of tha stack is : "+ st.size());

        while(st.size()>0){
            System.out.print(st.pop()+ " ");
        }
        System.out.println();

        System.out.println("The size of tha stack is : "+ st.size());
        System.out.println(q.stream().findFirst());

        while(q.size()>0){
            System.out.print(q.peek()+" ");
            q.poll();
        }
        System.out.println();
    }
}
