package idv.java.ccr.threads.example6;

import idv.java.ccr.util.ThreadColor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carl Lu
 */
public class Main {

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        SimpleProducer producer = new SimpleProducer(buffer, ThreadColor.ANSI_CYAN);
        SimpleConsumer consumer1 = new SimpleConsumer(buffer, ThreadColor.ANSI_MAGENTA);
        SimpleConsumer consumer2 = new SimpleConsumer(buffer, ThreadColor.ANSI_YELLOW);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }

}
