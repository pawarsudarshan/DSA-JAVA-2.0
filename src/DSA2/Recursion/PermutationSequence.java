package DSA2.Recursion;
import java.util.*;
/*
Important to know how permutation works:
doing k-- before entering the loop is very important as it sets index to 0
show commented code for clear precise iterative solution
*/


public class PermutationSequence {
    public static void main(String[] args) {
        int n = 4, k = 7;
        System.out.println(getPermutation(n,k));
    }

    public static String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int[] factorial = new int[n+1];
        factorial[0] = 1;

        for(int i=1;i<=n;i++){
            factorial[i] = factorial[i-1]*i;
            list.add(i);
        }
        System.out.println(list);
        System.out.println(Arrays.toString(factorial));
        solve(n,k-1,sb,list, factorial);
        return sb.toString();
    }

    public static void solve(int n, int k, StringBuilder sb, List<Integer> list, int[] factorial){
        if(n==1){
            sb.append(list.get(n-1));
            return;
        }

        int index = k/factorial[n-1];
        k = k%factorial[n-1];
        sb.append(list.get(index));
        list.remove(list.get(index));
        solve(n-1,k,sb,list,factorial);
    }
}

// iterative solution
//public static String getPermutation(int n, int k) {
//    List<Integer> list = new ArrayList<>();
//    List<Integer> solution = new ArrayList<>();
//    StringBuilder sb = new StringBuilder();
//    int[] factorial = new int[n+1];
//    factorial[0] = 1;
//
//    for(int i=1;i<=n;i++){
//        factorial[i] = factorial[i-1]*i;
//        list.add(i);
//    }
//
//    k--; // set index to 0
//    for(int i=n;i>=1;i--){
//        int index = k/factorial[i-1];
//        k = k%factorial[i-1];
//        sb.append(list.get(index));
//        list.remove(index);
//    }
//    return sb.toString();
//}
//}
