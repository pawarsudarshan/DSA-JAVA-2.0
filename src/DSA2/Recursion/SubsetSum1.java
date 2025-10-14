package DSA2.Recursion;
/*
Classic recursion problem
0/1 knapsack - either include or exclude the element
*/
public class SubsetSum1 {
    public static void main(String[] args) {
        int[] arr = {1,2,7,3};
        int target = 6;
        System.out.println(isSubsetSum(arr,target));
    }
    public static boolean isSubsetSum(int[] arr, int target){
        return solve(arr,target, arr.length-1,0);
    }

    public static boolean solve(int[] arr, int target, int index, int sum){
        if(sum==target) return true;
        if(sum>target) return false;
        if(index<0) return false;
        return solve(arr,target,index-1, sum) || solve(arr,target,index-1,sum+arr[index]);
    }

}
