package idv.java.jvm.gc.memoryallocate.tenuringthreshold;

/**
 * @author Carl Lu
 * VM args:
 * -Xloggc:gclog-TenuringThresholdEqualsTo1Demo.log -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution -XX:-UseCompressedClassPointers -XX:-UseCompressedOops -XX:+UseSerialGC
 * -Xloggc:gclog-TenuringThresholdEqualsTo7Demo.log -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=7 -XX:+PrintTenuringDistribution -XX:-UseCompressedClassPointers -XX:-UseCompressedOops -XX:-UseAdaptiveSizePolicy -XX:+UseParNewGC
 */
public class TenuringThresholdDemo {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3;

        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }
}
