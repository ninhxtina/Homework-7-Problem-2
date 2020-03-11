/** (https://www.geeksforgeeks.org/building-heap-from-array/)
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
    }

    // add an item to the heap
    public boolean add(Integer item) {
        // homework
        return false;
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


}
