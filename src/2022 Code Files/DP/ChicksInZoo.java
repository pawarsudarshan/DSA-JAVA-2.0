package DP;

import javax.swing.plaf.basic.BasicListUI;
import java.util.ArrayList;

public class ChicksInZoo {
    public static void main(String[] args) {
        System.out.println(NoOfChicks(35));
    }
    static int count = 0;
    static ArrayList<Long> list = new ArrayList<>();
    static ArrayList<Long> num = new ArrayList<>();

    static void helper(){
        list.add(0L);
        num.add(0L);
        num.add(1L);
        list.add(1L);
        for(int i=2;i<=6;i++){
            num.add(list.get(i-1)*2);
            list.add((list.get(i-1)*3));
        }
        for(int i=7;i<=35;i++){
            num.add((list.get(i-1)-num.get(i-6))*2);
            list.add( ( list.get(i-1) - num.get(i-6) ) + num.get(i));
        }
        System.out.println(num);
        System.out.println(list);
    }

    static long NoOfChicks(int n) {
        if(count==0){
            helper();
            count++;
        }
        return list.get(n);
    }
}
