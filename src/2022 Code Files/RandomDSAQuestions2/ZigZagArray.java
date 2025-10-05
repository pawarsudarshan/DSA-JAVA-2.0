package RandomDSAQuestions2;

import java.util.Arrays;

public class ZigZagArray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2};
        int n = arr.length;

        System.out.println(Arrays.toString(arr));

        zigZag(arr,n);

        System.out.println(Arrays.toString(arr));
    }

    static void zigZag(int arr[], int n) {
        for(int i=0;i<n-1;i++){
            if(i%2==0){
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            else{
                if(arr[i]<arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
    }
}
