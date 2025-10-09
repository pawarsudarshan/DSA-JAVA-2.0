package RandomDSAQuestions;
import java.util.*;

public class Knapsack01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int w = sc.nextInt();

        int[] values = new int[n];
        for(int i=0;i<n;i++)
            values[i]= sc.nextInt();

        int[] weight = new int[n];
        for(int i=0;i<n;i++)
            weight[i] = sc.nextInt();

        System.out.println(knapSack(w,weight,values,n));
    }

    static int knapSack(int W, int wt[], int val[], int n) {
        if(n==0 || W==0) return 0;

        if(wt[n-1]<=W)
            return Math.max(val[n-1]+knapSack(W-wt[n-1],wt,val,n-1), knapSack(W,wt,val,n-1));

        return knapSack(W,wt,val,n-1);
    }
}