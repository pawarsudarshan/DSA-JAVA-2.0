package RandomDSAQuestions2;

public class MaximumIndex {
    public static void main(String[] args) {
        int[] arr =  {34, 8, 10, 3, 2, 80, 30, 33, 1};
        int n = arr.length;
        System.out.println(maxIndexDiff(arr,n));
    }
    static int maxIndexDiff(int arr[], int n) {
        // code here
        int ans = 0;
        int start = 0, end = n-1;
        while(start<end){
            if(arr[start]<=arr[end]){
                ans = Math.max(ans,end-start);
                start++;
            }
            else if(arr[start]>arr[end]){
                end--;
            }
        }
        return ans;
    }
}
