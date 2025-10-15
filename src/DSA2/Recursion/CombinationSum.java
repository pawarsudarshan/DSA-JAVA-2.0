package DSA2.Recursion;
import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
//        int[] candidates = {2,3,6,7};
//        int target = 7;
//        System.out.println(combinationSum(candidates, target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(candidates, target, n-1, 0,  list, finalList);
        return finalList;
    }

    public static void solve(int[] arr, int target, int index, int sum, List<Integer> solution, List<List<Integer>> finalList){
        System.out.println("Index = "+index+" Sum = "+sum);
        if(sum==target){
            finalList.add(solution);
            return;
        }
        if(sum>target) return;
        if(index<0) return;

        solve(arr,target,index-1, sum, solution, finalList);
        solution.add(arr[index]);
        solve(arr,target,index, sum+arr[index], solution, finalList);
        solution.remove(arr[index]);
    }
}
