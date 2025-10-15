package DSA2.Recursion;
import java.util.*;

public class SubSetSumPrintOutput {
    public static void main(String[] args) {
        int[] arr = {1, 2, 7, 3, 6, 5};
        int target = 6;
        List<List<Integer>> finalList = new ArrayList<>();
        subsetSum(arr, target, finalList);
        System.out.println(finalList);
    }

    public static void subsetSum(int[] arr, int target, List<List<Integer>> finalList) {
        List<Integer> current = new ArrayList<>();
        solve(arr, target, 0, 0, current, finalList);
    }

    public static void solve(int[] arr, int target, int index, int sum, List<Integer> current, List<List<Integer>> finalList) {
        if (sum == target) {
            finalList.add(new ArrayList<>(current)); // deep copy
            return;
        }
        if (index >= arr.length || sum > target) return;

        // Include current element
        current.add(arr[index]);
        solve(arr, target, index + 1, sum + arr[index], current, finalList);
        current.remove(current.size() - 1); // backtrack

        // Exclude current element
        solve(arr, target, index + 1, sum, current, finalList);
    }
}

// below is my logic mainly flawed due to poor understanding of lists in java - deep copy of lists to be precise
// couldn't able to add values to lists properly
//package DSA2.Recursion;
//import java.util.*;
//
//
//public class SubSetSumPrintOutput {
//    public static void main(String[] args) {
//        int[] arr = {1,2,7,3,6,5};
//        int target = 6;
//        List<List<Integer>> finalList = new ArrayList<>();
//        subsetSum(arr,target,finalList);
//        System.out.println(finalList);
//    }
//    public static List<Integer> subsetSum(int[] arr, int target, List<List<Integer>> finalList){
//        int n = arr.length;
//        List<Integer> list = new ArrayList<>();
//        solve(arr,target,n-1,0, list, finalList);
//        System.out.println(list);
//        return list;
//    }
//
//    public static boolean solve(int[] arr, int target, int index, int sum, List<Integer> list, List<List<Integer>> finalList){
//        if(sum==target){
//            finalList.add(list);
//            return true;
//        }
//        if(sum>target) return false;
//        if(index<0) return false;
//
//        boolean exclude = solve(arr,target,index-1, sum, list, finalList);
//        boolean include = solve(arr,target,index-1,sum+arr[index], list, finalList);
//
//        if(include){
//            System.out.println("Added in list: "+index+" "+arr[index]);
//            list.add(arr[index]);
//        }
//
//        return exclude || include;
//    }
//}
