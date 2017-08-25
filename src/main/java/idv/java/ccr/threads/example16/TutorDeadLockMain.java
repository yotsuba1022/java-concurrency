package idv.java.ccr.threads.example16;

import idv.java.ccr.util.ThreadColor;

/**
 * @author Carl Lu
 */
public class TutorDeadLockMain {

    public static void main(String[] args) {
        Tutor tutor = new Tutor(ThreadColor.ANSI_CYAN);
        Student student = new Student(tutor, ThreadColor.ANSI_MAGENTA);
        tutor.setStudent(student);

        Thread tutorThread = new Thread(tutor::studyTime);

        Thread studentThread = new Thread(student::handInAssignment);

        tutorThread.start();
        studentThread.start();
    }

}
