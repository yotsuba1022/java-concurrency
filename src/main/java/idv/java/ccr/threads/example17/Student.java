package idv.java.ccr.threads.example17;

import java.util.concurrent.locks.Lock;

/**
 * @author Carl Lu
 */
public class Student {

    private Tutor tutor;
    private String threadColor;
    private Lock lock;

    public Student(Tutor tutor, Lock lock, String threadColor) {
        this.tutor = tutor;
        this.lock = lock;
        this.threadColor = threadColor;
    }

    public synchronized void startStudy() {
        System.out.println(threadColor + "Student is studying");
    }

    public void handInAssignment() {
        boolean done = false;
        while (!done) {
            if (lock.tryLock()) {
                try {
                    System.out.println(threadColor + "Student hand in assignment");
                    tutor.getProgressReport();
                    System.out.println(threadColor + "Student handed in assignment");
                    done = true;
                } finally {
                    lock.unlock();
                }
            }
        }
    }

}
