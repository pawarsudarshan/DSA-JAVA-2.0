package ExceptionHandlingAndGenerics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ObjectCloningTutorial {
    public static void main(String[] args) throws CloneNotSupportedException{
        Human sudarshan = new Human("Sudarshan", 21);
        Human rohan = (Human)sudarshan.clone();

        System.out.println(rohan.age);

        System.out.println(Arrays.toString(sudarshan.arr));
        rohan.arr[0] = 100;
        System.out.println(Arrays.toString(rohan.arr));
    }
}
class Human implements Cloneable {
    String name;
    int age;
    int[] arr;

    Human(String name, int age){
        this.name = name;
        this.age = age;
        this.arr = new int[]{1,2,3,4,5};
    }

//    @Override
//    public Object clone() throws CloneNotSupportedException{
//        return super.clone();
//    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        // this is deep copy
        Human twin = (Human)super.clone(); // this is actually shallow copy

        // make a deep copy
        twin.arr = new int[twin.arr.length];
        for (int i = 0; i < twin.arr.length; i++) {
            twin.arr[i] = this.arr[i];
        }
        return twin;
    }
}