package idv.java.ccr.readwritelock.example1;

import idv.java.ccr.util.ThreadColor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Carl Lu
 */
public class Dictionary {

    public static void main(String[] args) {
        final String[] words = {"hypocalcemia", "prolixity", "assiduous", "indefatigable", "castellan"};

        final String[] definitions = {"a deficiency of calcium in the blood", "unduly prolonged or drawn out",
                "showing great care, attention, and effort", "able to work or continue for a lengthy time without tiring",
                "the govenor or warden of a castle or fort"};

        final Map<String, String> dictionary = new HashMap<>();

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
        final Lock readLock = readWriteLock.readLock();
        final Lock writeLock = readWriteLock.writeLock();

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new Writer(ThreadColor.ANSI_CYAN, writeLock, dictionary, words, definitions));
        executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new Reader(ThreadColor.ANSI_MAGENTA, dictionary, readLock, words));
    }

}
