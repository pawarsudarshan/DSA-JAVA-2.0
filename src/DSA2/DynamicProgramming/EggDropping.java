package DSA2.DynamicProgramming;

public class EggDropping {
    public static void main(String[] args) {
        int e = 2, f = 36;
        System.out.println(eggDrop(e,f));
    }
    public static int eggDrop(int e, int f){
        int[][] dp = new  int[e+1][f+1];
        for(int i=0;i<=e;i++){
            for(int j=0;j<=f;j++){
                dp[i][j] = -1;
            }
        }
        return eggDropSolver(e,f,dp);
    }
    public static int eggDropSolver(int e, int f, int[][] dp){
        // Base case
        if(e==1) return f;
        if(f==1 || f==0) return f;

        int start = 1, end = f;
        int min = Integer.MAX_VALUE;

        if(dp[e][f]!=-1) return dp[e][f];

        while(start<=end){
            int mid =  start + (end-start)/2;

            int crack = eggDropSolver(e-1, mid-1, dp);

            int notCrack = eggDropSolver(e,f-mid, dp);

            int worstCase = 1 + Math.max(crack, notCrack);

            min = Math.min(worstCase,min);

            if(crack>notCrack) {
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        dp[e][f] = min;
        return min;
    }
}
