package RandomDSAQuestions2;

import java.util.Scanner;
// program for string palindrome and number palindrome

public class Questions2 {
    static boolean isPalindrome(String s){
        int start = 0, end = s.length()-1;
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        int temp = n;
//        int sum = 0;
//
//        while(temp>0){
//            sum = sum * 10;
//            sum += temp%10;
//            temp /= 10;
//        }
//
//        if(sum == n)
//            System.out.println("The number is palindrome");
//        else
//            System.out.println("The number is not a palindrome");

        String s = sc.next();

        if(isPalindrome(s))
            System.out.println("The string is palindrome");
        else
            System.out.println("The string is not a palindrome");
    }
}
