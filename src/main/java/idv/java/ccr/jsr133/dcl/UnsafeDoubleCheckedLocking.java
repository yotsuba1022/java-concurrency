package idv.java.ccr.jsr133.dcl;

/**
 * @author Carl Lu
 */
public class UnsafeDoubleCheckedLocking {
    private static Instance instance;

    public static Instance getInstance() {
        if (instance == null) {                               // First time check
            synchronized (UnsafeDoubleCheckedLocking.class) { // Lock
                if (instance == null) {                       // Second time check
                    instance = new Instance();                // root cause here
                }
            }
        }

        return instance;
    }
}

