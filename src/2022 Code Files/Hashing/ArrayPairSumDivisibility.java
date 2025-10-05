package Hashing;
import java.util.*;

public class ArrayPairSumDivisibility {
    public static void main(String[] args) {
        int[] arr = {2, 4, 12, 36};
        int k = 2;
        System.out.println(canPair(arr,k));
    }
    public static boolean canPair(int[] arr, int k) {
        HashMap<Integer,Integer> m = new HashMap<>();
        int n = arr.length;
        if(n%2!=0) return false;

        for(int i=0;i<n;i++){
            int mod1 = arr[i]%k;
            if(m.containsKey(mod1)){
                m.put(mod1,m.get(mod1)+1);
            }else{
                m.put(mod1,1);
            }
        }
        if(m.get(0)%2!=0) return false;
        for(int i=1;i<k;i++){
            if(m.get(i)!=m.get(k-i)) return false;
        }
        return true;
    }
}


