package DSA2.Arrays3;

public class CountDistinct {
    public static void main(String[] args) {
        int n = 101;
        System.out.println(countDistinct(n));
    }
    public static long countDistinct(long n) {
        char[] digits = Long.toString(n).toCharArray();
        int len = digits.length;
        Long[][][] dp = new Long[len + 1][2][2];
        return solve(0, 1, 0, digits, dp);
    }

    private static long solve(int index, int tight, int started, char[] digits, Long[][][] dp) {
        if (index == digits.length) {
            return started == 1 ? 1 : 0;
        }

        if (dp[index][tight][started] != null) {
            return dp[index][tight][started];
        }

        long ans = 0;
        int limit = tight == 1 ? digits[index] - '0' : 9;

        for (int dig = 0; dig <= limit; dig++) {
            int nextTight = (tight == 1 && dig == limit) ? 1 : 0;

            if (started == 0) {
                if (dig == 0) {
                    ans += solve(index + 1, nextTight, 0, digits, dp);
                } else if (dig != 0) {
                    ans += solve(index + 1, nextTight, 1, digits, dp);
                }
            } else {
                if (dig == 0) continue;
                ans += solve(index + 1, nextTight, 1, digits, dp);
            }
        }

        return dp[index][tight][started] = ans;
    }

}
