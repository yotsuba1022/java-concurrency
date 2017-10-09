package idv.java.ccr.condition.example1;

import idv.java.ccr.util.ThreadColor;

/**
 * @author Carl Lu
 */
public class ConditionDemo {

    public static void main(String[] args) {
        Shared shared = new Shared();
        new Thread(new Producer(ThreadColor.ANSI_CYAN, shared)).start();
        new Thread(new Consumer(ThreadColor.ANSI_MAGENTA, shared)).start();
    }

}
