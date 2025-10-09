package RandomDSAQuestions2;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int first_prev = 1, second_prev = 0;

        for(int i=0;i<n;i++){
            int curr = first_prev + second_prev;
            System.out.println(curr);
            second_prev = first_prev;
            first_prev = curr;
        }

        System.out.println("Below lines are printed using recursive approach...");
    }
}