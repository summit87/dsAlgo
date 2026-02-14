package MinMaxHeap;

public class MinHeap {

    public static void main(String[] args) {
        BuildMinHeap bmh = new BuildMinHeap(10);
        bmh.insert(10);
        bmh.insert(4);
        bmh.insert(8);
        bmh.insert(90);
        bmh.insert(81);
        bmh.insert(20);
        bmh.insert(-8);
        bmh.insert(0);
        bmh.insert(5);
        //bmh.update(1, -10);
        System.out.println(bmh.extractMin());
        System.out.println(bmh.extractMin());
        System.out.println(bmh.extractMin());
        System.out.println(bmh.extractMin());
        System.out.println(bmh.extractMin());
        System.out.println(bmh.extractMin());
    }
}

class BuildMinHeap {

    private int[] arr;
    private int capacity;
    private int size;

    public BuildMinHeap(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size = 0;
    }

    private int parent(int i) {
        return (i) / 2;
    }

    private int leftChild(int i) {
        return 2 * i;
    }

    private int rightChild(int i) {
        return 2 * i + 1;
    }

    private void heapify(int i) {
        int li = leftChild(i);
        int ri = rightChild(i);
        int minIndex = i;
        if (li < this.size && this.arr[li] < this.arr[minIndex]) {
            minIndex = li;
        }
        if (ri < this.size && this.arr[ri] < this.arr[minIndex]) {
            minIndex = ri;
        }

        if (minIndex != i) {
            int temp = this.arr[minIndex];
            this.arr[minIndex] = this.arr[i];
            this.arr[i] = temp;
            heapify(minIndex);
        }
    }

    public void insert(int val) {
        if (this.size > this.capacity) {
            return;
        }
        if (this.size < 0) {
            return;
        }
        this.arr[this.size] = val;
        int k = this.size;
        this.size++;
        while (k != 0 && this.arr[parent(k)] > this.arr[k]) {
            int temp = this.arr[k];
            this.arr[k] = this.arr[parent(k)];
            this.arr[parent(k)] = temp;
            k = parent(k);
        }
    }

    public int getMin() {
        return this.arr[0];
    }

    public int extractMin() {

        if (this.size <= 0) {
            throw new RuntimeException("Invalid request");
        }
        if (this.size == 1) {
            this.size = this.size - 1;
            return this.arr[0];
        }
        int minVal = this.arr[0];
        this.arr[0] = this.arr[size - 1];
        this.size = this.size - 1;
        heapify(0);
        return minVal;
    }

    public void update(int index, int val) {
        if (index > this.capacity || this.size < index) {
            throw new RuntimeException("Invalid exception");
        }

        this.arr[index] = val;
        while (index != 0 && this.arr[parent(index)] > this.arr[index]) {
            int temp = this.arr[index];
            this.arr[index] = this.arr[parent(index)];
            this.arr[parent(index)] = temp;
            index = parent(index);
        }
    }

}
