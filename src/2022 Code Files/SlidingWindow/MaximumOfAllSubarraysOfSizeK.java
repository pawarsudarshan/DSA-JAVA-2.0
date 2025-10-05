package SlidingWindow;
import java.util.*;
public class MaximumOfAllSubarraysOfSizeK {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,4,5,2,3,6};
        int n = arr.length;
        int k  = 3;

        ArrayList<Integer> list = max_of_subarrays(arr,n,k);
        System.out.println(list);
    }
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k) {
        // applying sliding window algorithm
        int i=0,j=0;
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<Integer>();

        while(j<n){
            while(deque.size()>0 && deque.peekLast()<=arr[j]){
                deque.removeLast();
            }

            deque.addLast(arr[j]);

            while((j-i+1)>k){
                if(deque.size()>0 && deque.peekFirst()==arr[i]){
                    deque.pollFirst();
                }
                i++;
            }

            if((j-i+1)==k){
                list.add(deque.peekFirst());
            }

            j++;
        }

        return list;
    }
}