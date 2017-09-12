package idv.java.ccr.threads.example19;

import idv.java.ccr.util.ThreadColor;

/**
 * @author Carl Lu
 */
public class Consumer implements Runnable {

    private final SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        char ch;

        do {
            ch = sharedResource.getSharedChar();
            System.out.println(ThreadColor.ANSI_YELLOW + ch + " consumed by consumer.");
        } while (ch != 'Z');
    }
}
