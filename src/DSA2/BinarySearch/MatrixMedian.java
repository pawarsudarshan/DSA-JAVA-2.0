package DSA2.BinarySearch;

public class MatrixMedian {
    public static void main(String[] args) {
        int[][] matrix = { {1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        System.out.println(matrixMedian(matrix));
    }
    public static int matrixMedian(int[][] matrix){
        int m = matrix.length, n = matrix[0].length, ans = 0;
        int start = 0, end = 1_000_000_000, halfValue = (m*n)/2;
//        System.out.println(halfValue);

        while(start<=end){
            int mid = start + (end-start)/2;

            if(lessCount(matrix,mid)<=halfValue){
//                System.out.println("LessCountsa "+lessCount(matrix,mid)+" of mid = "+mid);
                ans = mid;
                start = mid+1;
            }

            else {
//                System.out.println("LessCount "+lessCount(matrix,mid)+" of mid = "+mid);
                end = mid-1;
            }
        }

        return ans;
    }

    public static int lessCount(int[][] matrix, int target){
        int m =  matrix.length, n = matrix[0].length, count = 0;
        for(int i=0;i<m;i++){
            int start = 0, end = n-1, localCount = 0;

            if(matrix[i][end]<target) {
                count += n;
                continue;
            }

            while(start<=end){
                int mid = start + (end-start)/2;
                if(matrix[i][mid]<target){
                    localCount = mid+1;
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }

            count += localCount;
        }
        return count;
    }
}
