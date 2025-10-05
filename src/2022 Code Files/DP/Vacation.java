package DP;
import java.util.*;

public class Vacation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][3];

        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println(maxHappiness(mat,n));
    }
    static int maxHappiness(int[][] mat, int n){
        int happiness = Math.max(mat[0][0],Math.max(mat[0][1],mat[0][2]));
        for(int i=1;i<n;i++){
                int a = mat[i-1][0], b = mat[i-1][1], c = mat[i-1][2];
//                if(j-1>=0) a = mat[i-1][j-1];
//                if(j+1<n) c = mat[i-1][j+1];
//                mat[i][j] = Math.max(a,Math.max(b,c));
                mat[i][0] += Math.max(b,c);
                mat[i][1] += Math.max(a,c);
                mat[i][2] += Math.max(a,b);
//                happiness = Math.max(happiness,mat[i][j]);
            happiness = Math.max(mat[i][0],Math.max(mat[i][1],mat[i][2]));
        }
        /* Printing
            for(int i=0;i<n;i++){
                for(int j=0;j<3;j++){
                    System.out.print(mat[i][j]+" ");
                }
                System.out.println();
            }
         */

        return happiness;
    }
}