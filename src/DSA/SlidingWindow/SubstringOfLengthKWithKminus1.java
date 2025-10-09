package SlidingWindow;
import java.util.*;

public class SubstringOfLengthKWithKminus1 {
    public static void main(String[] args) {
        String s = "aabab";
        int k = 3;

        System.out.println(countOfSubstrings(s,k));
    }
    static int countOfSubstrings(String s, int k) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int count = 0, n = s.length();

        int i=0,j=0;
        while(j<n){
            if(hm.containsKey(s.charAt(j))){
                hm.put(s.charAt(j), hm.get(s.charAt(j))+1);
            }else{
                hm.put(s.charAt(j), 1);
            }

            while(j-i+1>k){
                hm.put(s.charAt(i),hm.get(s.charAt(i))-1);
                if(hm.get(s.charAt(i))==0){
                    hm.remove(s.charAt(i));
                }
                i++;
            }

            if(j-i+1==k && hm.size()==k-1){
                count++;
            }

            j++;
        }

        return count;
    }
}
