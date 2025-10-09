package TwoPointers;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CountTripletsWithSumSmallerThanx {
    public static void main(String[] args) {
        long[] arr = {};
        int n = arr.length;
        int target = 12;
        System.out.println(countTriplets(arr,n,target));
    }
    static long countTriplets(long arr[], int n,int target) {
        Arrays.sort(arr);
        long count = 0;
        for(int i=0;i<n;i++){
            int start = i+1, end = n-1;
            while(start<end){
                if(arr[i] + arr[start] + arr[end] < target){
                    count += end - start;
                    start++;
                }
                else {
                    end--;
                }
            }
        }
        return count;
    }
}
