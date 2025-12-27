package LinkedList;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKListsMain {

    public static LinkedListNode mergeKLists(List<LinkedListNode> lists) {
        if (lists == null || lists.isEmpty()) return null;

        // Min-Heap to store the smallest element from each list
        PriorityQueue<LinkedListNode> minHeap = new PriorityQueue<>((a, b) -> a.data - b.data);

        // Add the head of each list to the minHeap
        for (LinkedListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        LinkedListNode dummy = new LinkedListNode(-1);
        LinkedListNode tail = dummy;

        while (!minHeap.isEmpty()) {
            LinkedListNode minNode = minHeap.poll();
            tail.next = minNode;
            tail = tail.next;

            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }

        return dummy.next;
    }
    public static void main(String[] args) {
         LinkedListNode head1 = new LinkedListNode(11);
         head1.next = new LinkedListNode(22);
         head1.next.next = new LinkedListNode(43);
         head1.next.next.next = new LinkedListNode(33);
         head1.next.next.next.next = new LinkedListNode(15);
         head1.next.next.next.next.next = new LinkedListNode(26);
         head1.next.next.next.next.next.next = new LinkedListNode(37);

         LinkedListNode head2 = new LinkedListNode(42);
         head2.next = new LinkedListNode(93);
         head2.next.next = new LinkedListNode(04);
         head2.next.next.next = new LinkedListNode(85);
         head2.next.next.next.next = new LinkedListNode(96);
         head2.next.next.next.next.next = new LinkedListNode(77);
         head2.next.next.next.next.next.next = new LinkedListNode(98);
         head2.next.next.next.next.next.next.next = new LinkedListNode(19);
         head2.next.next.next.next.next.next.next.next = new LinkedListNode(10);
         LinkedListNode lists = MergeKListsMain.mergeKLists(Arrays.asList(head1, head2));


    }
}
