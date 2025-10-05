package RandomDSAQuestions2;

import java.util.Arrays;
import java.util.Scanner;

public class MoveNegativeToTheEnd {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        System.out.println(Arrays.toString(arr));

        int k = 0;
        for(int i=0;i<n;i++){
            if(arr[i]<0){
                swap(arr,i,k);
                k++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
    public static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}