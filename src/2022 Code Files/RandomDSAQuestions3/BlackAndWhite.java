package RandomDSAQuestions3;
import java.util.*;

public class BlackAndWhite {
    public static void main(String[] args) {
        System.out.println(numOfWays(2,3));
    }
    static long numOfWays(int N, int M) {
        long ans = 0;
        long mod = 1000000007;
        long numberOfSquares = N*M;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                int count = 0;
                if(i-2>=0){
                    if(j-1>=0) count++;
                    if(j+1<M) count++;
                }
                if(i-1>=0){
                    if(j-2>=0) count++;
                    if(j+2<M) count++;
                }
                if(i+1<N){
                    if(j-2>=0) count++;
                    if(j+2<M) count++;
                }
                if(i+2<N){
                    if(j-1>=0) count++;
                    if(j+1<M) count++;
                }
                long tempAns = numberOfSquares-count-1;
                tempAns = tempAns%mod;
                ans = ((ans%mod)+(tempAns%mod))%mod;
            }
        }
        return ans;
    }
}
