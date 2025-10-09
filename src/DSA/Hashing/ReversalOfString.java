package Hashing;
import java.util.*;

public class ReversalOfString {
    public static void main(String[] args) {
        String s = "GEEKS FOR GEEKS";
        String ans = reverseString(s);
        System.out.println(ans);
    }
    static public String reverseString(String s){
        StringBuilder str = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        char[] arr = s.toCharArray();

        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]==' ') continue;
            if(set.contains(arr[i])){
                continue;
            }else {
                str.append(arr[i]);
                set.add(arr[i]);
            }
        }

        return str.toString();
    }
}
