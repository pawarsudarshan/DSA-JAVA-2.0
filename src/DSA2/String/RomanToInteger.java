package DSA2.String;
import java.util.*;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "LV";
        System.out.println(romanToInt(s));
    }
    public static int romanToInt(String s) {
        // initialize a map and fill in the values of roman symbols
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int ans = 0;

        for(int i=0;i<s.length();i++){
            int curr = map.get(s.charAt(i));
            if(i+1<s.length()){
                int next = map.get(s.charAt(i+1));
                if(curr<next){
                    ans += next-curr;
                    i++;
                    continue;
                }
            }
            ans += curr;
        }

        return ans;
    }
}
