package RandomDSAQuestions2;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementStack {
    public static int[] nextGreater(int[] arr){
        int n = arr.length;
        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(st.size()>0 && st.peek()<arr[i])
                st.pop();

            if(st.size()==0)
                res[i] = -1;

            else res[i] = st.peek();

            st.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        int[] res = nextGreater(arr);

        for(int ele: res)
            System.out.print(ele+" ");
    }
}
