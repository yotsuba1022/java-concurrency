package idv.java.ccr.jsr133.dcl;

/**
 * @author Carl Lu
 */
public class InstanceFactory {
    public static Instance getInstance() {
        // The following line will invoke the initialization of InstanceHolder
        return InstanceHolder.instance;
    }


    private static class InstanceHolder {
        public static Instance instance = new Instance();
    }
}


