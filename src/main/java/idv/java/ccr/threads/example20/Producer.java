package idv.java.ccr.threads.example20;

import idv.java.ccr.util.ThreadColor;

/**
 * @author Carl Lu
 */
public class Producer implements Runnable {

    private final SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            synchronized (sharedResource) {
                sharedResource.setSharedChar(ch);
                System.out.println(ThreadColor.ANSI_CYAN + ch + " produced by producer.");
            }
        }
    }
}
