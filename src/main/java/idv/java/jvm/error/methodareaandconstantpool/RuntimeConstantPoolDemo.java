package idv.java.jvm.error.methodareaandconstantpool;

/**
 * @author Carl Lu
 */
public class RuntimeConstantPoolDemo {

    public static void main(String[] args) {
        String input1 = new StringBuilder("Computer").append(" SoftWare").toString();
        System.out.println(input1.intern() == input1);

        String input2 = new StringBuilder("ja").append("va").toString();
        System.out.println(input2.intern() == input2);
    }

}
