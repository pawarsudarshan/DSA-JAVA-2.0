package ExceptionHandlingAndGenerics;

import java.util.Scanner;

public class Exception1 {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        int[] arr = new int[10];

        Scanner sc = new Scanner(System.in);

        try{
//            System.out.println(a/b);
//            divide(a,b);
//            if(arr[10] == (a/b)){
//                System.out.println("we are in if..");
//            }
            String password = sc.next();
            if(password.equals("pswd")) {
                throw new MyException1("Please do not enter an old password.");
            }else{
                System.out.println("Password changed successfully");
            }
        }catch(MyException1 e){
            System.out.println(e.getMessage());
        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("No matter what this will execute itself.");
        }
    }

    static int divide(int a, int b) throws ArithmeticException{
        if(b==0){
            throw new ArithmeticException("Please do not divide by zero");
        }
        return a/b;
    }
}
