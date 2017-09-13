package idv.java.ccr.threads.example20;

/**
 * @author Carl Lu
 */
public class SharedResource {

    private char c;
    private volatile boolean writeable = true;

    synchronized char getSharedChar() {
        while (writeable) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        writeable = true;
        notify();
        return c;
    }

    synchronized void setSharedChar(char c) {
        while (!writeable) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }

        this.c = c;
        writeable = false;
        notify();

    }

}
