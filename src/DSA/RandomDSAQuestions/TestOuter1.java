package RandomDSAQuestions;

public class TestOuter1{
    static int data=30;
    class Inner{
        void msg(){
            System.out.println("data is "+data);
        }
    }

    public static void main(String args[]){

        TestOuter1 obj1 = new TestOuter1();
        Inner obj2 = obj1.new Inner();

        obj2.msg();

//        Inner obj=new Inner();
//        obj.msg();
    }
}