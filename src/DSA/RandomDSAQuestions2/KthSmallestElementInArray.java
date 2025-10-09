package RandomDSAQuestions2;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthSmallestElementInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i]= sc.nextInt();

        int k = sc.nextInt();

        System.out.println("The Kth smallest element in the array is : "+ kthSmallest(arr,k));
        fibo();
    }

    static int kthSmallest(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
    static void fibo(){
        int n = 10;
        int first = 1, second = 0;
        for(int i=1;i<=n;i++){
            int curr = first + second;
            System.out.println(curr);
            second = first;
            first = curr;
        }
    }
}