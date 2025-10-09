package TwoPointers;

public class CountPairWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        int target = 8;
        System.out.println(countPair(arr,n,target));
    }

    static int countPair(int arr[], int n, int target){
        int start = 0, end = n-1;
        int count = 0;

        while(start<end){
            if(arr[start] + arr[end] == target){
                count++;
                start++;
                end--;
            }
            else if(arr[start] + arr[end] < target){
                start++;
            }
            else end--;
        }

        return count;
    }

}
