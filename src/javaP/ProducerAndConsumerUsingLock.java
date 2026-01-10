package javaP;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumerUsingLock {
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        pc.producer(10);
        pc.consumer();
    }
}

class ProducerConsumer{

    private ReentrantLock lock = new ReentrantLock();
    private Condition producerWait = lock.newCondition();
    private Condition consumerWait = lock.newCondition();
    private boolean  hasData = false;
    private int val;

    public void producer(int val){
        lock.tryLock();
        try {
           while(hasData){
                producerWait.await(); // producer will wait 
           }
           System.out.println("Producer produces : "+val);
           hasData = true;
           this.val = val;
           Thread.sleep(3000);
           consumerWait.signalAll();
        } catch (Exception e) {
            Thread.interrupted();
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void consumer(){
        lock.tryLock();
        try {
            while(!hasData){
                consumerWait.await();
            }
            hasData = !hasData;
            System.out.println("Consumer consume "+this.val);
            producerWait.signal();

        } catch (Exception e) {
        }finally{
            System.out.println("Consumer is unlock");
            lock.unlock();

        }
    }

}
