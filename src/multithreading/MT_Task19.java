package multithreading;

class MyRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println("Code executed in new thread via Runnable implementation");
    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Code executed in new thread via Thread extension");
    }
}
public class MT_Task19 {
    public static void main(String[] args) {
        MyThread t =new MyThread();
        t.start();

        MyRunnable r=new MyRunnable();
        Thread t1= new Thread(r);
        t1.start();
    }

}
