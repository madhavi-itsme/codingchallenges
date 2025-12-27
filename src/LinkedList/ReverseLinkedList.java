package LinkedList;


public class ReverseLinkedList {
    public static LinkedListNode reverse(LinkedListNode head, int k ) {

        // Replace this placeholder return statement with your code
        LinkedListNode curr=head;
        LinkedListNode prev=null;
        LinkedListNode lastNode=head;
        for(int i=0;i<k;i++){
            LinkedListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        lastNode.next=curr;
        head = prev;
        return head;
    }

public static void main(String[] args){
        LinkedList<Integer> list=new LinkedList<Integer>();
        list.createLinkedList(new int[]{1,2,3,4,5});

        LinkedListNode head=list.head;
        LinkedListTraversal.traverseLinkedList(head);
       System.out.println("---------------------------");
       LinkedListTraversal.traverseLinkedList(ReverseLinkedList.reverse(head,2));
       System.out.println("---------------------------");
}
}
