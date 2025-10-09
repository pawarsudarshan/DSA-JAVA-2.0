package RandomDSAQuestions3;
import java.util.Scanner;

public class Narcissistic{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int size = 0;
        int temp = number;

        while(temp>0){
            size++;
            temp = temp/10;
        }
        
        int temp2 = number;
        int sum = 0;

        while(temp2>0){
            int rem = temp2%10;
            sum += Math.pow(rem,size);
            temp2 = temp2/10;
        }

        if(sum==number){
            System.out.println("It is a Narcissistic Number");
        }else{
            System.out.println("It is not a Narcissistic number");
        }

    }
}