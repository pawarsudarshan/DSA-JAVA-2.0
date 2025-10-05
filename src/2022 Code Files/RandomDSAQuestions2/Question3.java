package RandomDSAQuestions2;

import java.util.Arrays;
import java.util.Scanner;

public class Question3 {
    static String sortString(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        String str1 = sortString(s1);
        String str2 = sortString(s2);

        if(str1.equals(str2))
            System.out.println("The strings are anagram");
        else
            System.out.println("The strings are not anagram");
    }
}