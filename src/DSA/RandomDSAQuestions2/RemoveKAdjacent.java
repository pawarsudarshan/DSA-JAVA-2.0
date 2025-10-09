package RandomDSAQuestions2;

import java.util.*;
/*
Notes:
Through this program we implemented three important things
1) Stack
2) Stack of RandomJavaCodes.Pair - created a custom pair class and implemented stack with user defined data type of pair
3) String Builder - very useful utility provided by Java ... It makes strings so simple
LeetCode has 2 questions of this type. If we put value of k = 2 then the other one will be also solved...
 */
public class RemoveKAdjacent{
    public static String removeDuplicates(String s, int k) {
        StringBuilder str = new StringBuilder();
        Stack<Pair> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(st.size()>0 && st.peek().key==s.charAt(i)){
                Integer count = st.peek().value;
                count++;
                st.pop();
                st.add(new Pair(s.charAt(i), count));

                if(st.peek().value==k)
                    st.pop();
            }

            else st.add(new Pair(s.charAt(i),1));
        }
        if(st.size()>0 && st.peek().value==k)
            st.pop();

        while(st.size()>0){
            int count = st.peek().value;
            for(int i=1;i<=count;i++){
                str.append(st.peek().key);
            }
            st.pop();
        }

        str.reverse();
        String ans = str.toString();
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k =sc.nextInt();

        System.out.println(removeDuplicates(s,k));
    }
}
class Pair {
    Character key;
    Integer value;
    public Pair(Character key, Integer value)
    {
        this.key = key;
        this.value = value;
    }
}