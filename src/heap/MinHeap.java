package heap;

import java.util.ArrayList;
import java.util.Arrays;

public class MinHeap {

    private ArrayList<Integer> heap;

    // Constructor to initialize the heap
    public MinHeap() {
        heap = new ArrayList<>();
    }

    public void insert(int value) {
       heap.add(value);
        int currentIndex = (heap.size() - 1);
        System.out.println("currentIndex"+currentIndex);

        if(currentIndex > 0 && heap.get(currentIndex) < heap.get(parent(currentIndex - 1))) {
            swap(currentIndex, parent(currentIndex));
            System.out.println("currentIndex"+currentIndex+" : parent"+parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    // Swaps the elements at indices i and j
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Returns the index of the left child node
    private int leftChild(int index) {
        return (2 * index + 1);
    }

    // Returns the index of the right child node
     private int rightChild(int index) {
        return (2 * index +2 );
     }


    public int extractMin() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        // The Minimum value is at the root
        int min = heap.get(0);

        // Remove the last element
        int lastElement = heap.remove(heap.size() - 1);


        if (!heap.isEmpty()) {
            heap.set(0, min);
            int currentIndex = 0;
            while (currentIndex < heap.size()) {
                int left = leftChild(currentIndex);
                int right = rightChild(currentIndex);
                int smallest = currentIndex;


                // Find the largest value among current, left child, and right child
                if (left < heap.size() && heap.get(left) > heap.get(smallest)) {
                    smallest = left;
                }
                if (right < heap.size() && heap.get(right) > heap.get(smallest)) {
                    smallest = right;
                }

                if (smallest == currentIndex) {
                    // Heap property is restored
                    break;
                }

                // Swap with the smallest child
                swap(currentIndex, smallest);

                // Move down to the smallest child's index
                currentIndex = smallest;
            }
        }
        // Return the minimum value
     return min;
    }

    // Checks if the heap is empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public static void main(String[] args) {
        MinHeap heap1=new MinHeap();
        heap1.insert(10);
        System.out.println(Arrays.toString(heap1.heap.toArray()));
        heap1.insert(5);
        System.out.println(Arrays.toString(heap1.heap.toArray()));

        heap1.insert(15);
        System.out.println(Arrays.toString(heap1.heap.toArray()));

        heap1.insert(20);
        System.out.println(Arrays.toString(heap1.heap.toArray()));

        heap1.insert(25);
        System.out.println(Arrays.toString(heap1.heap.toArray()));

        // Extract and print the maximum values from the heap
        System.out.println("Extracted Min: " + heap1.extractMin());
        System.out.println("Extracted Min: " + heap1.extractMin());
    }
}
