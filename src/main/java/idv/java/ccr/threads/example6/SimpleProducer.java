package idv.java.ccr.threads.example6;

import java.util.List;
import java.util.Random;

/**
 * @author Carl Lu
 */
public class SimpleProducer implements Runnable {

    private final List<String> buffer;
    private String color;

    SimpleProducer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] inputs = {"1", "2", "3", "4", "5", "6", "7"};

        for (String input : inputs) {
            try {
                System.out.println(color + "Adding..." + input);
                synchronized (buffer) {
                    buffer.add(input);
                }
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println(color + "Producer was interrupted.");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        synchronized (buffer) {
            buffer.add("EOF");
        }
    }

}
