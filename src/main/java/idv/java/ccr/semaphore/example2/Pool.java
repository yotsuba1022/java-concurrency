package idv.java.ccr.semaphore.example2;

import java.util.Objects;
import java.util.concurrent.Semaphore;

/**
 * @author Carl Lu
 */
final class Pool {

    static final int MAX_AVAILABLE = 10;
    private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);
    private final String[] items;
    private final boolean[] used = new boolean[MAX_AVAILABLE];

    Pool() {
        items = new String[MAX_AVAILABLE];
        for (int i = 0; i < MAX_AVAILABLE; i++) {
            items[i] = "Item" + i;
        }
    }

    String getItem() throws InterruptedException {
        available.acquire();
        return getNextAvailableItem();
    }

    void putItem(String item) {
        if (markAsUnused(item)) {
            available.release();
        }
    }

    private synchronized String getNextAvailableItem() {
        for (int i = 0; i < MAX_AVAILABLE; i++) {
            if (!used[i]) {
                used[i] = true;
                return items[i];
            }
        }
        return null;
    }

    private synchronized boolean markAsUnused(String item) {
        for (int i = 0; i < MAX_AVAILABLE; i++) {
            if (Objects.equals(item, items[i])) {
                if (used[i]) {
                    used[i] = false;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
