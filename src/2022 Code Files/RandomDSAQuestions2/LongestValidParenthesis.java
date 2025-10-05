package RandomDSAQuestions2;

import java.util.Scanner;

public class LongestValidParenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int ans = 0;

        int open = 0, close = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                open++;
            else close++;

            if(open==close) {
                int len = open+close;
                ans = Math.max(ans, len);
            }

            if(close>open) open = close = 0;
        }

        open = close = 0;

        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='(')
                open++;
            else close++;

            if(open==close) {
                int len = open+close;
                ans = Math.max(ans, len);
            }

            if(close<open) open = close = 0;
        }
        System.out.print("The length of longest valid parenthesis is: ");
        System.out.println(ans);

    }
}
