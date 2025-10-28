package javaP;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceWithRunnable {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        es.execute(new MRunnable());
        es.submit(new MRunnable());
        es.shutdown();
    }
}

class MRunnable implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println("Executing "+MRunnable.class.getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            
        }
    }
        
}
