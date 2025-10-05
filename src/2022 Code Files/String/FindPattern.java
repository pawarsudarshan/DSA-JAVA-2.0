package String;
import java.util.*;

public class FindPattern {
    public static void main(String[] args) {
        String s = "abcdrtbwerrcokokokd" ;
        String w = "bcd";
        System.out.println(numberOfSubsequences(s,w));

    }
    static int numberOfSubsequences(String s, String w) {
        int n = s.length(), m = w.length(), count = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int k = 0; k < n; k++) {
            int i = 0, j = 0;
            while (i < n) {
                if (!set.contains(i)) {
                    if (s.charAt(i) == w.charAt(j)) {
                        set.add(i);
                        j++;
                    }
                }

                if (j == m) {
                    count++;
                    break;
                }

                i++;
            }
        }

        return count;
    }
}
