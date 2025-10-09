package BinarySearch;
import java.util.*;

public class SpecialKeyboard {
    public static void main(String[] args) {
        System.out.println(optimalKeys(3));
    }
    static int optimalKeys(int n){
        int[] dp = new int[n+3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=n;i++){
            dp[i] = i;
            for(int j=1;j<=i-3;j++){
//                int some_term = 3242;
                dp[i] = Math.max(dp[i], dp[j]*(i-j-1));
            }
        }

//        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
