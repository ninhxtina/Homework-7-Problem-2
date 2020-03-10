/**
 * (https://medium.com/@ankur.singh4012/implementing-max-heap-in-java-ea368dadd273)
 */

import java.util.Arrays;

public class MaxHeap implements Heap {
    int capacity;
    int size;

    Integer[] data;

    public MaxHeap(int size) {
        this.size = size;
        data = new Integer[size];
    }

    //getters & setters
    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex -1) /2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int parentIndex) {
        return data[getLeftChildIndex(parentIndex)];
    }

    private int rightChild(int parentIndex) {
        return data[getRightChildIndex(parentIndex)];
    }

    private int parent(int childIndex) {
        return data[getParentIndex(childIndex)];
    }

    private void swap(int index1, int index2) {
        int element = data[index1];
        data[index1] = data[index2];
        data[index2] = element;
    }

    // build a heap based on data
    // to be implemented in O(nlogn)
    public void MaxHeapLogN(Integer[] data) {
        // homework
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {
        // homework
    }

    // add an item to the heap
    public boolean add(Integer item) {
        // homework
        ensureCapacity();
        data[size] = item;
        size++;
        heapifyUp();
        return false;
    }

    private void ensureCapacity() {
        if(size == capacity) {
            data = Arrays.copyOf(data,capacity * 2);
            capacity = capacity * 2;
        }
    }

    private void heapifyUp() {
        int index = size - 1;
        while(hasParent(index) && parent(index) < data[index]) {
            swap(getParentIndex(index),index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)) {
            int smallestChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallestChildIndex = getRightChildIndex(index);
            }
            if(data[index] < data[smallestChildIndex]) {
                swap(index,smallestChildIndex);
            } else {
                break;
            }
            index = smallestChildIndex;
        }
    }
    // return the max item in the heap
    public Integer get() {
        // homework
        return null;
    }

    // remove the root item
    public Integer pop() {
        // homework
        return null;
    }


}
