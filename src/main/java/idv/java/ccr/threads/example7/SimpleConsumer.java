package idv.java.ccr.threads.example7;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Carl Lu
 */
public class SimpleConsumer implements Runnable {

    private final List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    SimpleConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        while (true) {
            bufferLock.lock();
            if (buffer.isEmpty()) {
                bufferLock.unlock();
                continue;
            }
            if (buffer.get(0).equals("EOF")) {
                System.out.println(color + "Exiting...");
                bufferLock.unlock();
                break;
            } else {
                System.out.println(color + "Removed: " + buffer.remove(0));
            }
            bufferLock.unlock();
        }
    }

}
