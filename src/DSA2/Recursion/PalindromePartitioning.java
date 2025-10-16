package DSA2.Recursion;
import java.util.*;
/*
while doing a recursive call I made a mistake that i passed index+1 to the recursive call instead of i+1
doing i+1 takes into account the total length of palindrome
 */

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> finalAnswer = new ArrayList<>();
        List<String> list = new ArrayList<>();
        int n = s.length();
        findAllPalindromePartitions(s,n,0,list,finalAnswer);
        return finalAnswer;
    }

    public static void findAllPalindromePartitions(String s, int n, int index, List<String> list, List<List<String>> finalAnswer){
        if(index==n){
            finalAnswer.add(new ArrayList<>(list));
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=index;i<n;i++){
            sb.append(s.charAt(i));
            if(isPalindrome(s, index, i)){
                list.add(sb.toString());
                findAllPalindromePartitions(s,n,i+1,list,finalAnswer);
                list.remove(list.size()-1); // Backtracking
            }
        }
    }

    public static boolean isPalindrome(String s, int left, int right){
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
