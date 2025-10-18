package DSA2.Recursion;
import java.util.*;
/*
Two Approaches:
1. for (k=1 to n!)
    find kth permutation
    add to answerList
=> see commented code for solution

2. pure recursive
made a small mistake, but took a lot of time to resolve it
that mistake was adding back the removed element // backtracking step
what i did was added element to the end of the list by using nums.add(temp)
instead, I should have done nums.add(i,temp) adding the element back from where it was removed.
below is the pure recursive solution
 */
public class Permutations {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(permute(arr));
    }

    public static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> allPermutations = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        for(int num:arr)nums.add(num);
        List<Integer> sol = new ArrayList<>();
        findAllPermutations(nums,arr.length-1,sol,allPermutations);

        return allPermutations;
    }

    public static int factorial(int n){
        int product = 1;
        for(int i=1;i<=n;i++){
            product = product * i;
        }
        return product;
    }

    public static List<Integer> kthPermutation(int[] arr, int k){
        List<Integer> list = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        for(int num:arr) list.add(num);
        int[] factorial = new int[arr.length+1];
        factorial[0] = 1;
        for(int i=1;i<=arr.length;i++){
            factorial[i] = factorial[i-1]*i;
        }

        k--;
        for(int i=arr.length;i>0;i--){
            int index = k/factorial[i-1];
            sol.add(list.get(index));
            list.remove(index);
            k = k%factorial[i-1];
        }
        return sol;
    }

    public static void findAllPermutations(List<Integer> nums, int index, List<Integer> sol, List<List<Integer>> allPermutations){
        if(index<0){
            allPermutations.add(new ArrayList<>(sol));
            return;
        }
        for(int i=index;i>=0;i--){
            int temp = nums.get(i);
            sol.add(temp);
            nums.remove(i);
            findAllPermutations(nums,index-1,sol,allPermutations);
            nums.add(i,temp);
            sol.remove(sol.size()-1);
        }
    }
}

/*
Pure Recursive Solution
class Solution {
    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> allPermutations = new ArrayList<>();

        int factorial = factorial(arr.length);
        for(int i=1;i<=factorial;i++){
            List<Integer> permutation = kthPermutation(arr, i);
            allPermutations.add(permutation);
        }
        return allPermutations;
    }

    public int factorial(int n){
        int product = 1;
        for(int i=1;i<=n;i++){
            product = product * i;
        }
        return product;
    }

    public List<Integer> kthPermutation(int[] arr, int k){
        List<Integer> list = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        for(int num:arr) list.add(num);
        int[] factorial = new int[arr.length+1];
        factorial[0] = 1;
        for(int i=1;i<=arr.length;i++){
            factorial[i] = factorial[i-1]*i;
        }

        k--;
        for(int i=arr.length;i>0;i--){
            int index = k/factorial[i-1];
            sol.add(list.get(index));
            list.remove(index);
            k = k%factorial[i-1];
        }
        return sol;
    }
}
 */