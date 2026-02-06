package CollectionsFramework;
import java.util.*;

public class ArrayListCF {
    public static void main(String[] args) {

        /*
         * ArrayList:
         * - Part of Java Collections Framework
         * - Implements List interface
         * - Backed by a dynamic array
         * - Maintains insertion order
         * - Allows duplicate elements
         * - Not synchronized (not thread-safe)
         */

        /* =======================
           Creation
           ======================= */

        // O(1)
        ArrayList<Integer> list = new ArrayList<>();

        /*
         * Default initial capacity = 10
         * Capacity grows automatically (~1.5x)
         */
        ArrayList<Integer> listWithCapacity = new ArrayList<>(20);


        /* =======================
           Adding Elements
           ======================= */

        /*
         * add(element)
         * - Adds element at the end
         * - Amortized O(1)
         * - Worst case O(n) when resizing happens
         */
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        /*
         * add(index, element)
         * - Inserts element at given index
         * - Elements to the right are shifted
         * - Time Complexity: O(n)
         */
        list.add(1, 23); // [1, 23, 2, 3, 4, 5]


        /* =======================
           Updating Elements
           ======================= */

        /*
         * set(index, element)
         * - Replaces element at index
         * - No shifting
         * - Time Complexity: O(1)
         */
        list.set(2, 34); // [1, 23, 34, 3, 4, 5]


        /* =======================
           Accessing Elements
           ======================= */

        /*
         * get(index)
         * - Direct access using index
         * - Time Complexity: O(1)
         */
        int value = list.get(3);
        System.out.println(value);


        /* =======================
           Removing Elements
           ======================= */

        /*
         * remove(index)
         * - Removes element at index
         * - Left shift of elements
         * - Time Complexity: O(n)
         */
        list.remove(1); // removes element at index 1

        /*
         * remove(Object o)
         * - Searches element, then removes it
         * - Time Complexity: O(n)
         *
         * Important:
         * remove(1) -> index based
         * remove(Integer.valueOf(1)) -> value based
         */
        list.remove(Integer.valueOf(3));


        /* =======================
           Size
           ======================= */

        /*
         * size()
         * - Returns number of elements
         * - Time Complexity: O(1)
         */
        System.out.println("Size: " + list.size());


        /* =======================
           Iterating
           ======================= */

        /*
         * Enhanced for-loop
         * - Iterates sequentially
         * - Time Complexity: O(n)
         */
        for (int i : list) {
            System.out.println(i);
        }


        /* =======================
           Searching
           ======================= */

        /*
         * contains(element)
         * - Linear search
         * - Time Complexity: O(n)
         */
        boolean exists = list.contains(34);


        /* =======================
           Sorting Primitive / Wrapper Types
           ======================= */

        /*
         * sort(null)
         * - Sorts in ascending order
         * - Uses TimSort
         * - Time Complexity: O(n log n)
         */
        list.sort(null);

        /*
         * sort(Collections.reverseOrder())
         * - Descending order
         * - Time Complexity: O(n log n)
         */
        list.sort(Collections.reverseOrder());


        /* =======================
           Sorting Custom Objects
           ======================= */

        List<Student> students = new ArrayList<>();
        students.add(new Student("Charlie", 3.5));
        students.add(new Student("Bob", 3.7));
        students.add(new Student("Alice", 3.5));
        students.add(new Student("Akshit", 3.9));

        /*
         * Custom Comparator using lambda
         * - Sort by GPA (descending)
         * - If GPA same, sort by name (ascending)
         * - Time Complexity: O(n log n)
         */
        students.sort((a, b) -> {
            int gpaCompare = Double.compare(b.getGpa(), a.getGpa());
            if (gpaCompare != 0) return gpaCompare;
            return a.getName().compareTo(b.getName());
        });

        /*
         * Preferred clean approach using Comparator utilities
         * - More readable and safer
         * - Time Complexity: O(n log n)
         */
        Comparator<Student> comparator =
                Comparator.comparing(Student::getGpa)
                        .reversed()
                        .thenComparing(Student::getName);

        students.sort(comparator);
    }
}


/* =======================
   Custom Class
   ======================= */
class Student {

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
        return "Student{name='" + name + "', gpa=" + gpa + "}";
    }
}
