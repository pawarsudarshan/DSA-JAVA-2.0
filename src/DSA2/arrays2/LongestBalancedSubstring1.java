package DSA2.arrays2;

import java.util.HashMap;

public class LongestBalancedSubstring1 {
    public static void main(String[] args) {
        String s = "aba";
        System.out.println(longestBalanced(s));
    }
    // Working Brute Force Approach time complexity O(N^3)
//    public static int longestBalanced(String s) {
//        int n = s.length(), maxLen = 0;
//        for(int i=0;i<n;i++){
//            for(int j=i+1;j<n;j++){
//                // i to j = [i,j]
//                HashMap<Character, Integer> map = new HashMap<>();
//                for(int k=i;k<=j;k++){
//                    if(map.containsKey(s.charAt(k))){
//                        // map.replace(s.charAt(i), map.get(s.charAt(i))+1);
//                        int freq = map.get(s.charAt(k)) + 1;
//                        map.put(s.charAt(k), freq);
//                    }else{
//                        map.put(s.charAt(k),1);
//                    }
//                }
//                int count = 0, firstValue = 0;
//                boolean flag = true;
//                for(Integer value :map.values()){
//                    if(count==0) firstValue = value;
//                    else {
//                        if(value!=firstValue){
//                            flag = false;
//                            break;
//                        }
//                    }
//                    System.out.println("firstValue:"+firstValue);
//                    System.out.println("i="+i+" j="+j+" value="+value);
//                    System.out.println(value);
//                    count++;
//                }
//                if(flag){
//                    System.out.println("i="+i+" j="+j);
//                    if(j-i+1 > maxLen) {
//                        maxLen = j-i+1;
//                        System.out.println("maxLen="+maxLen);
//                    }
//                }
//
//            }
//        }
//        return maxLen;
//    }

    public static int longestBalanced(String s) {
        return 0;
    }
}
