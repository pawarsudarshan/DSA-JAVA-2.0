package Hashing;
import java.util.*;

public class NonRepeatedElements {
    public static void main(String[] args) {
        int[] arr = {10,20,40,30,10};
        int n = arr.length;
        ArrayList<Integer> list = printNonRepeated(arr,n);
        System.out.println(list);
    }
    static ArrayList<Integer> printNonRepeated(int arr[], int n){
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            if(hm.containsKey(arr[i])){
                int val = hm.get(arr[i]);
                hm.put(arr[i], val+1);
            }else{
                hm.put(arr[i],1);
            }
        }

//        for(Map.Entry<Integer,Integer> pair: hm.entrySet()){
//            if(pair.getValue()==1){
//                list.add(pair.getKey());
//            }
//        }

        for(int i=0;i<n;i++){
            if(hm.get(arr[i])==1)
                list.add(arr[i]);
        }

        return list;
    }
}
