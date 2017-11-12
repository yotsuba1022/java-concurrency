package idv.java.ccr.jsr133.fnl;

/**
 * @author Carl Lu
 */
public class FinalExample {

    static FinalExample obj;
    final int j;
    int i;

    public FinalExample() {
        this.i = 1;
        this.j = 2;
    }

    public static void write() {
        obj = new FinalExample();
    }

    public static void read() {
        FinalExample object = obj;
        int a = object.i;
        int b = object.j;
    }

}

