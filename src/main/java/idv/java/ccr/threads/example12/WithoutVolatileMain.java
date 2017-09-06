package idv.java.ccr.threads.example12;

/**
 * @author Carl Lu
 */
public class WithoutVolatileMain {

    /*
    * You might not see this stoppage on a
    * multiprocessor machine or a uniprocessor machine with multiple cores where each
    * processor or core probably has its own cache with its own copy of stopped. When one
    * thread modifies its copy of this field, the other thread’s copy of stopped isn’t changed.
    * */
    public static void main(String[] args) {

        class StoppableThread extends Thread {
            private boolean stopped;

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
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }

        thd.stopThread();

    }
}


