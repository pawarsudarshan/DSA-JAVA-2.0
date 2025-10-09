package BinarySearch;

import java.util.Arrays;

public class MedianSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5},
                          {2, 6, 9},
                          {3, 6, 9}};
        int R = 3, C = 3;
        System.out.println(median(matrix,R,C));
    }
    static int median(int[][] matrix, int R, int C) {
        // binary search approach
        int start = 1, end = 2000;
        int center = 4;
        int ans = 1;

        while(start<=end){
            int mid = (start+end)/2;

            if(check(matrix,R,C,mid)<=center){
                System.out.println(mid+" "+check(matrix,R,C,mid));
                ans = mid;
                start = mid+1;
            }

            else end = mid-1;
        }
        return ans;
    }

    static int check(int[][] matrix, int R, int C, int target) {
        int count = 0;

        for(int i=0;i<R;i++){
//            int idx = lower_bound(matrix[i],target);
//            int idx = Arrays.binarySearch(matrix[i], target);
            int start = 0, end = C-1;
            int idx = C;

            while(start<=end){
                int mid = (start+end)/2;

                if(matrix[i][mid]==target){
                    idx = mid;
                    end =mid-1;
                }

                else if(matrix[i][mid] < target){
                    start = mid+1;
                }

                else{
                    idx = mid;
                    end = mid-1;
                }
            }
//            System.out.println(target+" "+idx);
            count += idx;
        }

        return count;
    }
    static int lower_bound(int array[], int key)
    {

        int index = Arrays.binarySearch(array, key);

        // If key is not present in the array
        if (index < 0) {

            // Index specify the position of the key
            // when inserted in the sorted array
            // so the element currently present at
            // this position will be the lower bound
            return Math.abs(index) - 1;
        }

        // If key is present in the array
        // we move leftwards to find its first occurrence
        else {

            // Decrement the index to find the first
            // occurrence of the key

            while (index > 0) {

                // If previous value is same
                if (array[index - 1] == key)
                    index--;

                    // Previous value is different which means
                    // current index is the first occurrence of
                    // the key
                else
                    return index;
            }

            return index;
        }
    }
}