package Packages;

public class JavaAbstraction {
    public static void main(String[] args) {
        Android vivo = new Android();
        Iphone seven = new Iphone();
        vivo.call();
        seven.call();
        vivo.playVideo();
        seven.playVideo();
    }
}

abstract class Smartphone{
    public abstract void selfi();
    public abstract void call();
    public void playVideo(){
        System.out.println("Video is playing...");
    }
}

class Android extends Smartphone{
    public void selfi(){
        System.out.println("Selfi is taken on android...");
    }

    public void call(){
        System.out.println("Calling from android...");
    }
}

class Iphone extends Smartphone{
    public void selfi(){
        System.out.println("Selfi is taken on iPhone...");
    }

    public void call(){
        System.out.println("Calling from iPhone...");
    }
}