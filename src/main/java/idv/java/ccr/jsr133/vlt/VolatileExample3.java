package idv.java.ccr.jsr133.vlt;

/**
 * @author Carl Lu
 */
public class VolatileExample3 {

    int a = 0;
    volatile boolean flag = false;

    public void write() {
        a = 1;              // 1
        flag = true;        // 2
    }

    public void read() {
        if (flag) {         // 3
            int i = a;      // 4
        }
    }

}
