package SlidingWindow;
import java.util.*;

public class DistinctElementsInEveryWindow {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,4,2,3};
        int n = arr.length;
        int k = 4;

        ArrayList<Integer> list = countDistinct(arr,n,k);
        System.out.println(list);
    }
    static ArrayList<Integer> countDistinct(int arr[], int n, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        int i=0, j=0;

        while(j<n){
            if(hm.containsKey(arr[j])){
                hm.put(arr[j],hm.get(arr[j])+1);
            }else{
                hm.put(arr[j],1);
            }

            while(j-i+1>k){
                hm.put(arr[i], hm.get(arr[i])-1);
                if(hm.get(arr[i])==0){
                    hm.remove(arr[i]);
                }
                i++;
            }

            if(j-i+1==k){
                list.add(hm.size());
            }

            j++;
        }

        return list;
    }
}
