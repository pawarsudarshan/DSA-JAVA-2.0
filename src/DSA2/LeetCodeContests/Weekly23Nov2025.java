package DSA2.LeetCodeContests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Weekly23Nov2025 {
    public static void main(String[] args) {

    }
    public static final long MOD = 1_000_000_007;

    public static int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();
        List<Integer> pos = new ArrayList<>();
        List<Integer> digs = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if (c != '0') {
                pos.add(i);
                digs.add(c - '0');
            }
        }

        int k = pos.size();

        long[] prefSum = new long[k];
        long[] prefX = new long[k];
        long[] pow10 = new long[k + 1];
        pow10[0] = 1;

        for (int i = 1; i <= k; i++) pow10[i] = (pow10[i - 1] * 10) % MOD;

        for (int i = 0; i < k; i++) {
            prefSum[i] = digs.get(i) + (i > 0 ? prefSum[i - 1] : 0);
            long d = digs.get(i);
            prefX[i] = ((i > 0 ? prefX[i - 1] : 0) * 10 + d) % MOD;
        }

        int q = queries.length;
        int[] res = new int[q];

        for (int qi = 0; qi < q; qi++) {
            int left = queries[qi][0];
            int right = queries[qi][1];

            int L = lowerBound(pos, left);
            int R = upperBound(pos, right) - 1;

            if (L > R || L < 0 || R < 0 || L >= k) {
                res[qi] = 0;
                continue;
            }

            long sum = prefSum[R] - (L > 0 ? prefSum[L - 1] : 0);

            long x = prefX[R];
            if (L > 0) {
                int cnt = R - L + 1;
                long rem = (prefX[L - 1] * pow10[cnt]) % MOD;
                x = (x - rem + MOD) % MOD;
            }

            long mul = (x % MOD) * (sum % MOD) % MOD;
            res[qi] = (int) mul;
        }

        return res;
    }

    private static int lowerBound(List<Integer> arr, int target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr.get(mid) >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private static int upperBound(List<Integer> arr, int target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr.get(mid) > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    public int maxbalancedSubarray(int[] nums) {
        int n = nums.length;
        int prefix = 0, balanced = 0, res = 0;

        Map<String, Integer> map = new HashMap<>();
        map.put("0#0", -1);

        for (int i = 0; i < n; i++) {
            prefix ^= nums[i];

            if ((nums[i] & 1) == 0) balanced++;
            else balanced--;

            String key = prefix + "#" + balanced;

            if (map.containsKey(key)) {
                int len = i - map.get(key);
                res = Math.max(res,len);
            } else {
                map.put(key, i);
            }
        }

        return res;
    }
}
