package RandomDSAQuestions2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class HashingJava {
    public static void main(String[] args) {
        HashSet<Integer> s = new HashSet<>();

        //Insertion     .add()
        s.add(5);
        s.add(6);
        s.add(2);
        s.add(3);

        for(int ele: s){
            System.out.print(ele+ " ");
        }

        // Search O(1) - .contains()
        if(s.contains(3))
            System.out.println("Set contains 3");

        if(!s.contains(8))
            System.out.println("Set does not contains 8");

        // Deletion   .remove()
        s.remove(3);
        for(int ele: s){
            System.out.print(ele+ " ");
        }

        // Size    .size()
        System.out.println("The size of set is : " + s.size());

        // Printing all elements
        System.out.println(s);

        // Iterator
        Iterator it = s.iterator();

        while(it.hasNext()){
            System.out.print(it.next()+ " ");
            // we don't need to do something like it++ or it-- bcoz it will automatically increment
        }

        // Sorted Sets - TreeSet
        TreeSet<Integer> mySet = new TreeSet<>();
        mySet.add(1);
        mySet.add(5);
        mySet.add(3);

        System.out.println(mySet);

        Iterator it2 = mySet.iterator();

        while(it2.hasNext()){
            System.out.println(it2.next());
        }
    }
}
