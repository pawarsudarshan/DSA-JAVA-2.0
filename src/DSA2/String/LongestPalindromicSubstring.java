package DSA2.String;
import java.util.*;
/*
Learnings:
1. Recursive palindrome function + memoization
2. Optimal solution for this problem - consider a char as center of a palindrome and expand outwards
-------IMP Note-----------
in recursive palindrome fn base case, i had previously written
if(i>j) return false;
instead it should have been true.
*/
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "badd";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        int n = s.length(), maxLen = 0, leftIndex = 0, rightIndex = 0;
        Boolean[][] dp = new Boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s,i,j,dp)){
                    if(j-i+1>maxLen){
                        maxLen = j-i+1;
                        leftIndex = i;
                        rightIndex = j;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder(); // to store the LPS

        for(int i=leftIndex;i<=rightIndex;i++){
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public static boolean isPalindrome(String s, int i, int j, Boolean[][] dp){
        if(i>=j) return dp[i][j] = true;

        if(dp[i][j]!=null) return dp[i][j];

        if(s.charAt(i)==s.charAt(j)) {
            return dp[i][j] = isPalindrome(s,i+1,j-1,dp);
        }

        return dp[i][j] = false;
    }
}

/* Optimal Solution:
class Solution {
    // These variables track the start and end indices of the longest palindrome found
    int longestStart = 0;
    int longestEnd = 0;

    public String longestPalindrome(String s) {
        // Edge case: if the string is empty or has only one character, it's already a palindrome
        if (s.length() <= 1) {
            return s;
        }

        // Convert the string to a character array for faster access
        char[] characters = s.toCharArray();

        // Start recursive exploration from index 0
        expandAroundCenters(characters, 0);

        // Return the longest palindromic substring found
        return s.substring(longestStart, longestEnd + 1);
    }

    // Recursive function to explore each character as a potential palindrome center
    private void expandAroundCenters(char[] s, int currentIndex) {
        // Base case: stop recursion when we've reached the end of the array
        if (currentIndex >= s.length - 1) {
            return;
        }

        // Initialize left and right pointers to the current index
        int left = currentIndex;
        int right = currentIndex;

        // Step 1: Handle consecutive duplicate characters (e.g., "aa")
        while (right < s.length - 1 && s[right] == s[right + 1]) {
            right++;
        }

        // Update currentIndex to skip over duplicates in the next recursive call
        currentIndex = right;

        // Step 2: Expand outward as long as the characters on both sides match
        while (left > 0 && right < s.length - 1 && s[left - 1] == s[right + 1]) {
            left--;
            right++;
        }

        // Step 3: Update the longest palindrome boundaries if a longer one is found
        if (longestEnd - longestStart < right - left) {
            longestStart = left;
            longestEnd = right;
        }

        // Step 4: Recurse to the next character (after the group of duplicates)
        expandAroundCenters(s, currentIndex + 1);
    }
}
 */
