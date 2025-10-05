package TwoPointers;
import java.util.*;

public class DamOfCandies {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 6, 5};
        int n = arr.length;
        System.out.println(maxCandy(arr,n));
    }
    static int maxCandy(int arr[], int n) {
        int start = 0, end = n-1;
        int ans = 0;

        while (start<end){
            ans = Math.max(ans,(Math.min(arr[start], arr[end]) * (end-start-1)));

            if(arr[start]<arr[end])
                start++;

            else end--;
        }

        return ans;
    }
}
