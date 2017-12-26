package idv.java.jvm.error.directmemory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Carl Lu
 * VM args: -Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {

    private static final int _2MB = 2 * 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_2MB);
        }
    }

}
