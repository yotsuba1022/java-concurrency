package idv.java.ccr.threads.example6;

import java.util.List;

/**
 * @author Carl Lu
 */
public class SimpleConsumer implements Runnable {

    private final List<String> buffer;
    private String color;

    SimpleConsumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals("EOF")) {
                    System.out.println(color + "Exiting...");
                    break;
                } else {
                    System.out.println(color + "Removed: " + buffer.remove(0));
                }
            }
        }
    }

}
