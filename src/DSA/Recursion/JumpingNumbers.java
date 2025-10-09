package Recursion;

public class JumpingNumbers {
    public static void main(String[] args) {
        int n = 50;
        System.out.println(jumpingNums(n));
    }
    static long jumpingNums(long n) {
        long ans = 0;
        for(int i=1;i<=9;i++){
            ans = Math.max(ans,solve(i,n,ans));
        }
        return ans;
    }
    static long solve(long curr, long n, long ans){
        if(curr>n) return -1;
//        System.out.println("curr : "+ curr);
        ans = Math.max(ans,curr);
//        if(curr>ans) ans = curr;

//        System.out.println("ans : "+ ans);
        long rem = curr%10;

        if(rem>0){
            ans = Math.max(ans,solve(curr*10+(rem-1),n,ans));
        }
        if(rem<9){
            ans = Math.max(ans,solve(curr*10+(rem+1),n,ans));
        }
        return ans;
    }
}
