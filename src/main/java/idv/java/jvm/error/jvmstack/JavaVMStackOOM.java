package idv.java.jvm.error.jvmstack;

/**
 * @author Carl Lu
 * VM args: -Xss2048M
 */
public class JavaVMStackOOM {

    public static void main(String[] args) {
        JavaVMStackOOM javaVMStackOOM = new JavaVMStackOOM();
        javaVMStackOOM.stackLeakByThread();
    }

    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(this::dontStop);
            thread.run();
        }
    }

}
