package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class KthDistinctElement {
    public static void main(String[] args) {
        int[] arr = {14};
//        int k = 2;
//        System.out.println(kthDistinct(arr,k));
//        System.out.println(divideLadoo(arr,arr.length));

        ArrayList<Integer> list = maxDistinctNum(arr,arr.length);
        System.out.println(list);
    }
    static int kthDistinct(int[] arr,int k){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i])){
                int val = hm.get(arr[i]);
                hm.put(arr[i], val+1);
            }else{
                hm.put(arr[i],1);
            }
        }

        for(int i=0;i<arr.length;i++){
            if(hm.get(arr[i])==1){
                if(k==1){
                    return arr[i];
                }
                k--;
            }
        }
        return -1;
    }

    static int divideLadoo(int[] arr, int n) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            if(hm.containsKey(arr[i])){
                int val = hm.get(arr[i]);
                hm.put(arr[i],val+1);
            }else{
                hm.put(arr[i],1);
            }
        }
        int count = 0;
        for(Map.Entry<Integer,Integer> pair:hm.entrySet()){
            if(pair.getValue()>1){
                count += pair.getValue()-1;
            }
        }
        return n-count;
    }

    static ArrayList<Integer> maxDistinctNum(int arr[], int n) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<n;i++){
            if(arr[i]>0) {
                if (hm.containsKey(arr[i])) {
                    int val = hm.get(arr[i]);
                    hm.put(arr[i], val + 1);
                } else {
                    hm.put(arr[i], 1);
                }
            }
            else{
                arr[i] = (-1)*arr[i];
                if(hm.containsKey(arr[i])) {
                    int val = hm.get(arr[i]);
                    if (val == 1) {
                        hm.remove(arr[i]);
                    } else {
                        hm.put(arr[i], val - 1);
                    }
                }
            }

            list.add(hm.size());
        }

        return list;
    }

}
