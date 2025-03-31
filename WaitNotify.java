//public class WaitNotify {
//    private final Object lock = new Object();
//
//    public static void main(String[] args) {
//        WaitNotify thread2 = new WaitNotify();
//        new Thread(() -> {
//            try {
//                synchronized (thread2.lock) {
//                    System.out.println("Acquired Lock Thread 1");
//                    Thread.sleep(5000);
//                    thread2.lock.wait();
//                    System.out.println("Thread running back");
//                }
//            } catch (InterruptedException e) {
//                System.out.println(e+" ");
//            }
//        }).start();
//
//        new Thread(() -> {
//            try {
////                Thread.sleep(500);
////                synchronized (thread2.lock) {
////                    System.out.println("Acquired Lock Thread 2");
////                    thread2.lock.notify();
////                    System.out.println("Thread finishing work");
//                ;
//                }
//            } catch (Exception e) {
//                System.out.println(e+" ");
//            }
//        }).start();
//    }
//}
