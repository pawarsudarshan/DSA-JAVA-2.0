package DSA2.Greedy;
/*
LC 1578. Minimum Time to Make Rope Colorful
 */
public class MinimumTimeToMakeRopeColorful {
    public static void main(String[] args) {
        String colors = "abaac";
        int[] neededTime = {1,2,3,4,5};
        System.out.println(minCost(colors,neededTime));
    }
    // Greedy Approach => Maintain the running sum and max value for repeated letters.
    public static int minCost(String s, int[] nt) {
        int n = s.length(), minTime = 0;
        for(int i=0;i<n;i++){
            int j =i;
            int max = 0, sum = 0, count = 0;

            while(j<n && s.charAt(j)==s.charAt(i)){
                max = Math.max(max,nt[j]);
                sum += nt[j];
                j++;
                count++;
            }
            i = j-1;
            if(count>1)
                minTime += (sum-max);
        }

        return minTime;
    }

/* DP approach => Recursion + Memoization
    public int minCost(String colors, int[] neededTime) {
        HashMap<String,Integer> dp = new HashMap<>();
        return solve(colors,neededTime,dp,colors.length()-1,'.');
    }
    public int solve(String col, int[] nt, HashMap<String,Integer> dp, int n, char prevColor){
        // Base case
        if(n<0) return 0;

        // memoization
        if(dp.containsKey(key(n,prevColor))) return dp.get(key(n,prevColor));

        // remove
        int remove = nt[n] + solve(col,nt,dp,n-1,prevColor);

        // skip
        int skip = Integer.MAX_VALUE;
        if(prevColor!=col.charAt(n)){
            skip = solve(col,nt,dp,n-1,col.charAt(n));
        }

        dp.put(key(n,prevColor),Math.min(remove,skip));
        return dp.get(key(n,prevColor));
    }
    public String key(int n, char ch){
        return n + "|" + ch;
    }
*/

}
