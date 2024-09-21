package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargestElement {

    public static void main(String[] args) {
        int[] a = {9, 4, 1, 8, 5, 2, 1, 90, 78, 45, 1232};
        MaxHeap mx = new MaxHeap(a.length);
        for (int i = 0; i < a.length; i++) {
            mx.insert(a[i]);
        }

       for(int k = 0;k<3;k++){
        System.out.println(mx.extract());
       }
    }

    private static void findKthLargestElementUsingPQ(int[] a) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < a.length; i++) {
            pq.add(a[i]);
        }

        for (int k = 0; k < 5; k++) {
            System.out.println(pq.poll());
        }
    }
}

class MaxHeap {

    private int[] arr;
    private int capacity;
    private int size;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[capacity];
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int leftChild(int i) {
        return 2 * i + 1;
    }

    public int rightChild(int i) {
        return 2 * i + 2;
    }

    public void heapify(int i) {
        int leftChild = leftChild(i);
        int rightChild = rightChild(i);
        int ind = i;
        if (leftChild < this.size && this.arr[ind] < this.arr[leftChild]) {
            ind = leftChild;
        }

        if (rightChild < this.size && this.arr[ind] < this.arr[rightChild]) {
            ind = rightChild;
        }

        if (ind != i) {
            int temp = this.arr[ind];
            this.arr[ind] = this.arr[i];
            this.arr[i] = temp;
            heapify(ind);
        }
    }

    public void insert(int val) {
        if (this.size >= this.capacity) {
            throw new RuntimeException("NO more space");
        }

        this.arr[this.size] = val;
        int k = this.size;
        this.size = this.size + 1;
        while (k <= this.size && this.arr[parent(k)] < this.arr[k]) {
            int temp = this.arr[parent(k)];
            this.arr[parent(k)] = this.arr[k];
            this.arr[k] = temp;
            k = parent(k);
        }
    }

    public int extract() {
        int val = this.arr[0];
        this.arr[0] = this.arr[this.size - 1];
        this.size = this.size - 1;
        heapify(0);
        return val;
    }

    public void update(int val, int x) {
        this.arr[x] = val;

        while (x <= this.size && this.arr[parent(x)] < this.arr[x]) {
            int temp = this.arr[parent(x)];
            this.arr[parent(x)] = this.arr[x];
            this.arr[x] = temp;
            x = parent(x);
        }
    }

}
