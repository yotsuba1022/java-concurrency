package idv.java.ccr.threads.example22;

/**
 * @author Carl Lu
 */
public class InheritableThreadLocalDemo {

    private static final ThreadLocal<Integer> intVal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        Runnable runnable = () -> {
            intVal.set(10);
            Runnable childRunnable = () -> {
                Thread thread = Thread.currentThread();
                String name = thread.getName();
                System.out.printf("%s %d%n", name, intVal.get());
            };
            Thread childThread = new Thread(childRunnable);
            childThread.setName("Child");
            childThread.start();
        };
        new Thread(runnable).start();
    }

}
