package DSA2.Recursion;
import java.util.*;

/* Below is the pure recursion problem - similar to what we did in SubSetSumPrintOutput problem
 Approach:
 exclude that element and find other solutions
 add that element in list => find solutions that contains that element
 backtrack and remove the element before exiting the method
*/
public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates,target));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> finalAnswer = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        combinationSum2Helper(candidates, target, 0, 0, current,finalAnswer, set);
        finalAnswer.addAll(set);
        return finalAnswer;
    }
    public static void combinationSum2Helper(int[] candidates ,int target, int index, int sum, List<Integer> current, List<List<Integer>> finalAnswer, Set<List<Integer>> set){
        if(sum==target){
            List<Integer> list = new ArrayList<>(current);
            Collections.sort(list);
            set.add(new ArrayList<>(list));
            return;
        }
        if(index>=candidates.length||sum>target) return;

        combinationSum2Helper(candidates,target,index+1, sum,current, finalAnswer, set);

        current.add(candidates[index]); // Adding into current list
        combinationSum2Helper(candidates,target,index+1, sum+candidates[index], current, finalAnswer, set);
        current.remove(current.size()-1); // Backtracking step - removing the added element from current list
    }
}
