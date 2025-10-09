public class SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {};
        int target = 28;
        System.out.println(searchMatrix(matrix,target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0, end = (m*n)-1;

        while(start<=end){
            int mid = (start + end)/2;

            int row = mid/n;
            int col = mid%n;

            if(matrix[row][col]==target){
                return true;
            }

            else if(matrix[row][col]>target){
                end = mid-1;
            }

            else start = mid+1;
        }
        return false;
    }
}
