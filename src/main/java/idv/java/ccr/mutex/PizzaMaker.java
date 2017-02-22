package idv.java.ccr.mutex;

import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author Carl Lu
 */
public class PizzaMaker implements Runnable {

    private Semaphore semaphore;
    private Semaphore mutex;
    private List<String> pizzaList;

    public PizzaMaker(Semaphore semaphore, Semaphore mutex, List<String> pizzaList) {
        this.semaphore = semaphore;
        this.mutex = mutex;
        this.pizzaList = pizzaList;
    }

    @Override
    public void run() {
        int counter = 1;

        try {
            while (true) {
                String pizza = Thread.currentThread().getName() + ".Pizza." + counter++;
                mutex.acquire();
                pizzaList.add(pizza);
                System.out.println("PizzaMaker is making new pizza: " + pizza);
                mutex.release();

                // release lock
                semaphore.release();
                Thread.sleep(1000);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
