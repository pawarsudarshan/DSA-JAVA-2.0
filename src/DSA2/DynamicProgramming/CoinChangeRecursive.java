package DSA2.DynamicProgramming;
import java.util.*;

public class CoinChangeRecursive {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        CoinChangeRecursive cc = new CoinChangeRecursive();
        System.out.println(cc.coinChange(coins,amount));
    }
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        List<Integer> list = new ArrayList<>();
        list.add(Integer.MAX_VALUE);
        solve(coins,amount,0,0,0,list);
        if(list.get(0)==Integer.MAX_VALUE) return -1;
        return list.get(0);
    }

    public void solve(int[] coins, int target, int index, int sum, int count,List<Integer> list){
        if(sum>target) return;
        if(sum==target){
            if(count<list.get(0)) list.set(0,count);
            return;
        }
        if(index>=coins.length) return;

        // exclude
        solve(coins,target,index+1,sum,count,list);

        // include
        solve(coins,target,index,sum+coins[index],count+1,list);
    }
}
