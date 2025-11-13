package DSA2.Greedy;

public class MaxOperationsToMoveAll1sToEnd {
    public static int maxOperations(String s) {
        int finalCount = 0, n = s.length(), count = (s.charAt(0) - '0');

        for (int i = 1; i < n; i++){
            int x = s.charAt(i) - '0';
            count += x;
            finalCount += (x == 0 && s.charAt(i-1) - '0' == 1) ? count : 0;
        }

        return finalCount;
    }
}
