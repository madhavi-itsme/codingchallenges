package LinkedList;

/*
*
* */
public class ReverseKGroups {

    public static LinkedListNode reverseKGroups(LinkedListNode head, int k) {
        if (head == null || k <= 1) return head;

        LinkedListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Dummy node to simplify head handling
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;
        LinkedListNode prevGroupEnd = dummy;

        while (count >= k){
            LinkedListNode prev = null;
            LinkedListNode curr = prevGroupEnd.next;
            LinkedListNode next = null;
            LinkedListNode groupStart = curr; // Start of the current group

            // Reverse k nodes
            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect previous group's end to new reversed head
            prevGroupEnd.next = prev;
            groupStart.next = curr;  // Connect reversed group to remaining nodes
            prevGroupEnd = groupStart;

            count -= k;
        }

        return dummy.next;
        }

    public static void main(String[] args){
        LinkedList<Integer> list=new LinkedList<Integer>();
        list.createLinkedList(new int[]{1,2,3,4,5});

        LinkedListNode head=list.head;
        LinkedListTraversal.traverseLinkedList(head);
        System.out.println("---------------------------");
        LinkedListTraversal.traverseLinkedList(ReverseKGroups.reverseKGroups(head,2));
        System.out.println("---------------------------");
    }
}

