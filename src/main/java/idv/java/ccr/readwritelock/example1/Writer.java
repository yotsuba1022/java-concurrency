package idv.java.ccr.readwritelock.example1;

import java.util.Map;
import java.util.concurrent.locks.Lock;

/**
 * @author Carl Lu
 */
public class Writer implements Runnable {

    private Map<String, String> dictionary;
    private String threadColor;
    private Lock writeLock;
    private String[] words;
    private String[] definitions;

    Writer(String threadColor, Lock writeLock, Map<String, String> dictionary, String[] words, String[] definitions) {
        this.threadColor = threadColor;
        this.writeLock = writeLock;
        this.dictionary = dictionary;
        this.words = words;
        this.definitions = definitions;
    }

    @Override
    public void run() {

        for (int i = 0; i < words.length; i++) {
            writeLock.lock();
            try {
                dictionary.put(words[i], definitions[i]);
                System.out.println(threadColor + "Writer storing " + words[i] + " entry.");
            } finally {
                writeLock.unlock();
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException ignored) {
            }
        }

    }
}
