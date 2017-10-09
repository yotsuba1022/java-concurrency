package idv.java.ccr.readwritelock.example1;

import java.util.Map;
import java.util.concurrent.locks.Lock;

/**
 * @author Carl Lu
 */
public class Reader implements Runnable {

    private Map<String, String> dictionary;
    private String threadColor;
    private Lock readLock;
    private String[] words;

    Reader(String threadColor, Map<String, String> dictionary, Lock readLock, String[] words) {
        this.threadColor = threadColor;
        this.dictionary = dictionary;
        this.readLock = readLock;
        this.words = words;
    }

    @Override
    public void run() {
        long counter = 0L;
        while (true) {
            readLock.lock();
            try {
                int i = (int) ( Math.random() * words.length );
                System.out.println(threadColor + "Reader accessing " + words[i] + ": " + dictionary.get(words[i]) + " entry.");
                counter++;
            } finally {
                readLock.unlock();
                if (counter > 100L) {
                    break;
                }
            }
        }
    }
}
