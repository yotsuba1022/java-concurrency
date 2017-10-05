package idv.java.ccr.phaser.example1;

import idv.java.ccr.util.ThreadColor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 * @author Carl Lu
 */
public class PhaserDemo {

    public static void main(String[] args) {
        List<Runnable> tasks = new ArrayList<>();
        tasks.add(new PhaseTask(ThreadColor.ANSI_CYAN));
        tasks.add(new PhaseTask(ThreadColor.ANSI_MAGENTA));
        tasks.add(new PhaseTask(ThreadColor.ANSI_GREEN));
        tasks.add(new PhaseTask(ThreadColor.ANSI_YELLOW));
        tasks.add(new PhaseTask(ThreadColor.ANSI_BLUE));
        runTasks(tasks);
    }

    private static void runTasks(List<Runnable> tasks) {
        final Phaser phaser = new Phaser(1);

        for (final Runnable task : tasks) {
            phaser.register();
            Runnable r = () -> {
                try {
                    Thread.sleep(50 + (long) ( Math.random() * 300 ));
                } catch (InterruptedException ignored) {

                }
                int phaseNumber = phaser.arriveAndAwaitAdvance();
                task.run();
                System.out.println("Phase : " + phaseNumber + " finished.");
            };
            Executors.newSingleThreadExecutor().execute(r);
            phaser.arriveAndDeregister();
        }
    }

}
