package CollectionsFramework;
import java.util.*;

public class ArrayListCF {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        // adding elements
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);


        // adds an element at an index, by adjusting all other elements to right by one position
        list.add(1,23);


        // replaces the element at an index
        list.set(2,34);


        // printing list -> internally calls toString() method
        System.out.println(list);


        // remove elements
        list.remove(1); // here 1 is int (primitive data type) and not object
        // that's why it removes element from 1st index


        // to remove the value wrap it up as object
        list.remove(Integer.valueOf(3)); // finds and removes the value from list


        // get size of arraylist
        System.out.println(list.size());


        /* initial capacity of ArrayList is 10
        we can pass initial capacity while creating the arraylist */
        ArrayList<Integer> list2 = new ArrayList<>(35);


        // for-each loop
        for (int i : list) {
            System.out.println(i);
        }

        // sorting arraylist
        list.sort(null); // null means ascending order


        list.sort(Collections.reverseOrder()); // descending order

        // Sorting using custom comparator
        List<Student> students = new ArrayList<>();
        students.add(new Student("Charlie", 3.5));
        students.add(new Student("Bob", 3.7));
        students.add(new Student("Alice", 3.5));
        students.add(new Student("Akshit", 3.9));

        // using lambda function
        students.sort((a, b) -> {
            // return a.getGpa() - b.getGpa(); -> gives error because of float data type(instead of int) of getGpa() method
            if (a.getGpa() - b.getGpa() > 0) {
                return -1;
            } else if (a.getGpa() == b.getGpa()) {
                return a.getName().compareTo(b.getName());
            }
            return 1;
        });


        // another way to sort using object of Comparator class
        Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);

        students.sort(comparator);
    }
}

class Student{
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa  = gpa;
    }

    public String getName() { return name; }
    public double getGpa()  { return gpa; }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}