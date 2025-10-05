package Packages;

public class JavaInterfaces {
    public static void main(String[] args) {
        BMW car1 = new BMW();
        car1.run();
        car1.brake();
        car1.tellEngineType();
    }
}

interface Vehicle{
    void run();
    void brake();
}
interface ElectricVehicle{
    void tellEngineType();
}
class BMW implements Vehicle, ElectricVehicle{
    @Override
    public void run(){
        System.out.println("BMS is running...");
    }
    @Override
    public void brake(){
        System.out.println("BMW is slowing down...");
    }
    @Override
    public void tellEngineType(){
        System.out.println("BMW has electric engine...");
    }
}