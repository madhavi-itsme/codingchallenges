package queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueConsumer implements Runnable {
    private BlockingQueue<Integer> queue;
    private int itemCount;
    private Random random = new Random();

    public BlockingQueueConsumer(BlockingQueue<Integer> queue,int itemCount) {
        this.queue = queue;
        this.itemCount = itemCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < itemCount; i++) {
                int item = queue.take();
                System.out.println("Consumed: " + item);
                Thread.sleep(random.nextInt(301) + 300);
                // 300 to 600 ms
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
