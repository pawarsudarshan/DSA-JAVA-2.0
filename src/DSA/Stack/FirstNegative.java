package Stack;
import java.util.*;

public class FirstNegative {
    public static void main(String[] args) {
        long[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int n = arr.length;
        int k = 3;

        long[] answer = printFirstNegativeInteger(arr,n,k);
        System.out.println(Arrays.toString(answer));
    }
    static long[] printFirstNegativeInteger(long arr[], int n, int k) {
        Queue<Long> q = new ArrayDeque<>();
        long[] answer = new long[n-k+1];

        int i=0,j=0,l=0;

        while (j<n){
            if(arr[j]<0){
                q.add(arr[j]);
            }

            while(j-i+1>k){
                if(!q.isEmpty() && arr[i]==q.peek()){
                    q.poll();
                }
                i++;
            }

            if(j-i+1==k){
                if(!q.isEmpty())
                answer[l++] = q.peek();
                else answer[l++] = 0;
            }

            j++;
        }
        return answer;
    }
}
