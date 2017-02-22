package idv.java.ccr.mutex;

import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author Carl Lu
 */
public class PizzaBuyer implements Runnable {

    private String name;
    private Semaphore semaphore;
    private Semaphore mutex;
    private List<String> pizzaList;

    public PizzaBuyer(String name, Semaphore semaphore, Semaphore mutex, List<String> pizzaList) {
        this.name = name;
        this.semaphore = semaphore;
        this.mutex = mutex;
        this.pizzaList = pizzaList;
    }

    @Override
    public void run() {
        try {
            while (true) {
                /*
                 * Acquire lock. Acquires the given number of permits from this semaphore, blocking
                 * until all are available
                 * process stops here until producer releases the lock
                 */
                semaphore.acquire();

                // Acquires a permit from this mutex, blocking until one is available
                mutex.acquire();
                String pizza = "";

                for (String pza : pizzaList) {
                    pizza = pizza.concat(pza + " ");
                }

                System.out.println(name + " buy pizza: " + pizza + ", total: " + pizzaList.size() + "\n");

                /*
                 * It's not a good implementation here,
                 * since mutex.release() should be better to put in finally block.
                 */
                mutex.release();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
