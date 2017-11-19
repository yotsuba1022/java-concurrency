package idv.java.ccr.jsr133.dcl;

/**
 * @author Carl Lu
 */
public class SafeLazyInitialization {
    private static Instance instance;

    public synchronized static Instance getInstance() {
        if (instance == null) {
            instance = new Instance();
        }

        return instance;
    }
}

