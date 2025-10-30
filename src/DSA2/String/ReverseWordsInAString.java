package DSA2.String;
import java.util.*;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = " this is my    word     a lot    of    space     ";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        Stack<String> st = new Stack<>();

        // Extract words and push to stack
        for(int i=0;i<s.length();i++){
            int j = i;
            StringBuilder word = new StringBuilder();

            while(j<s.length() && s.charAt(j)!=' '){
                word.append(s.charAt(j));
                j++;
            }

            if(!word.isEmpty()){
                st.add(word.toString());
                i = j-1;
            }
        }

        // Build reversed sentence
        StringBuilder result = new StringBuilder();
        while(!st.isEmpty()){
            result.append(st.pop());
            result.append(' ');
        }

        if(!result.isEmpty())
            result.deleteCharAt(result.length()-1);

        return result.toString();
    }
}
