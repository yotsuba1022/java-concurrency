package idv.java.ccr.jsr133.vlt;

/**
 * @author Carl Lu
 */
public class VolatileExample4 {
    int a;
    volatile int v1 = 1;
    volatile int v2 = 2;

    void readAndWrite() {
        int i = v1;           // the first volatile read
        int j = v2;           // the second volatile read
        a = i + j;            // normal write
        v1 = i + 1;           // the first volatile write
        v2 = j * 2;           // the second volatile write
    }

    //... other methods
}
