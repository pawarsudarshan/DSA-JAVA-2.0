package RandomDSAQuestions2;

public class MinJumpsToReachEnd {
    public static void main(String[] args) {
        int arr[] = {0};
        System.out.println(minJumps(arr));
    }
    static int minJumps(int[] arr){
        int maxReach = arr[0], stairs = arr[0];
        int jumps = 1, n = arr.length;

        if(arr[0]==0 && n==1) return 0;
        if(arr[0]==0) return -1;

        for(int i=1;i<n;i++){
            if(i==n-1){
                return jumps;
            }

            maxReach = Math.max(maxReach, i+arr[i]);

            stairs--;

            if(stairs==0){
                stairs = maxReach - i;
                if(stairs<=0){
                    return -1;
                }
                jumps++;
            }
        }

        return jumps;
    }
}
