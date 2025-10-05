package EMTech;

public class RodCutting {

    public static int SellPlank(int n, int arr[]){
        int[] shreeya=new int[n+1];
        shreeya[0]=0;

        for(int i=1;i<n+1;i++){
            int max=Integer.MIN_VALUE;

            for(int j=0;j<i;j++){
                max=Math.max(max,arr[j]+shreeya[i-j-1]);
            }

            shreeya[i]=max;
        }

        return shreeya[n];
    }

    public static void main(String[] args) {
        int[] arr = {37,87,79,6,85,91,42};
        int n = arr.length;
        System.out.println(SellPlank(n,arr));
    }
}
