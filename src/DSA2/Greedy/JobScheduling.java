package DSA2.Greedy;
import java.util.Arrays;
/*
Greedy Approach:
1. Pick the most profitable jobs first.
2. For each job, assign it to the latest available time slot before its deadline.
3. Track used slots with a boolean array.
 */
public class JobScheduling {
    public static void main(String[] args) {
        int[] deadline = {3,1,2,2};
        int[] profit = {50,10,20,30};
        System.out.println(maxProfit(deadline,profit));
    }
    /* Greedy Approach */
    public static int maxProfit(int[] deadline, int[] profit){
        int n = deadline.length;
        Job[] arr = new Job[n];

        for(int i=0;i<deadline.length;i++){
            arr[i] = new Job(profit[i], deadline[i]);
        }

        Arrays.sort(arr,(a,b)->{
            if(a.profit!=b.profit) return b.profit-a.profit;
            return b.deadline-a.deadline;
        });

        int mx = 0;
        for(int i=0;i<n;i++){
            mx = Math.max(mx, deadline[i]);
        }
        boolean[] slots = new boolean[mx+1];

        int totalProfit = 0;
        for(int i=0;i<n;i++){
            for(int j=arr[i].deadline;j>0;j--){
                if(!slots[j]){
                    slots[j] = true;
                    totalProfit += arr[i].profit;
                    break;
                }
            }
        }
        return totalProfit;
    }
    /* DP approach => Recursion + Memoization
    public static int maxProfit(int[] deadline, int[] profit){
        Pair[] arr = new Pair[deadline.length];
        for(int i=0;i<deadline.length;i++){
            arr[i] = new Pair(deadline[i],profit[i]);
        }
        Arrays.sort(arr,(a,b)->{
            if(a.first!=b.first) return a.first-b.first;
            return b.second-a.second;
        });
        for(int i=0;i<deadline.length;i++){
            deadline[i] = arr[i].first;
            profit[i] = arr[i].second;
        }
        HashMap<String, Integer> dp = new HashMap<>();
        return solve(deadline,profit,0,0, dp);
    }
    public static int solve(int[] deadline, int[] profit, int index, int time, HashMap<String, Integer> dp){
        if(index== deadline.length)
            return 0;

        if(dp.containsKey(key(index,time))) return dp.get(key(index,time));

        // doing the job
        int doing = Integer.MIN_VALUE;
        if(deadline[index]>time){
            doing = profit[index] + solve(deadline,profit,index+1,time+1, dp);
        }

        // skipping it
        int skipping = solve(deadline,profit,index+1,time, dp);

        dp.put(key(index,time),Math.max(doing,skipping));
        return dp.get(key(index,time));
    }
    public static String key(int a, int b){
        return a + "|" + b;
    }*/
}
class Job{
    int profit;
    int deadline;
    Job(int profit, int deadline){
        this.profit = profit;
        this.deadline = deadline;
    }
}

