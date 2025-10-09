package BinaryHeap;
import java.util.*;

public class KMostOccurring {
    public static void main(String[] args) {
        int[] arr = {3,1,4,4,5,2,6,1};
        int n = arr.length;
        int k = 2;
        System.out.println(kMostFrequent(arr,n,k));
    }
    static int kMostFrequent(int arr[], int n, int k){
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0;i<n;i++){
            // try to implement heap using pair
            System.out.println(i);
        }
        return 0;
    }
}
