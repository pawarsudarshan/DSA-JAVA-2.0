package ExceptionHandlingAndGenerics;

public class Student implements Comparable<Student>{
    int rollno;
    float marks;

    Student(int rollno, float marks){
        this.rollno = rollno;
        this.marks = marks;
    }

    @Override
    public String toString(){
        return marks+"";
    }

    @Override
    public int compareTo(Student o){
        int diff = (int)(this.marks - o.marks);
        return diff;
    }

    public static void main(String[] args) {
        Student sudipta = new Student(71,80.50f);
        Student vipul = new Student(117, 77.98f);

        System.out.println(sudipta);
        System.out.println(vipul);

        if(sudipta.compareTo(vipul)==0){
            System.out.println("Both have same marks");
        }
        else if(sudipta.compareTo(vipul)>1){
            System.out.println("Sudipta has more marks");
        }
        else System.out.println("Vipul has more marks");
    }
}
