package queue;

import java.util.LinkedList;
import java.util.Queue;

public class BoundedBlockingQueue {
    public final Queue<Integer> queue=new LinkedList<>();
    private int capacity;

    public BoundedBlockingQueue(int capacity){
        this.capacity=capacity;
    }

    public synchronized  void enque(int item) throws InterruptedException {
        while(queue.size() == capacity){
            wait();
        }
        queue.offer(item);
        notifyAll();
    }

    public synchronized  int deque() throws InterruptedException {
        while(queue.isEmpty()){
            wait();
        }

        int item=queue.poll();

        notifyAll();
        return item;

    }

    public synchronized int size(){
        return queue.size();
    }

    public static void main(String[] args) {
        BoundedBlockingQueue queue = new BoundedBlockingQueue(2);

        // producer
        new Thread(() -> {
            try{
                queue.enque(1);
                queue.enque(2);
                queue.enque(3);
                queue.enque(4);

        } catch(Exception e){
                Thread.currentThread().interrupt();
            }}).start();

        // consumer

        new Thread(() -> {
            try{
                Thread.sleep(1000);
                System.out.println(queue.deque());
                System.out.println(queue.deque());

            } catch(Exception e){
                Thread.currentThread().interrupt();
            }}).start();

    }
}
