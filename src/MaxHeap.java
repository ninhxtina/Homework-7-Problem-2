/** (https://www.geeksforgeeks.org/building-heap-from-array/)
 * (https://medium.com/@ankur.singh4012/implementing-max-heap-in-java-ea368dadd273)
 * (https://www.geeksforgeeks.org/insertion-and-deletion-in-heaps/)
 * (https://stackoverflow.com/questions/26092001/inserting-item-into-a-max-heap)
 */

import java.util.Arrays;

public class MaxHeap implements Heap {

    int size;

    Integer[] data;

    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }

    // build a heap based on data
    // to be implemented in O(nlogn)
    public void MaxHeapLogN(Integer[] data) {
        // homework
        int n = data.length;
        //index of last non-leaf node
        int start = (n/2) -1;

        //perform reverse level order traversal from
        //last non-leaf node and heapify each node
        for(int i = start;i>=0;i--) {
            heapify(data,n,i);
        }
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {
        // homework
        for(int i = data.length / 2; i >= 0; i--) {
            heapifyDown();
        }

    }

    // add an item to the heap
    public boolean add(Integer item) {
        // homework
        data[0] = item;
        int i = 0;
        int temp;
        int parent;
        while(i > 0) {
            parent = getParent(i);

            if(data[parent] < data[i]) {
                temp = data[parent];
                data[parent] = data[i];
                data[i] = temp;
                return true;
            } else {
                return false;
            }
        }
        return true;

    }


    // return the max item in the heap
    public Integer get() {
        // homework
        if(size == 0) {
            return null;
        }
        return data[0];
    }

    // remove the root item
    public Integer pop() {
        // homework
        if(size == 0) {
            return null;
        }
        int n = data.length;

        //get last element
        int lastElement = data[n-1];

        //replace root with first element
        data[0] = lastElement;

        //decrease size of heap by 1
        n = n-1;

        //heapify the root node
        heapify(data,n,0);

        return n;
    }

    private void heapify(Integer arr[], int n, int i) {
        int largest = i; //initalize largest as root
        int l = 2 * i + 1; //left = 2*i + 1
        int r = 2 * i + 2; //right = 2*i + 2

        //if left child is larger than root
        if(l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        //if right child is larger than largest
        if(r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        //if largest is not root
        if(largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
        }
        //recursively heapify the affected sub-tree
        heapify(arr,n,largest);
    }

    private void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)) {
            int smallestChild = getLeftChild(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallestChild = getRightChild(index);
            }
            if (data[index] < data[smallestChild]) {
                swap(index, smallestChild);
            } else {
                break;
            }
            index = smallestChild;
        }
    }

    private void heapifyUp() {
        int index = size -1;
        while(hasParent(index) && parent(index) < data[index]) {
            swap(getParent(index),index);
            index = getParent(index);
        }
    }

    //gets parents index
    private int getParent(int index) {
        return (index - 1) / 2;
    }

    //gets left child index
    private int getLeftChild(int index) {
        return 2*index+1;
    }

    //gets right child index
    private int getRightChild(int index) {
        return 2*index+2;
    }

    private boolean hasLeftChild (int index) {
        return getLeftChild(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChild(index) < size;
    }

    private boolean hasParent(int index) {
        return getParent(index) >= 0;
    }

    private int leftChild(int index) {
        return data[getLeftChild(index)];
    }

    private int rightChild(int index) {
        return data[getRightChild(index)];
    }

    private int parent(int index) {
        return data[getParent(index)];
    }

    private void swap(int index1, int index2) {
        int element = data[index1];
        data[index1] = data[index2];
        data[index2] = element;
    }

}
