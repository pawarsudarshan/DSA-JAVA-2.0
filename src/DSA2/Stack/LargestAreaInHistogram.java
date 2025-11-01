package DSA2.Stack;
import java.util.*;
/*
Initial Intuition formula: maximize (rs[i]-ls[i]-1)*height[i]
 */

class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

public class LargestAreaInHistogram {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
    // O(n) TC & O(n) SC => Optimized using stack
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];
        Stack<Pair> st = new Stack<>();

        // calculate left smaller
        for(int i=0;i<n;i++){
            int num = heights[i];
            while(!st.isEmpty() && st.peek().first>=num){
                st.pop();
            }
            if(st.isEmpty()) leftSmaller[i] = -1;
            else leftSmaller[i] = st.peek().second;

            st.add(new Pair(num,i));
        }

        st.clear();
        // calculate right smaller
        for(int i=n-1;i>=0;i--){
            int num = heights[i];
            while(!st.isEmpty() && st.peek().first>=num){
                st.pop();
            }
            if(st.isEmpty()) rightSmaller[i] = n;
            else rightSmaller[i] = st.peek().second;

            st.add(new Pair(num,i));
        }

        int maxArea = 0;
        for(int i=0;i<n;i++){
            // formula to calculate max area at the ith bar height
            int area = (rightSmaller[i]-leftSmaller[i]-1)*heights[i];
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }

/* Initial working solution => TC = O(n^2) SC = O(n) but gives TLE => can be optimized using stack
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];

        // calculate right smaller
        rightSmaller[n-1] = n;
        for(int i=n-2;i>=0;i--){
            for(int j=i;j<n;j++){
                if(heights[j]<heights[i]){
                    rightSmaller[i] = j;
                    break;
                }
                rightSmaller[i] = n;
            }
        }

        // calculate left smaller
        leftSmaller[0] = -1;
        for(int i=1;i<n;i++){
            for(int j=i;j>=0;j--){
                if(heights[j]<heights[i]){
                    leftSmaller[i] = j;
                    break;
                }
                leftSmaller[i] = -1;
            }
        }

        int maxArea = 0;
        for(int i=0;i<n;i++){
            // formula to calculate max area at the ith bar height
            int area = (rightSmaller[i]-leftSmaller[i]-1)*heights[i];
            maxArea = Math.max(maxArea,area);
        }

        return maxArea;
    }
*/
}
