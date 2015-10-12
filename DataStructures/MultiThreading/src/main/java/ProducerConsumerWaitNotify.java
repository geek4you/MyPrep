/**
 * Created by chanumolu on 10/11/15.
 */

import java.util.Random;

/**
 * Taken from https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html
 * <p>
 * Let's use guarded blocks to create a Producer-Consumer application. This kind of application shares data between
 * two threads: the producer, that creates the data, and the consumer, that does something with it. The two threads
 * communicate using a shared object. Coordination is essential: the consumer thread must not attempt to retrieve the
 * data before the producer thread has delivered it, and the producer thread must not attempt to deliver new data if
 * the consumer hasn't retrieved the old data.
 * <p>
 * In this example, the data is a series of text messages, which are shared through an object of type Drop:
 */
public class ProducerConsumerWaitNotify {

    static class Drop {
        // Message sent from producer to consumer.
        private String message;
        // True if consumer should wait for producer to send message,false if producer should wait for
        // consumer to retrieve message.
        private boolean empty = true;

        public synchronized String take() {

            // wait untill message is available
            while (empty) {
                try {
                    wait();
                } catch (Exception e) {
                }

            }

            // toggle status and notify producer that status has changed.
            toggleStatusAndNotify();
            return message;

        }

        public synchronized void toggleStatusAndNotify() {
            empty ^= true;
            notifyAll();
        }

        public synchronized void put(String message) {

            // wait until the message has been consumed
            while (!empty) {
                try {
                    wait();
                } catch (Exception e) {
                }
            }

            // set message
            this.message = message;
            // toggle status and notify all consumers.
            toggleStatusAndNotify();
        }

    }

    static class Producer implements Runnable {

        private Drop drop;

        public Producer(Drop drop) {
            this.drop = drop;
        }

        public void run() {
            String importantInfo[] = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too"
            };
            Random random = new Random();

            for (int i = 0;
                 i < importantInfo.length;
                 i++) {
                drop.put(importantInfo[i]);
                try {
                    Thread.sleep(random.nextInt(5000));
                } catch (InterruptedException e) {
                }
            }
            drop.put("DONE");
        }
    }

    static class Consumer implements Runnable {
        private Drop drop;

        public Consumer(Drop drop) {
            this.drop = drop;
        }

        public void run() {
            Random random = new Random();
            for (String message = drop.take();
                 !message.equals("DONE");
                 message = drop.take()) {
                System.out.format("MESSAGE RECEIVED: %s%n", message);
                try {
                    Thread.sleep(random.nextInt(5000));
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static void main(String[] args) {
        Drop drop = new Drop();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }

}
