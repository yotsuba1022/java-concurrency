package idv.java.ccr.threads.example21;

import idv.java.ccr.util.ThreadColor;

/**
 * @author Carl Lu
 */
public class ThreadLocalDemo {

    private static volatile ThreadLocal<String> content = new ThreadLocal<>();

    public static void main(String[] args) {
        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            if (name.equals(ThreadColor.ANSI_CYAN + "Que")) {
                content.set(ThreadColor.ANSI_CYAN + "Pa so!!!");
            } else {
                content.set(ThreadColor.ANSI_YELLOW + "Pa Pa Pa!!!");
            }
            System.out.println(name + " " + content.get());
        };

        Thread threadA = new Thread(runnable);
        threadA.setName(ThreadColor.ANSI_CYAN + "Que");

        Thread threadB = new Thread(runnable);
        threadB.setName(ThreadColor.ANSI_YELLOW + "Pa so");

        threadA.start();
        threadB.start();
    }

}
