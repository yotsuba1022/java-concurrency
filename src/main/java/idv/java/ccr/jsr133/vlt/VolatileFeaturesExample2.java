package idv.java.ccr.jsr133.vlt;

/**
 * @author Carl Lu
 */
public class VolatileFeaturesExample2 {

    // 64-bit的long型別變數
    volatile long vl = 0L;

    // 對單個普通變數的讀取用同一個monitor lock來同步
    public synchronized long getVl() {
        return vl;
    }

    // 對單個普通變數的寫入用同一個monitor lock來同步
    public synchronized void setVl(long vl) {
        this.vl = vl;
    }

    public void getAndIncrement() {
        long temp = getVl(); // 呼叫已同步的讀取方法
        temp += 1L;          // 普通的寫入操作
        this.setVl(temp);    // 呼叫已同步的寫入方法
    }
}
