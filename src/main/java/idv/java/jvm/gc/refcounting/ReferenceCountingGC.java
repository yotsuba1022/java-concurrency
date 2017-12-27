package idv.java.jvm.gc.refcounting;

/**
 * @author Carl Lu
 * VM args: -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:gclog.log
 * Switch the collector you want:
 * -XX:+UseSerialGC
 * -XX:+UseParNewGC
 * -XX:+UseConcMarkSweepGC
 * -XX:+UseParallelGC
 * -XX:+UseParallelOldGC
 * -XX:+UseG1GC
 */
public class ReferenceCountingGC {

    private final static int _1MB = 1024 * 1024;
    public Object instance = null;
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        System.gc();
    }

    public static void main(String[] args) {
        ReferenceCountingGC.testGC();
    }

}
