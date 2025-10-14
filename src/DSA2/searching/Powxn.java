package DSA2.searching;

public class Powxn {
    public static void main(String[] args) {
        double x = 2.0;
        int n = 10;
        System.out.println(myPow(x,n));
    }
    public static double myPow(double x, int n) {
        if(n==0) return 1;
        if(n==1 || x==1) return x;

        if(n<0) return 1/fastPower(x,-n);
        return fastPower(x,n);
    }

    public static double fastPower(double x, int n){
        if(n==1) return x;
        if(n==0) return 1;

        double power = fastPower(x,n/2);
        if((n&1)==1) return power*power*x;

        return power*power;
    }
}
