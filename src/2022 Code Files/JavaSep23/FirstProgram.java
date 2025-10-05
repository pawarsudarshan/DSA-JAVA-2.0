package JavaSep23;

public class FirstProgram {
    public static void main(String[] args) {
        Student obj = new Student("Sudarshan");
        System.out.println(obj);
    }
}
class Student{
    String name;
    Student(String name)
    {
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}