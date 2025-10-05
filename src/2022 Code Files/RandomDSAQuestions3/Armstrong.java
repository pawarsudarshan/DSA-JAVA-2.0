package RandomDSAQuestions3;

import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        
        int size = 0;
        int temp = number;
        int sumOfCubes = 0;

        while(temp>0){
            int rem = temp%10;
            sumOfCubes += rem*rem*rem;
            size++;
            temp = temp/10;
        }

        if(size!=3){
            System.out.println("Enter a 3 digit number");
        }

        else if(sumOfCubes==number){
            System.out.println("Armstrong Number");
        }else{
            System.out.println("It is not an Armstrong Number");
        }
    }
}