package idv.java.ccr.mutex;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author Carl Lu
 */
public class SemaphoreMutexDemo1 {

    private static List<String> pizzaList = new ArrayList<>();

    /*
     * Semaphore maintains a set of permits.
     * Each acquire blocks if necessary until a permit is available, and then takes it.
     * Each release adds a permit, potentially releasing a blocking acquirer.
     */
    private static Semaphore semaphore = new Semaphore(0);
    private static Semaphore mutex = new Semaphore(1);

    public static void main(String args[]) {
        new Thread(new PizzaMaker(semaphore, mutex, pizzaList)).start();
        new Thread(new PizzaBuyer("RuRu", semaphore, mutex, pizzaList)).start();
        new Thread(new PizzaBuyer("MaoMao", semaphore, mutex, pizzaList)).start();
    }
}
