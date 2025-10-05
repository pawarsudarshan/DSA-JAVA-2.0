import java.util.Arrays;
// classes objects and constructors,  "this" & "final" keyword , garbage collector
// Kunal Kushwaha OOP lecture 1
// #OOP1 #KunalKushwaha

public class ClassesInJava {
    public static void main(String[] args) {
        Student sudarshan = new Student(); // self provided constructor
        Student vishal = new Student(109,"Vishal Dorge" ,8.93f); //parametrized constructor
        Student sudipta = new Student(vishal); //copy constructor

        System.out.println(sudarshan.rollno+" "+sudarshan.name+" "+sudarshan.marks);
        System.out.println(vishal.rollno+" "+vishal.name+" "+vishal.marks);
        System.out.println(sudipta.rollno+" "+sudipta.name+" "+sudipta.marks);

        Student one = new Student();
        Student two = one;

        two.name = "Something Something";
        System.out.println(one.name);

        final A ravi = new A("Ravi");
        System.out.println(ravi.name);

        ravi.name = "New Ravi";

        System.out.println(ravi.name);

//        ravi = new A("trying to modify ravi which is final"); // gives error - cannot assign value to final variable 'ravi'

//        A obj ;
//        for(int i=0;i<100000000;i++){
//            obj = new A(); // every time it points to the new object in heap memory
        // there are a lot of objects created that's why garbage collector destroys them
        // if there are few of them then it is not much load of memory and GC may not destroy them
//        }

    }
}

class Student{
    int rollno;
    String name;
    float marks;

    Student (){
        this (113, "Sudarshanya", 8.85f);
//        this.rollno = 113;
//        this.name = "Sudarshan Pawar";
//        this.marks = 8.85f;
    }

    Student (int rollno, String name, float marks){
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
    }

    Student (Student random){
        this.rollno = random.rollno;
        this.name = random.name;
        this.marks = random.marks;
    }
}


class A{
    final int roll = 50;
    String name ;
    A(){}
    A(String name){
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("object is destroyed");
        super.finalize();
    }
}