package idv.java.ccr.threads.example8;

import idv.java.ccr.util.ThreadColor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Carl Lu
 */
public class Main {

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();
        SimpleProducer producer = new SimpleProducer(buffer, ThreadColor.ANSI_CYAN, bufferLock);
        SimpleConsumer consumer1 = new SimpleConsumer(buffer, ThreadColor.ANSI_MAGENTA, bufferLock);
        SimpleConsumer consumer2 = new SimpleConsumer(buffer, ThreadColor.ANSI_YELLOW, bufferLock);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }

}
