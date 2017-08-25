package idv.java.ccr.threads.example16;

/**
 * @author Carl Lu
 */
public class Tutor {

    private Student student;
    private String threadColor;

    public Tutor(String threadColor) {
        this.threadColor = threadColor;
    }

    public synchronized void setStudent(Student student) {
        this.student = student;
    }

    public synchronized void studyTime() {
        System.out.println(threadColor + "Tutor has arrived");
        try {
            // wait for student to arrive and hand in assignment
            Thread.sleep(300);
        } catch (InterruptedException ignored) {

        }
        student.startStudy();
        System.out.println(threadColor + "Tutor is studying with student");
    }

    public synchronized void getProgressReport() {
        // get progress report
        System.out.println(threadColor + "Tutor gave progress report");
    }
}
