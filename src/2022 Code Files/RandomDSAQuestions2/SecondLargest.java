package RandomDSAQuestions2;

import java.util.Scanner;

public class SecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        int first_greatest, second_greatest;

        if(arr[0]>arr[1]) {
            first_greatest = arr[0];
            second_greatest = arr[1];
        }
        else{
            first_greatest = arr[1];
            second_greatest = arr[0];
        }

        for(int i=2;i<n;i++){
            if(arr[i]>first_greatest){
                second_greatest = first_greatest;
                first_greatest = arr[i];
            }
            else if(arr[i] > second_greatest)
                second_greatest = arr[i];
        }

        System.out.println(second_greatest);
    }
}
