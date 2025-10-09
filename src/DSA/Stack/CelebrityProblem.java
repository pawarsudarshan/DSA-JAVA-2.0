package Stack;
import java.util.*;

public class CelebrityProblem {
    public static void main(String[] args) {
        int M[][] = {{0, 1, 0},
                     {0, 0, 0},
                     {0, 1, 0}};
        int n = M.length;
        System.out.println("The celebrity is : "+ celebrity(M,n));
    }
    static int celebrity(int M[][], int n) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            st.push(i);
        }

        while(st.size()>1){
            int first = st.pop();
            int second = st.pop();

            if(M[first][second]==1){
                st.push(second);
            } else st.push(first);
        }

        if(check(M,n,st.peek()))
            return st.peek();

        return -1;
    }

    static boolean check(int M[][], int n, int sus){
        for(int row=0;row<n;row++){
            if(row!=sus && M[row][sus]==0) return false;
        }

        for(int col=0;col<n;col++){
            if(col!=sus && M[sus][col]==1) return false;
        }
        return true;
    }
}
