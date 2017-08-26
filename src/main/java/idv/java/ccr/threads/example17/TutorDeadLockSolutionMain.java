package idv.java.ccr.threads.example17;

import idv.java.ccr.util.ThreadColor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Carl Lu
 */
public class TutorDeadLockSolutionMain {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Tutor tutor = new Tutor(ThreadColor.ANSI_CYAN, lock);
        Student student = new Student(tutor, lock, ThreadColor.ANSI_MAGENTA);
        tutor.setStudent(student);

        Thread tutorThread = new Thread(tutor::studyTime);

        Thread studentThread = new Thread(student::handInAssignment);

        tutorThread.start();
        studentThread.start();
    }

}
