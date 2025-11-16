package DSA2.String;
import java.util.*;
// LeetCode Weekly 16/11/2025
public class MinimumStringLenAfterBalancedRemoval {
    public static void main(String[] args) {
        String s = "aaaabbb";
        System.out.println(minLengthAfterRemovals(s));
    }
    public static int minLengthAfterRemovals(String s) {
        int n = s.length(), aCount = 0, bCount = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a') aCount++;
            else bCount++;
        }
        return Math.abs(aCount-bCount);
    }
}
