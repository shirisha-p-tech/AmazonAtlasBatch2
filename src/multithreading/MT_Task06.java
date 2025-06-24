package multithreading;
class Counter2 {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class ThreadDemo2 extends Thread {
    Counter2 counter;

    ThreadDemo2(Counter2 counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 10; i >0; i--) {
            counter.increment();
            System.out.println(i);
        }
    }
}

public class MT_Task06 {
    public static void main(String[] args) {
        Counter2 counter = new Counter2();
        ThreadDemo2 t1 = new ThreadDemo2(counter);
        ThreadDemo2 t2 = new ThreadDemo2(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count using sync method: " + counter.getCount());
    }
}





