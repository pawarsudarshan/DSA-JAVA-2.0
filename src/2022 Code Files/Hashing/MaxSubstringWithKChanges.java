package Hashing;
import java.util.*;

public class MaxSubstringWithKChanges {
    public static void main(String[] args) {
        String str = "ADBD";
        int k = 1;
        System.out.println(characterReplacement(str,k));
    }
    static public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> m = new HashMap<>();
        int i=0,j=0,mx=0,ans=0,n=s.length();
        while(j<n){
            if(m.containsKey(s.charAt(j))){
                m.put(s.charAt(j),1+m.get(s.charAt(j)));
            }else{
                m.put(s.charAt(j),1);
            }

            mx = Math.max(mx,m.get(s.charAt(j)));
            int window_size = j-i+1;
            int need_to_change = window_size-mx;

            if(need_to_change<=k) ans = Math.max(ans,window_size);
            else{
                m.put(s.charAt(i),m.get(s.charAt(i))-1);
                i++;
            }

            j++;
        }
        return ans;
    }
}
