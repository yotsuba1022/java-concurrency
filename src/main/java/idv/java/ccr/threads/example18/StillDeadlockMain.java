package idv.java.ccr.threads.example18;

/**
 * @author Carl Lu
 */
public class StillDeadlockMain {

    public static void main(String[] args) {
        final Tutor tutor = new Tutor();
        final Student student = new Student(tutor);
        tutor.setStudent(student);

        Thread tutorThread = new Thread(tutor::studyTime);
        Thread studentThread = new Thread(student::handInAssignment);

        tutorThread.start();
        studentThread.start();
    }

}


class Tutor {
    private Student student;

    public void setStudent(Student student) {
        this.student = student;
    }

    public void studyTime() {
        synchronized (this) {
            System.out.println("Tutor has arrived.");
            synchronized (student) {
                try {
                    this.wait();
                } catch (InterruptedException ignored) {

                }
                student.startStudy();
                System.out.println("Tutor is studying with student.");
            }
        }
    }

    public void getProgressReport() {
        System.out.println("Tutor gave process report.");
    }
}


class Student {
    private Tutor tutor;

    public Student(Tutor tutor) {
        this.tutor = tutor;
    }

    public void startStudy() {
        System.out.println("Student is studying.");
    }

    public void handInAssignment() {
        synchronized (tutor) {
            tutor.getProgressReport();
            synchronized (this) {
                System.out.println("Student handed in assignment.");
                tutor.notifyAll();
            }
        }
    }
}
