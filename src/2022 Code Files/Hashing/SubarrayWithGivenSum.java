package Hashing;
import java.util.*;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {10,2,-2,-20,10};
        int n = arr.length;
        System.out.println(subArraySum(arr,n,-10));
    }

    static int subArraySum(int arr[], int n, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum = 0;
        int count = 0;
        hm.put(0,1);

        for(int i=0;i<n;i++){
            sum += arr[i];

            if(hm.containsKey(sum-target)){
                count+=hm.get(sum-target);
            }

            if(hm.containsKey(sum)){
                int val = hm.get(sum);
                hm.put(sum,val+1);
            }else{
                hm.put(sum,1);
            }
        }

        return count;
    }
}