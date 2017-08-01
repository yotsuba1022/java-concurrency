package idv.java.ccr.threads.example5;

import java.util.Random;

/**
 * @author Carl Lu
 */
public class Reader implements Runnable {

    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (String latestMsg = message.read(); !latestMsg.equals("Finished"); latestMsg = message.read()) {
            System.out.println(latestMsg);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println("Oops!!!");
            }
        }
    }
}
