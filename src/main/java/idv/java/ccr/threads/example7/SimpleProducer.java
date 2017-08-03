package idv.java.ccr.threads.example7;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Carl Lu
 */
public class SimpleProducer implements Runnable {

    private final List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    SimpleProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] inputs = {"1", "2", "3", "4", "5", "6", "7"};

        for (String input : inputs) {
            try {
                System.out.println(color + "Adding..." + input);
                bufferLock.lock();
                buffer.add(input);
                bufferLock.unlock();
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println(color + "Producer was interrupted.");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        bufferLock.lock();
        buffer.add("EOF");
        bufferLock.unlock();
    }

}
