package DSA2.Recursion;
import java.util.*;

public class PowerSet {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(subsetWithDup(arr));
    }
    public static List<List<Integer>> subsetWithDup(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> curr = new ArrayList<>();

        solve(nums,0, ans,set,curr);
        ans.addAll(set);
//        System.out.println(ans.size());
        return ans;
    }
    public static void solve(int[] nums,int index, List<List<Integer>> ans, Set<List<Integer>> set, List<Integer> curr){
        if(index>=nums.length) {
//            Collections.sort(curr);
            List<Integer> list = new ArrayList<>(curr);
            Collections.sort(list);
            set.add(new ArrayList<>(list));
            return;
        }

        solve(nums,index+1,ans,set,curr);

        curr.add(nums[index]);
        solve(nums,index+1,ans,set,curr);
        curr.remove(curr.size()-1); // Backtrack
    }
}
