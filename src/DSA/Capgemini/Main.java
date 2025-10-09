package Capgemini;
import java.util.*;

public class Main{
    public static void main(String[] args){
        // Reverse a string

        // String str = "Sudarshan";
        // StringBuilder s = new StringBuilder();
        // for(int i=str.length()-1;i>=0;i--){
        //     s.append(str.charAt(i));
        // }

        // String reversed = s.toString();
        // System.out.println(reversed);


        // Palindrome number

        // int num = 121;
        // int org = num;
        // int rev = 0;

        // while(num>0){
        //     rev = rev *10;
        //     int rem = (num%10);
        //     rev += rem;
        //     num = num/10;
        // }

        // System.out.println(rev+" "+org);
        // if(rev == org){
        //     System.out.println("Number is palindrome");
        // }
        // else{
        //     System.out.println("Number is not a palindrome");
        // }

        // Prime number

        // int num = 23;
        // boolean flag = true;

        // for(int i=2;i*i<=num;i++){
        //     if(num%i==0) {
        //         System.out.println("Not a prime number");
        //         flag = false;
        //         break;
        //     }
        // }

        // if(flag==true){
        //     System.out.println("It is a prime number");
        // }

        // int year;
        // Scanner sc = new Scanner(System.in);
        // year = sc.nextInt();
        // boolean flag = false;

        // if(year%100==0){
        //     if(year%400==0){
        //         flag = true;
        //     }else{
        //         flag = false;
        //     }
        // }else if(year%4==0){
        //     flag = true;
        // }

        // if(flag==true){
        //     System.out.println("The year is leap year");
        // }else{
        //     System.out.println("It is not a leap year");
        // }

//        int[] arr = {1,2,3,4,4,4,4,2,2,2,2,2,2,2,2};
//        int n = arr.length;
//
//        HashMap<Integer,Integer> hm = new HashMap<>();
//
//        for(int i=0;i<n;i++){
//            if(hm.containsKey(arr[i])){
//                hm.put(arr[i],hm.get(arr[i])+1);
//            }else{
//                hm.put(arr[i],1);
//            }
//        }
//
//        for(int key:hm.keySet()){
//            System.out.println(key+" "+hm.get(key));
//        }
        Node x = new Node(5);
        System.out.println(x.data);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(7);
        list.add(9);

        System.out.println("The elements of arraylist are:");
        for(int val:list){
            System.out.println(val);
        }

        boolean[] arr = new boolean[5];
        Arrays.fill(arr,Boolean.TRUE);

        for(boolean val:arr){
            System.out.print(val+" ");
        }
    }
}

class Node{
    int data;
    Node next;

    Node(int x) {
        data = x;
    }
}