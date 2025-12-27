package queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueProducer implements Runnable  {

    BlockingQueue<Integer> queue;
    int itemCount;
    private Random random = new Random();

    public BlockingQueueProducer(BlockingQueue<Integer> queue,int count) {
        this.queue = queue;
        this.itemCount = count;
    }

    @Override
    public void run() {
        try{
            if (itemCount > 0) {
                for(int i = 0; i < itemCount; i++) {
                    int item = random.nextInt(100) + 1;
                    queue.offer(item);
                    System.out.println("Produced----- " + item);
                    System.out.println("Total Produced----- " + (i+1));
                    Thread.sleep(random.nextInt(501),500);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
