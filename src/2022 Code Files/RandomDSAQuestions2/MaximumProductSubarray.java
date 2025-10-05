package RandomDSAQuestions2;

import java.util.Scanner;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        System.out.println("The maximum product subarray is: "+ maxProdSubarray(arr,n));
    }

    static int maxProdSubarray(int[] arr, int n){
        int ans = arr[0], max_product=ans, min_product=ans;

        for(int i=1;i<n;i++){
            if(arr[i]<0) {
                int temp = max_product;
                max_product = min_product;
                min_product = temp;
            }

            max_product = Math.max(arr[i], arr[i]*max_product);
            min_product = Math.min(arr[i], arr[i]*min_product);
            ans = Math.max(ans,max_product);
        }
        return ans;
    }
}
