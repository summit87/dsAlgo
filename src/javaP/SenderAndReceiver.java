package javaP;

public class SenderAndReceiver {
    public static void main(String[] args) {
        DataEmitter dataEmitter = new DataEmitter();
        Thread sender = new Thread(new Sender(dataEmitter));
        Thread receiver = new Thread(new Receiver(dataEmitter));
        sender.start();
        receiver.start();
    }
}

class Sender implements Runnable {

    String[] data1 = { "Send", "received", "send", "received", "send", "received" };
    private DataEmitter data;

    public Sender(DataEmitter data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (String s : data1) {
            try {
                data.send(s);
                Thread.sleep(3000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}

class Receiver implements Runnable {

    private DataEmitter dataEmitter;

    public Receiver(DataEmitter dataEmitter) {
        this.dataEmitter = dataEmitter;
    }

    @Override
    public void run() {
        try {
            System.out.println("Rece " + dataEmitter.receiver());
            //Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class DataEmitter {

    private Data data;
    private boolean isDataAviable = false;

    public DataEmitter() {
        data = new Data();
    }

    public synchronized void send(String val) throws InterruptedException {
        while (!isDataAviable) {
            try {
                wait();
            } catch (Exception ex) {
                Thread.currentThread().interrupt();
                ex.printStackTrace();
            }
        }
        isDataAviable = true;
        data.setDate(val);
        notifyAll();

    }

    public synchronized String receiver() throws InterruptedException {
        while (isDataAviable) {
            try {
                wait();
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

        isDataAviable = false;
        notifyAll();
        return data.getData();
    }

}

class Data {
    private String data;

    public void setDate(String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }
}
