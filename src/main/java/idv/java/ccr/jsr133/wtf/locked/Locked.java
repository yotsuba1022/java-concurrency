package idv.java.ccr.jsr133.wtf.locked;

/**
 * @author Carl Lu
 */
public class Locked {

    private static boolean flag = false;

    public static void main(String args[]) throws InterruptedException {
        new Thread(() -> {
            while (!flag) {

            }
            System.out.println("Thread done.");
        }).start();

        Thread.sleep(1000);
        flag = true;

        System.out.println("Finished.");
    }

}
