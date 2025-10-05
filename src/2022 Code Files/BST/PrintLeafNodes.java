package BST;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class PrintLeafNodes {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int n = arr.length;
        int[] answer = leafNodes(arr,n);
        System.out.println(Arrays.toString(answer));
    }
    static int[] leafNodes(int arr[], int n) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for(int i=1;i<n;i++){
            int left = arr[i-1];
            int right = arr[i];

            if(right<left)
                st.add(left);

            else{
                int removed = 1;
                while(st.size()>0 && st.peek()<=right){
                    st.pop();
                    removed++;
                }
                if(removed>=2){
                    list.add(left);
                }
            }
        }

        list.add(arr[n-1]);
        int[] output = new int[list.size()];

        for(int i=0;i<list.size();i++){
            output[i] = list.get(i);
        }

        return output;
    }
}


/*
        Nice try but it didn't work

        ArrayList<Integer> list = new ArrayList<>();
        int largeTillNow = arr[0];

        for(int i=1;i<n-1;i++){
            if(arr[i-1]>arr[i] && arr[i+1]>arr[i] && arr[i-1]<arr[i+1])
            list.add(arr[i]);

            else if(arr[i-1]<arr[i] && arr[i+1]>arr[i] && arr[i]<=largeTillNow)
            list.add(arr[i]);

            largeTillNow = Math.max(largeTillNow,arr[i]);
        }

        list.add(arr[n-1]);

        int[] output = new int[list.size()];

        for(int i=0;i<list.size();i++){
            output[i] = list.get(i);
        }

        return output;
*/