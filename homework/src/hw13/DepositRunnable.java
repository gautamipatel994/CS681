package hw13;
import java.util.concurrent.atomic.AtomicBoolean;

public class DepositRunnable implements Runnable {
    public AtomicBoolean done = new AtomicBoolean(false);
    private ThreadSafeBankAccount2 account = null;

    public DepositRunnable(ThreadSafeBankAccount2 account) {
        this.account = account;
    }

    public void setDone() {
        this.done.set(true);
    }
    
    @Override
    public void run() {
        while (true) {
            if (done.get()) {
                System.out.println(Thread.currentThread().getName() + " deposited money: ");
                break;
            }
            System.out.println(Thread.currentThread().getName() + " start of deposited money");
            account.deposit(300);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException exception) {
            	//exception.printStackTrace();
            }
        }
    }
}
