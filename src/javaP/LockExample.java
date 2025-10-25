package javaP;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * We will be using lock provided in java cocurrency to simulate printer job ,
 * Use case : 1. I have 1o printer and each printer will be using same lock
 * object to print the job 2. all the printer should work sequencially
 */
public class LockExample {

    public static void main(String[] args) {
        PrinterQueue printerQueue = new PrinterQueue();
        Thread[] threads = new Thread[10];
        for(int i=1;i<=10;i++){
            threads[i-1] = new Thread(new PrinterJob(printerQueue, String.format("Printer - %d", i)));
        }

        for(Thread t : threads){
            t.start();
        }
    }
}

class PrinterJob implements Runnable {

    PrinterQueue printerQueue;
    String printerName;

    public PrinterJob(PrinterQueue printerQueue,String printerName) {
        this.printerQueue = printerQueue;
        this.printerName = printerName;
    }

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void run() {
        try {
            printerQueue.printJob(this.printerName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class PrinterQueue {

    Lock lock = new ReentrantLock();

    public void printJob(String printerName) {
        lock.lock();
        try {
            System.out.println(String.format("Print job started for the printer %s", printerName));
            System.out.println("Something printing for printer : " + printerName);
            Thread.sleep(3000);

        } catch (InterruptedException e) {
        } finally {
            System.out.println(String.format("Print job finished for the printer %s", printerName));
            lock.unlock();
        }
    }

}
