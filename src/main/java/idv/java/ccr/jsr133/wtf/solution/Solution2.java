package idv.java.ccr.jsr133.wtf.solution;

/**
 * @author Carl Lu
 */
public class Solution2 {

    private static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!flag) {
                    synchronized (this) {
                    }
                }
                System.out.println("Thread done.");
            }
        }).start();

        Thread.sleep(1000);
        flag = true;

        System.out.println("Finished.");
    }

}
