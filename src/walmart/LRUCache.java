package walmart;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private final int capacity;
    private final Map<Integer, Node> cacheMap;
    private  final Node head;
    private final Node tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new java.util.HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.Next = tail;
        tail.prev = head;
    }

    public void put(int key, int value){
        if(cacheMap.get(key)!=null){
            Node node=cacheMap.get(key);
            node.value=value;
            moveToHead(node);
        } else {
            Node newNode=new Node(key, value);
            cacheMap.put(key,newNode);
            addNode(newNode);

            if(cacheMap.size() > capacity){
              Node tailNode=tailNode();
              cacheMap.remove(tailNode.key);
            }
        }
    }

    public int get(int key){
        if(cacheMap.get(key) !=null){
            Node node=cacheMap.get(key);
            moveToHead(node); // to address this node is being accessed
            return node.value;
        } else {
            return -1;
        }
    }

    public void moveToHead(Node node){
        removeTailNode(node);
        addNode(node);
    }

    public void addNode(Node node){
        node.prev=head;
        node.Next=head.Next;

        head.Next.prev=node;
        head.Next=node;
    }
    public void removeTailNode(Node node){
        Node prevNode=node.prev;
        Node nextNode=node.Next;

        prevNode.Next=nextNode;
        nextNode.prev=prevNode;
    }

    public Node tailNode(){
        Node node=tail.prev;
        removeTailNode(node);
        return node;
    }
}
