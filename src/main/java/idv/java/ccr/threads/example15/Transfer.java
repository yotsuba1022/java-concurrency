package idv.java.ccr.threads.example15;

/**
 * @author Carl Lu
 */
public class Transfer implements Runnable {

    private BankAccount sourceAccount;
    private BankAccount destinationAccount;
    private double amount;
    private String threadColor;

    public Transfer(BankAccount sourceAccount, BankAccount destinationAccount, double amount, String threadColor) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
        this.threadColor = threadColor;
    }

    @Override
    public void run() {
        while (!sourceAccount.transfer(destinationAccount, amount))
            continue;

        System.out.printf(threadColor + "%s completed\n", Thread.currentThread().getName());
    }
}
