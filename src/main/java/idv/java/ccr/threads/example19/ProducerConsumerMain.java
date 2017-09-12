package idv.java.ccr.threads.example19;

/**
 * @author Carl Lu
 */
public class ProducerConsumerMain {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        new Thread(new Producer(sharedResource)).start();
        new Thread(new Consumer(sharedResource)).start();
    }

}
