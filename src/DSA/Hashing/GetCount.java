package Hashing;
import java.lang.reflect.Array;
import java.util.*;

public class GetCount {
    public static void main(String[] args) {
        String s = "something";
        System.out.println(getCount(s,s.length()));
        //unique numbers code
        int L = 50, R = 100;
        System.out.println(uniqueNumbers(L,R));
    }
    static int getCount (String s, int n){
        char[] arr = s.toCharArray();
        HashMap<Character,Integer> hm = new HashMap<>();
        hm.put(arr[0],1);

        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1]){
                if(hm.containsKey(arr[i])){
                    int val = hm.get(arr[i]);
                    hm.put(arr[i],val+1);
                }else{
                    hm.put(arr[i],1);
                }
            }
        }
        int count=0;

        for(Map.Entry<Character,Integer> pair: hm.entrySet()){
            if(pair.getValue()==n){
                count++;
            }
        }
        return count;
    }

    static ArrayList<Integer> uniqueNumbers(int L,int R){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=L;i<=R;i++){
            if(!isDuplicate(i)){
                list.add(i);
            }
        }
        return list;
    }

    static boolean isDuplicate(int number){
        HashSet<Integer> s = new HashSet<>();
        while(number>0){
            int rem = number%10;
            if(s.contains(rem)) return true;
            s.add(rem);
            number = number /10;
        }
        return false;
    }

}
