package idv.java.ccr.exchanger.example1;

import java.util.concurrent.Exchanger;

/**
 * @author Carl Lu
 */
public class ExchangerDemo {

    private final static Exchanger<DataBuffer> exchanger = new Exchanger<>();
    private final static DataBuffer initialFullBuffer = new DataBuffer("I");
    private final static DataBuffer initialEmptyBuffer = new DataBuffer();

    public static void main(String[] args) {
        new Thread(new FillingLoop(initialEmptyBuffer, exchanger)).start();
        new Thread(new EmptyingLoop(initialFullBuffer, exchanger)).start();
    }

}
