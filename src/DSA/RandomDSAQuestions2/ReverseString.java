package RandomDSAQuestions2;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        char[] arr = str.toCharArray();
        int start = 0, end = arr.length-1;

        while(start<end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start ++;
            end --;
        }

        System.out.println(arr);
        String rev = new String(arr);
        System.out.println(rev);
    }
}
