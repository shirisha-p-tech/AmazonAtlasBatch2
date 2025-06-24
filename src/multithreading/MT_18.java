package multithreading;

class Tester extends Thread{
    public void run(){
        System.out.println("Thread started by JVM by start() and executed in run()");
    }
}
public class MT_18 {
    public static void main(String[] args) {
        Tester t =new Tester();
        t.start(); //JVM creates thread and call the thread's run()
    }

}
