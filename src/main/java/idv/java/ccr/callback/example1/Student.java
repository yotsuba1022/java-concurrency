package idv.java.ccr.callback.example1;

/**
 * @author Carl Lu
 */
public class Student {

    QuestionListener teacher;
    private String name;

    public Student(String name, QuestionListener teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public void hands() {
        teacher.putQuestion(name);
    }

}
