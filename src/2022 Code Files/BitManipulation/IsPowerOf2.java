package BitManipulation;
// 1. is power of 2
// if n & (n-1) is 0 then it is power of 2
// 2. swap all odd and even bits
// 3. maximum AND value (good question)

public class IsPowerOf2 {
    public static void main(String[] args) {
        long n = 8;
        System.out.println(isPowerofTwo(n));
    }
    public static boolean isPowerofTwo(long n){
        if(n==1) return true;
        if(n==0) return false;

        if((n&(n-1))==0)
            return true;

        return false;
    }
}
