package multithreading;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class Counter5 {
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
    public int getCount() {
        return count;
    }
}

class ThreadDemo5 extends Thread {
    Counter5 counter;

    ThreadDemo5(Counter5 counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 10; i >0; i--) {
            counter.increment();
            System.out.println(i);
        }
    }
}

public class MT_Task09 {
    public static void main(String[] args) {
        Counter5 counter = new Counter5();
        ThreadDemo5 t1 = new ThreadDemo5(counter);
        ThreadDemo5 t2 = new ThreadDemo5(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());
    }
}













