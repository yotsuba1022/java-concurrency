package idv.java.ccr.threads.example5;

/**
 * @author Carl Lu
 */
public class Message {

    private String message;
    private boolean empty = true;

    /*
    *
    * We don't want the reader thread to run while the writer thread is writing a message and vice versa.
    *
    * A thread can be suspended before/after each operation and also while executing the println method itself,
    * so having said that there's a few atomic operations in Java that happen all at once.
    * A thread can't be suspended in the middle of doing them, here are the atomic operations in Java:
    * reading/writing variables, for example: object1 equals object2 would be atomic so with thread it can't be suspended
    * in the middle of executing that statement, also, a thread can't be suspended if reading/writing primitive variables
    * except those of type long and double, so the JVM might require 2 operations to read and write longs and doubles
    * and a thread can be suspended between each operation.
    *
    * e.g:
    * int equals 10       <= can't be suspended
    * double equals 1.234 <= can be suspended
    *
    * Ref: https://stackoverflow.com/questions/517532/writing-long-and-double-is-not-atomic-in-java
    *
    * */
    synchronized String read() {
        while (empty) {
            try {
                /*
                * When invoke wait(), the current thread will go into the wait pool,
                * so the object lock will be released and the write method can be executed.
                * */
                wait();
            } catch (InterruptedException e) {

            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    synchronized void write(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }

}
