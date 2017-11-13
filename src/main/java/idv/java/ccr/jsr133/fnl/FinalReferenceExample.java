package idv.java.ccr.jsr133.fnl;

/**
 * @author Carl Lu
 */
public class FinalReferenceExample {

    static FinalReferenceExample obj;
    final int[] intArray;                  // final是reference type

    public FinalReferenceExample() {       // constructor
        this.intArray = new int[1];        // 1
        intArray[0] = 1;                   // 2
    }

    public static void writeOne() {        // write執行緒A執行
        obj = new FinalReferenceExample(); // 3
    }

    public static void writeTwo() {        // write執行緒B執行
        obj.intArray[0] = 2;               // 4
    }

    public static void read() {            // read執行緒C執行
        if (obj != null) {                 // 5
            int temp = obj.intArray[0];    // 6
        }
    }
}
