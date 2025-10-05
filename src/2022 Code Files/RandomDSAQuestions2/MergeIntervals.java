package RandomDSAQuestions2;

import java.util.Scanner;

public class MergeIntervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] intervals = new int[n][2];
        for(int i=0;i<n;i++)
            for(int j=0;j<2;j++)
                intervals[i][j] = sc.nextInt();


    }
}
