package BitManipulation;
import java.util.*;

public class CheckKthBitIsSetOrNot {
    public static void main(String[] args) {
        int n = 39;
        int k = 5;
        System.out.println(checkKthBit(n,k));
    }
    static boolean checkKthBit(int n, int k) {
        int checker = 1<<k;
        return (n & checker)==checker;
    }
}
