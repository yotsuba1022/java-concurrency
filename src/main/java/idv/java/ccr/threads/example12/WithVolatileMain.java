package idv.java.ccr.threads.example12;

/**
 * @author Carl Lu
 */
public class WithVolatileMain {

    /*
    * Because stopped has been marked volatile, each thread will access the main
    * memory copy of this variable and not access a cached copy. The application will stop,
    * even on a multiprocessor-based or a multicore-based machine.
    * */
    public static void main(String[] args) {
        class StoppableThread extends Thread {
            private volatile boolean stopped; // defaults to false

            @Override
            public void run() {
                while (!stopped)
                    System.out.println("running");
            }

            void stopThread() {
                stopped = true;
            }
        }
        StoppableThread thd = new StoppableThread();
        thd.start();
        try {
            Thread.sleep(1000); // sleep for 1 second
        } catch (InterruptedException ie) {
        }
        thd.stopThread();
    }
}
