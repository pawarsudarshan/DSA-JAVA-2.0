package Stack;
import java.util.*;

public class CountTheReversals {
    public static void main(String[] args) {
        String s = "}}{{";
        System.out.println(countRev(s));
    }
    static int countRev (String s) {
        int close = 0, open = 0, n = s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='{') open++;
            else{
                if(open==0) close++;
                else open--;
            }
        }
        return (int)(Math.ceil(open/2) + Math.ceil(close/2));
    }
}

/*
    Using stack it will take O(n) extra space, we can still do it in linear time
    by using two variables:

    Stack Approach:
    Stack<Character> st = new Stack<>();
        int n = s.length();

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='}' && !st.empty() && st.peek()=='{'){
                st.pop();
            }else {
                st.add(s.charAt(i));
            }
        }

        StringBuilder str = new StringBuilder();
        while(st.size()!=0){
            str.append(st.pop());
        }
        str = str.reverse();
        String str2 = str.toString();

        if(str2.length()%2!=0){
            return -1;
        }

        int open=0;
        for(int i=0;i<str2.length();i++){
            if(str2.charAt(i)=='{') open++;
        }
        if(open%2==0) return str2.length()/2;
        return str2.length()/2+1;

        Linear space:
        int close = 0, open = 0, n = s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='{') open++;
            else{
                if(open==0) close++;
                else open--;
            }
        }
        return (int)(Math.ceil(open/2) + Math.ceil(close/2));

*/








/*
TEST CASES:
 }{}{}{}}}{{{{{}{}{}}{{}{}{}}{{}}{{
 {}{{}{{{{{}}{}

        int start = 0, end = str2.length()-1;

        while(start<end){
            if(str2.charAt(start)=='}')
                count++;
            if(str2.charAt(end)=='{')
                count++;
            start++;
            end--;
        }



        int closing=0, opening = 0;

        for(int i=0;i<str2.length();i++){
            if(str2.charAt(i)=='{') opening++;
            else closing++;
        }

        if(opening==0) return closing/2;
        if(closing==0) return opening/2;

        if(opening%2==0){
            return str2.length()/2;
        }

        int count = str2.length()/2+1;

        return count;

 */