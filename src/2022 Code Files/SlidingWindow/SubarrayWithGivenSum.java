package SlidingWindow;
import java.util.*;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,7,5};
        int n = arr.length;
        int target = 12;

        ArrayList<Integer> list = subarraySum(arr,n,target);
        System.out.println(list);
    }
    static ArrayList<Integer> subarraySum(int[] arr, int n, int target) {

        ArrayList<Integer> list = new ArrayList<>();
        if(target==0){
            list.add(-1);
            return list;
        }
        int i=0,j=0;
        int sum = 0;

        while(j<n){
            sum+=arr[j];

            while(sum>target){
                sum-=arr[i];
                i++;
            }

            if(sum==target){
                list.add(i+1);
                list.add(j+1);
                return list;
            }

            j++;
        }

        list.add(-1);
        return list;
    }
}

/*
2. Count distinct element in every window of size k
3. Count of substring of size k with k-1 distinct elements
*/
