package RandomDSAQuestions;

import java.util.Scanner;

public class Ceiling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        System.out.print("Enter the element to find the ceiling : ");
        int x = sc.nextInt();

        System.out.println("The ceil of "+ x + " is " + ceilingOfx(arr,x));
        System.out.println("The floor of "+ x + " is " + floorOfx(arr,x));
        System.out.println("The count of "+x+ " is "+ (ceilingOfx(arr,x)-floorOfx(arr,x)+1));
    }

    public static int ceilingOfx(int[] arr, int key){
        int start = 0, end = arr.length-1, ans = -1;
        while(start<=end){
            int mid = (start+end)/2;

            if(arr[mid]==key){
                ans = mid;
                start = mid+1;
            }

            else if(arr[mid]<key){
                start = mid+1;
            }
            else end = mid-1;
        }
        return ans;
    }


    public static int floorOfx(int[] arr, int key){
        int start = 0, end = arr.length-1, ans = -1;
        while(start<=end){
            int mid = (start+end)/2;

            if(arr[mid]==key){
                ans = mid;
                end = mid-1;
            }

            else if(arr[mid]<key){
                start = mid+1;
            }

            else end = mid-1;
        }
        return ans;
    }
}
