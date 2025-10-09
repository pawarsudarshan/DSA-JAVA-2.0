package BinarySearch;
import java.util.*;

public class FirstAndLastOccurrence {
    public static void main(String[] args) {
        long[] arr = { 1, 3, 5, 5, 5, 5, 7, 123, 125 };
        int n = arr.length;
        int target = 5;

        ArrayList<Long> list = find(arr,n,target);
        System.out.println(list);
    }

    static ArrayList<Long> find(long arr[], int n, int target) {
        ArrayList<Long> list = new ArrayList<>();
        list.add(firstOccurance(arr,n,target));
        list.add(lastOccurrence(arr,n,target));
        return list;
    }

    static Long lastOccurrence(long[] arr, int n, int target) {
        int start = 0, end = n-1;
        Long ans = Long.valueOf(-1);

        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]==target){
                ans = Long.valueOf(mid);
                start = mid+1;
            }else if(arr[mid]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }

    static Long firstOccurance(long[] arr, int n, int target) {
        int start = 0, end = n-1;
        Long ans = Long.valueOf(-1);

        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]==target){
                ans = Long.valueOf(mid);
                end = mid-1;
            }else if(arr[mid]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }
}
