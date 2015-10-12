import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by chanumolu on 10/11/15.
 */

public class ProducerConsumerBlockingQueue {

    static class Producer implements Runnable{
        private final BlockingQueue<String> queue;

        public Producer(BlockingQueue queue) {
            this.queue = queue;
        }

        public void run() {
            put();
        }

        public synchronized void put() {
            String importantInfo[] = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too",
                    "DONE!!"
            };

            try {
                for (int i = 0;
                     i < importantInfo.length;
                     i++) {
                    String message = importantInfo[i];
                    System.out.println("SENDING MSG : " + message +" by Thread :" + Thread.currentThread().getName());
                    queue.put(message);
                    Thread.sleep(1000);
                }

            } catch (Exception e) {
            }
        }
    }

    static class Consumer implements Runnable {
        private final BlockingQueue queue;
        volatile boolean done = false;
        AtomicInteger count = new AtomicInteger(0);
        public Consumer(BlockingQueue queue) {
            this.queue = queue;
        }

        public void run() {
            consume();
        }

        public synchronized void consume() {
            while (!done){
                try {
                    String message = (String) queue.take();
                    count.getAndIncrement();
                    System.out.println("CONSUMED MSG : " + message +" by Thread :" + Thread.currentThread().getName());
                    if(message.equals("DONE!!")){
                        done =true;
                        System.out.println("Total messages consumed by consumer : " +Thread.currentThread().getName() +" is "+ count.get());
                    }

                } catch (Exception e) {
                }
            }

        }
    }

    public static void main(String[] args) {
        BlockingQueue<String> q = new ArrayBlockingQueue<String>(2);
        Producer p1 = new Producer(q);
        Producer p2 = new Producer(q);
        Consumer c1 = new Consumer(q);
        Consumer c2 = new Consumer(q);
        new Thread(p1,"P1").start();
        new Thread(c1,"C1").start();
        new Thread((p2),"P2").start();
        new Thread(c2,"C2").start();



    }
}
