package javaP;

public class BoundedBufferExample {

    public static void main(String[] args) {
        BoundedBuffer<String> b = new BoundedBuffer<>(3);
        b.put("abj");
        b.put("cde");
        b.put("fgh");
        b.put("asd");
        System.out.println(b.pull());
    }
}

class BoundedBuffer<T> {

    private final Object[] object;
    private int size;
    int count = 0;

    public BoundedBuffer(int size) {
        object = new Object[size];
    }

    public synchronized void put(T t) {
        try {
            while (isFull()) {
                wait();
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        add(t);
        notifyAll();
    }

    public synchronized T pull() {
        try {
            while (this.object.length <= 0) {
                wait();
            }
        } catch (InterruptedException iex) {
            iex.printStackTrace();
        }
        T ele = take();
        notifyAll();
        return ele;
    }

    private synchronized boolean isFull() {
        if (count == this.object.length) {
            throw new RuntimeException("NO space to add");
        }
        return count == this.object.length;
    }

    private synchronized void add(T t) {
        if (count == this.object.length) {
            count = 0;
        }
        this.object[count] = t;
        count++;
    }

    private T take() {
        if (this.object.length <= 0) {
            throw new RuntimeException("No item found");
        }
        return (T) this.object[--count];
    }
}
