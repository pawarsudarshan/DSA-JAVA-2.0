package DSA2.Arrays3;
import java.util.*;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {1,2,3};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
    public static int[] plusOne(int[] digits){
        int n = digits.length;
        for(int i=n-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0; // carry over
        }
        int[] ans = new int[n+1];
        ans[0] = 1;
        return ans;
    }
}
