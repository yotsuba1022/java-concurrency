package idv.java.ccr.semaphore.example2;

/**
 * @author Carl Lu
 */
public class Consumer implements Runnable {

    private String threadColor;
    private Pool pool;

    Consumer(String threadColor, Pool pool) {
        this.threadColor = threadColor;
        this.pool = pool;
    }

    @Override
    public void run() {
        String name = threadColor + Thread.currentThread().getName();

        try {
            while (true) {
                String item;
                System.out.println(name + " acquiring " + ( item = pool.getItem() ));
                Thread.sleep((long) ( 200 + Math.random() * 100 ));
                System.out.println(name + " pulling back " + item);
                pool.putItem(item);
            }
        } catch (InterruptedException ignored) {
        }
    }

}
