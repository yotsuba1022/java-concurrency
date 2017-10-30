package idv.java.ccr.jsr133.vlt;

/**
 * @author Carl Lu
 */
public class VolatileFeaturesExample {

    // 使用volatile宣告的64-bit的long型別變數
    volatile long vl = 0L;

    // 單個volatile變數的讀取
    public long getVl() {
        return vl;
    }

    // 單個volatile變數的寫入
    public void setVl(long vl) {
        this.vl = vl;
    }

    // 複合(多個)volatile變數的讀寫
    public void getAndIncrement() {
        vl++;
    }

}
