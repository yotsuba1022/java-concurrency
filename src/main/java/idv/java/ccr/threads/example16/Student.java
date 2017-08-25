package idv.java.ccr.threads.example16;

/**
 * @author Carl Lu
 */
public class Student {

    private Tutor tutor;
    private String threadColor;

    public Student(Tutor tutor, String threadColor) {
        this.tutor = tutor;
        this.threadColor = threadColor;
    }

    public synchronized void startStudy() {
        System.out.println(threadColor + "Student is studying");
    }

    public synchronized void handInAssignment() {
        System.out.println(threadColor + "Student hand in assignment");
        tutor.getProgressReport();
        System.out.println(threadColor + "Student handed in assignment");
    }

}
