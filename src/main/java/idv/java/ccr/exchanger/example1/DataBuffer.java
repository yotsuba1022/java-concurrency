package idv.java.ccr.exchanger.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carl Lu
 */
public class DataBuffer {

    private final static int MAXITEMS = 10;

    private final List<String> items = new ArrayList<>();

    public DataBuffer() {
    }

    public DataBuffer(String prefix) {
        for (int i = 0; i < MAXITEMS; i++) {
            String item = prefix + i;
            System.out.printf("Adding %s%n", item);
            items.add(item);
        }
    }

    public synchronized void add(String s) {
        if (!isFull()) {
            items.add(s);
        }
    }

    public synchronized boolean isEmpty() {
        return items.isEmpty();
    }

    public synchronized boolean isFull() {
        return items.size() == MAXITEMS;
    }

    public synchronized String remove() {
        if (!isEmpty()) {
            return items.remove(0);
        } else {
            return null;
        }
    }
}
