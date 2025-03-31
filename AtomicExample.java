import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;
import java.util.function.Consumer;

class SharedObj {
    AtomicInteger count = new AtomicInteger(0);

    void increment() {
        count.incrementAndGet();
    }

    void decrement() {
        count.decrementAndGet();
    }

    void print() {
        System.out.println(count.get());
    }
}

public class AtomicExample {
    public static void main(String[] args) throws InterruptedException {
        SharedObj obj = new SharedObj();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++)
                obj.increment();
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++)
                obj.increment();
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        obj.print();
        BiFunction
    }
}
