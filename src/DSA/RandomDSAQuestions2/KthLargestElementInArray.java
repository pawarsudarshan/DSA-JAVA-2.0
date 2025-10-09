package RandomDSAQuestions2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestElementInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i]= sc.nextInt();

        int k = sc.nextInt();

        System.out.println("The Kth largest element in the array is : "+ kthlargest(arr,k));
    }
    public static int kthlargest(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();
    }
}
