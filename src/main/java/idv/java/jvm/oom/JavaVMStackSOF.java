package idv.java.jvm.oom;

/**
 * @author Carl Lu
 * VM args: -Xss128k
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Throwable throwable) {
            System.out.println("Stack length: " + javaVMStackSOF.stackLength);
            throw throwable;
        }
    }

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

}
