package idv.java.ccr.threads.example13;

/**
 * @author Carl Lu
 */
public class Main {

    public static void main(String[] args) {
        final BankAccount bankAccount = new BankAccount(1000.00, "9487-9487");

        Thread thread1 = new Thread(() -> {
            bankAccount.deposit(300.00);
            bankAccount.withdraw(50.00);
        });

        Thread thread2 = new Thread(() -> {
            bankAccount.deposit(203.75);
            bankAccount.withdraw(100.00);
        });

        thread1.start();
        thread2.start();

        /*
        * 1000.00 +300.00 - 50.00 + 203.75 - 100.00 = 1,353.75
        * */
        System.out.println("Balance after operations: " + bankAccount.getBalance());
    }

}
