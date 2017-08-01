package idv.java.ccr.threads.example5;

import idv.java.ccr.util.ThreadColor;

import java.util.Random;

/**
 * @author Carl Lu
 */
public class Writer implements Runnable {

    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String messages[] = {ThreadColor.ANSI_CYAN + "For shizzle my nizzle!", ThreadColor.ANSI_MAGENTA + "Que pa so!",
                ThreadColor.ANSI_YELLOW + "Yo~yo~我南部阿肥喇!", ThreadColor.ANSI_GREEN + "窩是魯蛇~"};

        Random random = new Random();

        for (String msg : messages) {
            message.write(msg);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println("Ouch!!!");
            }
        }

        message.write("Finished");
    }

}
