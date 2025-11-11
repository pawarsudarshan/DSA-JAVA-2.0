package DSA2.DynamicProgramming;
import java.util.*;
/*
Dynamic Programming => include, exclude logic
*/
public class OnesAndZeroes {
    public static void main(String[] args) {

    }
    public int findMaxForm(String[] strs, int m, int n) {
        int size = strs.length;
        int[] zero = new int[size];
        int[] one = new int[size];

        for(int i=0;i<size;i++){
            String s = strs[i];
            int zeros = 0, ones = 0;
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)==0){
                    zeros++;
                } else ones++;
            }
            zero[i] = zeros;
            one[i] = ones;
        }

        return solve(zero,one,0,size,m,n);
    }

    public int solve(int[] zero, int[] one, int index, int size, int m, int n){
        // Base case
        if(index==size) return 0;

        // exclude
        int way1 = 0, way2 = 0;
        way1 = solve(zero,one,index+1,size,m,n);

        // include
        if(m<=zero[index] && n<=one[index]){
            way2 = solve(zero,one,index+1,size,m-zero[index],n-one[index]);
        }

        return Math.max(way1,way2);
    }
}
