package idv.java.ccr.jsr133.fnl;

/**
 * @author Carl Lu
 */
public class FinalReferenceEscapeExample {

    static FinalReferenceEscapeExample obj;
    final int i;

    public FinalReferenceEscapeExample() {
        i = 1;                             // 1 寫final field
        obj = this;                        // 2 this參照在此逸出
    }

    public static void write() {
        new FinalReferenceEscapeExample();
    }

    public static void read() {
        if (obj != null) {                 // 3
            int temp = obj.i;              // 4
        }
    }
}
