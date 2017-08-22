package idv.java.ccr.threads.example15;

import idv.java.ccr.util.ThreadColor;

/**
 * @author Carl Lu
 */
public class TransferMain {

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(500.00, "9487-9487", ThreadColor.ANSI_CYAN);
        BankAccount account2 = new BankAccount(1000.00, "9478-9478", ThreadColor.ANSI_MAGENTA);

        new Thread(new Transfer(account1, account2, 10.00, ThreadColor.ANSI_GREEN), "Transfer1").start();
        new Thread(new Transfer(account2, account1, 55.88, ThreadColor.ANSI_YELLOW), "Transfer2").start();
    }

}
