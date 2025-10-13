package DSA2.searching;

public class nthRoot {
    public static void main(String[] args) {
        int m = 86;
        int n = 4;
        System.out.println(nthRootOfM(m,n));
    }
    public static int nthRootOfM(int m, int n){
        int start = 0, end = m;
        while(start<=end){
            int mid = start + (end-start)/2;

            // calculate nth power
            // you can use fast exponentiation method
            long nthPower = 1, count=n;
            while(count>0){
                nthPower = nthPower*mid;
                count--;
            }

            if(nthPower==(long)m) return mid;
            else if(nthPower>(long)m) end = mid-1;
            else start = mid+1;
        }
        return -1;
    }
}
