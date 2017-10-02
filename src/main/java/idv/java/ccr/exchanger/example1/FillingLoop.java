package idv.java.ccr.exchanger.example1;

import java.util.concurrent.Exchanger;

/**
 * @author Carl Lu
 */
public class FillingLoop implements Runnable {

    private int count = 0;

    private DataBuffer currentBuffer;
    private Exchanger<DataBuffer> exchanger;

    FillingLoop(DataBuffer currentBuffer, Exchanger<DataBuffer> exchanger) {
        this.currentBuffer = currentBuffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            while (true) {
                addToBuffer(currentBuffer);
                if (currentBuffer.isFull()) {
                    System.out.println("filling thread wants to exchange");
                    currentBuffer = exchanger.exchange(currentBuffer);
                    System.out.println("filling thread receives exchange");
                }
            }
        } catch (InterruptedException e) {
            System.out.println("filling thread interrupted");
        }
    }

    private void addToBuffer(DataBuffer dataBuffer) {
        String item = "NI" + count++;
        System.out.println("Adding: " + item);
        dataBuffer.add(item);
    }
}
