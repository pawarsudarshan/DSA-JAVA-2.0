package RandomDSAQuestions2;

import java.util.Arrays;
import java.util.Scanner;

public class ProgramforArrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[][] arr = new int[3][];

        for(int i=0;i<3;i++){
            arr[i] = new int[x];
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<x;j++){
                arr[i][j] = sc.nextInt();
            }
        }

//        for(int i=0;i<3;i++){
//            for(int j=0;j<2;j++){
//                System.out.print(arr[i][j]+ " ");
//            }
//            System.out.println();
//        }

        for(int[] a : arr){
            System.out.println(Arrays.toString(a));
        }

    }
}
