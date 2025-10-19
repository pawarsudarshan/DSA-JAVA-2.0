package DSA2.Arrays2;

import java.util.HashMap;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String s = "ababc";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        // Solution 1 - using HashMap
        int maxLength = 0, n = s.length(), i =0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int j=0;j<n;j++){
            if(map.containsKey(s.charAt(j))){
                while(s.charAt(i)!=s.charAt(j)){
                    map.remove(s.charAt(i));
                    i++;
                }
                i++;
                map.put(s.charAt(j),1);
            }else{
                map.put(s.charAt(j),1);
            }
//            System.out.println("i= "+i+" j="+j);
            if(j-i+1 > maxLength) maxLength = j-i+1;
        }
        return maxLength;

        // Solution 2 - using sets
//        int maxLength = 0, n = s.length(), i =0;
//        Set<Character> set = new HashSet<>();
//        for(int j=0;j<n;j++){
//            if(set.contains(s.charAt(j))){
//                while(s.charAt(i)!=s.charAt(j)){
//                    set.remove(s.charAt(i));
//                    i++;
//                }
//                i++;
//            }else{
//                set.add(s.charAt(j));
//            }
//            if(j-i+1 > maxLength) maxLength = j-i+1;
//        }
//        return maxLength;
    }
}
