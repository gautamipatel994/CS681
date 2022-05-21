package hw18;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrimeExecutor {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.execute(new RunnablePrimeFactorizer(62, 2, (long) Math.sqrt(62) / 2));
        executor.shutdown();
    }
}
