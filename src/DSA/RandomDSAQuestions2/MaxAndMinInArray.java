package RandomDSAQuestions2;

import java.util.Scanner;

public class MaxAndMinInArray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];
        int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;

        for(int i=0;i<5;i++){
            arr[i] = sc.nextInt();
            mx = Math.max(mx, arr[i]);
            mn = Math.min(mn, arr[i]);
        }
        System.out.println(mx);
        System.out.println(mn);

    }
}