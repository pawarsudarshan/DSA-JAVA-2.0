package DSA2.String;
/*
LeetCode: 242
Given two strings s and t, return true if t is an of s, and false otherwise.
 */
public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "gamrana";
        System.out.println(isAnagram(s,t));
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;

        int[] arr = new int[26];

        for(int i=0;i<s.length();i++){
            int ch = s.charAt(i)-'a';
            arr[ch]++;
        }

        for(int i=0;i<t.length();i++){
            int ch = t.charAt(i)-'a';
            arr[ch]--;
        }

        for(int i=0;i<26;i++){
            if(arr[i]!=0) return false;
        }
        return true;
    }
}
