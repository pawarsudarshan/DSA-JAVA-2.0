package RandomDSAQuestions2;

import java.util.Scanner;

public class KadaneAlgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        int sum = 0, ans = arr[0];
        for(int i=0;i<n;i++){
            sum += arr[i];
            ans = Math.max(ans,sum);
            if(sum<0) sum = 0;
        }
        System.out.println(ans);
    }
}
