package idv.java.ccr.callback.example1;

/**
 * @author Carl Lu
 */
public class Teacher implements QuestionListener {

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.onClass();
    }

    public void onClass() {
        Student student = new Student("RuRu", this);
        student.hands();
    }

    @Override
    public void putQuestion(String name) {
        System.out.println(name + " has question.");
    }

}
