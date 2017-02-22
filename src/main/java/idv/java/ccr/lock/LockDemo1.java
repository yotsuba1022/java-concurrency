package idv.java.ccr.lock;

import java.util.Random;

/**
 * @author Carl Lu
 */
public class LockDemo1 {

    public static void main(String args[]) {
        final Guy joy = new Guy("JOY");
        final Guy yoo = new Guy("YOO");
        new Thread(new TalkingLoop(joy, yoo)).start();
        new Thread(new TalkingLoop(yoo, joy)).start();
    }

    static class TalkingLoop implements Runnable {
        private Guy guy1;
        private Guy guy2;

        public TalkingLoop(Guy guy1, Guy guy2) {
            this.guy1 = guy1;
            this.guy2 = guy2;
        }

        @Override
        public void run() {
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(random.nextInt(5));
                } catch (InterruptedException e) {

                }

                guy2.talking(guy1);
            }
        }
    }
}
