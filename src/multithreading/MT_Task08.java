package multithreading;
class Counter4 {
    private static int count = 0;

    public static synchronized void increment() {
            count++;
        }


    public int getCount() {
        return count;
    }
}

class ThreadDemo4 extends Thread {
    Counter4 counter;

    ThreadDemo4(Counter4 counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 10; i >0; i--) {
            counter.increment();
            System.out.println(i);
        }
    }
}

public class MT_Task08 {
    public static void main(String[] args) {
        Counter4 counter = new Counter4();
        ThreadDemo4 t1 = new ThreadDemo4(counter);
        ThreadDemo4 t2 = new ThreadDemo4(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final static sync count: " + counter.getCount());
    }
}







