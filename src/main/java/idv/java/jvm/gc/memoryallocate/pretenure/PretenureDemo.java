package idv.java.jvm.gc.memoryallocate.pretenure;

/**
 * @author Carl Lu
 * VM args: -Xloggc:gclog-PretenureDemo.log -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:PretenureSizeThreshold=3145728 -XX:-UseCompressedClassPointers -XX:-UseCompressedOops
 * Here we use 3145728(byte) to represent 3MB since this can not be written as 3M for "PretenureSizeThreshold".
 * 3145728/1024/1024 = 3(MB)
 */
public class PretenureDemo {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocatetion;
        allocatetion = new byte[4 * _1MB];
    }

}
