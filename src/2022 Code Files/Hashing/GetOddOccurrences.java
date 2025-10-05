package Hashing;

import java.net.Inet4Address;
import java.util.*;

public class GetOddOccurrences {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 3, 1, 3};
        int n = arr.length;
        System.out.println(getOddOccurrence(arr,n));
    }
    static int getOddOccurrence(int[] arr, int n) {
//        xor method O(N) time complexity
//        int xorValue = arr[0];
//        for(int i=1;i<n;i++){
//            xorValue = xorValue ^ arr[i];
//        }
//        return xorValue;

//        hashmap method

        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            if(hm.containsKey(arr[i])){
                int val = hm.get(arr[i]);
                hm.put(arr[i], val+1);
            }else{
                hm.put(arr[i],1);
            }
        }

        for(int i: hm.keySet()){
            if(hm.get(i)%2!=0)
                return i;
        }

        return -1;

    }
}
