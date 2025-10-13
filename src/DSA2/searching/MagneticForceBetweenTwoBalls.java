package DSA2.searching;
// Basically it is agressive cows problem
import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        int[] pos = {1,2,3,4,7};
        int m = 3;
        System.out.println(maxDistance(pos,m));
    }
    public static int maxDistance(int[] pos, int m) {
        Arrays.sort(pos);
        int n = pos.length, ans = 0;
        int start = 0, end = pos[n-1];

        while(start<=end){
            int mid = start + (end-start)/2;

            // check
            if(check(pos,m,mid)) {
                if(mid>ans) ans = mid;
                start = mid + 1;
            }else end = mid-1;
        }
        return ans;
    }

    public static boolean check(int[] pos, int m, int mid){
        int n = pos.length, count = 1, prev = pos[0];
        for(int i=1;i<n;i++){
            if(pos[i]-prev >=mid){
                prev = pos[i];
                count++;
            }
            if(count==m) return true;
        }
        return false;
    }
}
