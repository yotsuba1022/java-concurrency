package idv.java.ccr.jsr133.dcl;

/**
 * @author Carl Lu
 */
public class UnsafeLazyInitialization {

    private static Instance instance;

    public static Instance getInstance() {
        if (instance == null) {        // 1: Thread A execute here
            instance = new Instance(); // 2: Thread B execute here
        }
        return instance;
    }

}

