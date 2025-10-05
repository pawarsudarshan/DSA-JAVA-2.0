package DP;

public class LongestAlternatingSubsequence {
    public static void main(String[] args) {
        int[] arr = {1,17,5,10,13,15,10,5,16,8};
        System.out.println(AlternatingMaxLength(arr));
    }
    static int AlternatingMaxLength(int[] arr) {
        int n = arr.length;
        if(n<=1) return 1;

        int inc = 1, dec = 1;

        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]) inc = dec+1;
            if(arr[i]<arr[i-1]) dec = inc+1;
        }

        return Math.max(inc,dec);
    }
}