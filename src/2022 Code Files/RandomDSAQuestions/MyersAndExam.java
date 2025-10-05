package RandomDSAQuestions;

import java.util.Scanner;

public class MyersAndExam {
    public static int minimal(int n,int[] arr)

    {

        int sum=0;

        for(int i=0;i<n;i++)

        {

            for(int j=i+1;j<n;j++)

            {

                if(arr[i]==arr[j])

                {

                    int[] count = new int[]{1};

                    arr[i]=arr[i]+count[0];

                }

            }

        }

        for(int i=0;i<n;i++)

        {

            sum=sum+arr[i];

        }

        return sum;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        System.out.println(minimal(n,arr));
    }
}
