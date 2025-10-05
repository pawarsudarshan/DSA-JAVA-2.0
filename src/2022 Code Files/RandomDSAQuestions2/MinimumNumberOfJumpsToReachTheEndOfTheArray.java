package RandomDSAQuestions2;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumNumberOfJumpsToReachTheEndOfTheArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        System.out.println("Minimum number of jumps required are: "+ minJumps2(arr));
    }
    static int minJumps2(int[] arr){

        if(arr.length==1 && arr[0]==0) return 0;
        if(arr[0]==0) return -1; // Edge cases from gfg

        int stairs = arr[0], maxReach = arr[0];
        int n = arr.length, jumps = 1;

        for(int i=1;i<n-1;i++){
            maxReach = Math.max(maxReach, arr[i]+i);
            stairs--;

            if(stairs==0){
                jumps++;
                stairs = maxReach - i;
                if(stairs<=0) return -1; // if we don't have any stairs available, we can not move further from here
            }
        }
        return jumps;
    }
    static int minJumps(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(j+arr[j]>=i){
                    dp[i] = Math.min(dp[i], 1+dp[j]);
                }
            }
        }

        for(int val:dp)
            System.out.print(val+" ");

        return dp[n-1];
    }
}
