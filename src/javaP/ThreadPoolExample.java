package javaP;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
    public static void main(String[] args) {
        extracted();
    }

    private static void extracted() {
        // ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10, 1,
        // TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        ThreadPoolExecutor executor1 = new ThreadPoolExecutor(2, 10, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100), new ThreadPoolExecutor.CallerRunsPolicy());
        int id = 0;
        while (true) {
            executor1.execute(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
            if (id % 100 == 0) {
                System.out.printf(
                        "Submitted=%d | Pool=%d | Active=%d | Queue=%d | InProgress=%d | Completed=%d%n",
                        id,
                        executor1.getPoolSize(),
                        executor1.getActiveCount(),
                        executor1.getQueue().size(),executor1.getActiveCount(),executor1.getCompletedTaskCount());
            }
            id++;
        }
    }
}
