package idv.java.ccr.exchanger.example1;

import java.util.concurrent.Exchanger;

/**
 * @author Carl Lu
 */
public class EmptyingLoop implements Runnable {

    private DataBuffer currentBuffer;
    private Exchanger<DataBuffer> exchanger;

    EmptyingLoop(DataBuffer currentBuffer, Exchanger<DataBuffer> exchanger) {
        this.currentBuffer = currentBuffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            while (true) {
                takeFromBuffer(currentBuffer);
                if (currentBuffer.isEmpty()) {
                    System.out.println("emptying thread wants to exchange");
                    currentBuffer = exchanger.exchange(currentBuffer);
                    System.out.println("emptying thread receives exchange");
                }
            }
        } catch (InterruptedException exception) {
            System.out.println("emptying thread interrupted");
        }
    }

    private void takeFromBuffer(DataBuffer dataBuffer) {
        System.out.println("taking: " + dataBuffer.remove());
    }
}
