package DSA2.Stack;
import java.util.*;
/* Core Logic:
if A knows B => A is certainly not a celebrity, B might be one

Algorithm: TC=O(n) SC=O(n)
1. Push all candidates into Stack
2. Pop top two candidates, let's say A & B
3. if A know B => put back B, else put back A
4. Repeat 2 & 3, till there is only one element present in stack
5. Check if the last person remaining is a celebrity

Check two pointer approach below TC=O(n) SC=O(1)

Key Takeaway: Don't always think of traversal of array/matrix/linkedList,
think what the problem actually want
*/
public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,0},
                {0,1,0},
                {0,1,1}
        };
        System.out.println(findCelebrity(matrix));
    }
    /* Solution using  stack
    public static int findCelebrity(int[][] mat){
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<mat.length;i++){
            st.add(i);
        }

        while(st.size()>1){
            int personA = st.pop();
            int personB = st.pop();

            if(mat[personA][personB]==1){
                st.add(personB);
            }else{
                st.add(personA);
            }
        }

        // check for valid person
        int person = st.pop();
        boolean isValid = true;
        for(int i=0;i<mat.length;i++){
            if(mat[i][person]==0) {
                isValid = false;
                break;
            }
            if(person!=i && mat[person][i]==1){
                isValid = false;
                break;
            }
        }

        if(isValid) return person;
        return -1;
    }
*/
    /* Using Two Pointer Approach */
    public static int findCelebrity(int[][] mat){
        int start = 0, end = mat.length-1;
        while(start<end){
            if(mat[start][end]==1){
                start++;
            }else end--;
        }

        // check for valid person
        for(int i=0;i<mat.length;i++){
            if(mat[i][start]==0) return -1;
            if(start!=i && mat[start][i]==1) return -1;
        }

        return start;
    }
}
