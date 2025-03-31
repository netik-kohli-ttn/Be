import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Demo {
    Lock lock = new ReentrantLock();
    void doSomething() throws InterruptedException {
        if (lock.tryLock(2000, TimeUnit.MILLISECONDS)) {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " aquired lock");
            try {
                System.out.println(Thread.currentThread().getName() + " is running");
            } finally {
                lock.unlock();
                lock.unlock();
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " released lock");
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " not get lock");
        }
    }
}

class Mult extends Thread {
    Demo demo;
    Mult(Demo demo) {
        this.demo = demo;
    }
    public void run() {
        try {
            demo.doSomething();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class MultiThreadingPractice{
    public static void main(String[] args) throws InterruptedException {
        Demo demo = new Demo();
        Mult m1 = new Mult(demo);
        Mult m2 = new Mult(demo);
        Mult m3 = new Mult(demo);
        m1.start();
        m2.start();
        m3.start();

        m1.join();
        m2.join();
        m3.join();
    }
}
