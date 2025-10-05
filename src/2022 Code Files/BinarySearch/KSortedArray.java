package BinarySearch;
import java.util.*;

public class KSortedArray {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int n = arr.length;
        int k = 2;

        String output = isKSortedArray(arr,n,k);
        System.out.println(output);
    }

    static String isKSortedArray(int arr[], int n, int k) {
        int[] dup = new int[n];
        for(int i=0;i<n;i++){
            dup[i] = arr[i];
        }
        Arrays.sort(dup);

        for(int i=0;i<n;i++){
            int diff = Math.abs(binary_search(dup,arr[i])-i);
            if(diff>k) return "No";
        }
        return "Yes";
    }

    static int binary_search(int arr[], int target){
        int start = 0, end = arr.length-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(arr[mid]==target) return mid;

            else if(arr[mid]<target){
                start = mid+1;
            }

            else end = mid-1;
        }

        return -1;
    }
}
