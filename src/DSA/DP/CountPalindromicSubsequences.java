package DP;

public class CountPalindromicSubsequences {
    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(countPS(str));
    }

    static long countPS(String str) {
        int [][] dp = new int[str.length()][str.length()];

        for(int g = 0; g<str.length();g++){
            for(int i=0,j=g; j<str.length();i++,j++){
                boolean isSame = str.charAt(i) == str.charAt(j);
                if(g==0){
                    dp[i][j] = 1;
                } else if(g==1){
                    dp[i][j] = isSame ? 3:2;
                } else{
                    if(isSame){
                        dp[i][j] = 1 + dp[i][j-1] + dp[i+1][j];
                    }else{
                        dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
                    }
                }
            }
        }
        return dp[0][str.length()-1];
    }
}
