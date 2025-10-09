package RandomDSAQuestions3;

public class MaximumDifference {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1};
        int n = arr.length;
        System.out.println(maxDistance(arr,n));
    }
    public static int maxDistance (int arr[], int n) {
        int start = 0, end = n-1;
        int ans = Math.abs(arr[0]-arr[n-1]) + Math.abs(n-1);
        while(start<=end){
            int x = Math.abs(arr[start]-arr[end]) + Math.abs(end-start);
            ans = Math.max(ans,x);

            if(arr[start]>arr[end])
                end--;
            else start++;

            if(arr[start]<0) end--;
            if(arr[end]<0) start++;
        }
        return ans;
    }
}
