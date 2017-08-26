package idv.java.ccr.threads.example17;

import java.util.concurrent.locks.Lock;

/**
 * @author Carl Lu
 */
public class Tutor {

    private Student student;
    private String threadColor;
    private Lock lock;

    public Tutor(String threadColor, Lock lock) {
        this.threadColor = threadColor;
        this.lock = lock;
    }

    public synchronized void setStudent(Student student) {
        this.student = student;
    }

    public void studyTime() {
        boolean done = false;
        while (!done) {
            if (lock.tryLock()) {
                try {
                    System.out.println(threadColor + "Tutor has arrived");
                    try {
                        // wait for student to arrive and hand in assignment
                        Thread.sleep(300);
                    } catch (InterruptedException ignored) {

                    }
                    student.startStudy();
                    System.out.println(threadColor + "Tutor is studying with student");
                    done = true;
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public synchronized void getProgressReport() {
        // get progress report
        System.out.println(threadColor + "Tutor gave progress report");
    }
}
