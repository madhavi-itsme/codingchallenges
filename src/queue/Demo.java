package queue;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo {

    public static void startArrayBlockingQueue() {
        int itemCount = 20;
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        Thread producerThread = new Thread(new BlockingQueueProducer(queue, itemCount));
        Thread consumerThread = new Thread(new BlockingQueueConsumer(queue, itemCount));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Processing complete.");
    }

    public static void startLinkedBlockingQueue() {
        int itemCount = 200;
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

        Thread producerThread = new Thread(new BlockingQueueProducer(queue, itemCount));
        Thread consumerThread = new Thread(new BlockingQueueConsumer(queue, itemCount));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Processing complete.");
    }

    public static void main(String[] args) {
     Demo.startArrayBlockingQueue();

     Demo.startLinkedBlockingQueue();
    }
}
