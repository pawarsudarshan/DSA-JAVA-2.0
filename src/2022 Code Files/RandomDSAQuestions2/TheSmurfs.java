package RandomDSAQuestions2;

import java.util.Objects;

public class TheSmurfs {
    public static void main(String[] args) {
        String[] arr = {};
        int n = arr.length;
        System.out.println(minFind(n,arr));
    }
    static int minFind(int n, String[] arr){
        int red = 0, blue = 0, green = 0;

        for(int i=0;i<n;i++){
            if(Objects.equals(arr[i], "R")) red++;
            else if(arr[i].equals("B")) blue++;
            else green++;
        }

        System.out.println(red);
        System.out.println(blue);
        System.out.println(green);
        // It's just the thing of observation
        // below are the rules after the observation
        if((red==0 && blue==0) || (blue==0 && green==0) || (red==0 && green==0))
            return n;

        if(red%2==0 && blue%2==0 && green%2==0)
            return 2;

        if(red%2!=0 && blue%2!=0 && green%2!=0)
            return 2;

        return 1;
    }
}
