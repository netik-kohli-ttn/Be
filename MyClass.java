import java.util.Iterator;

class SharedData {
    int value;
    boolean isProduced = false;

    synchronized void produce(int v) {
        while (isProduced) {
            try { wait(); } catch (InterruptedException e) { }
        }
        value = v;
        System.out.println("Produced: " + value);
        isProduced = true;
        notify();
    }

    synchronized void consume() {
        while (!isProduced) {
            try { wait(); } catch (InterruptedException e) { }
        }
        System.out.println("Consumed: " + value);
        isProduced = false;
        notify();
    }
}

class Producer extends Thread {
    SharedData data;
    Producer(SharedData data) { this.data = data; }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            data.produce(i);
        }
    }
}

class Consumer extends Thread {
    SharedData data;
    Consumer(SharedData data) { this.data = data; }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            data.consume();
        }
    }
}

public class MyClass {
    public static void main(String[] args) {
        SharedData data = new SharedData();
        new Producer(data).start();
        new Consumer(data).start();
        int i= Integer.parseInt(null);
        System.out.println(i);
        Consumer
    }
}
