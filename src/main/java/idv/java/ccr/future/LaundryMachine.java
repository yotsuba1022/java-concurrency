package idv.java.ccr.future;

import java.util.concurrent.Callable;

/**
 * @author Carl Lu
 */
public class LaundryMachine implements Callable {

    private int numberOfLaundryTask;

    public LaundryMachine(int numberOfLaundryTask) {
        this.numberOfLaundryTask = numberOfLaundryTask;
    }

    @Override
    public Object call() {
        for (int i = 1; i <= numberOfLaundryTask; i++) {
            System.out.println("I'm washing cloth no: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return numberOfLaundryTask;
    }

}
