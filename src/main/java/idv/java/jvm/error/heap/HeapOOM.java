package idv.java.jvm.error.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carl Lu
 * VM args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    public static void main(String[] args) {
        List<OOMObject> oomObjects = new ArrayList<>();
        while (true) {
            oomObjects.add(new OOMObject());
        }
    }

    static class OOMObject {

    }

}
