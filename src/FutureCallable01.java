import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCallable01 {

    static ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("I can find you Nth prime number");
            int n = scanner.nextInt();
            Callable<Integer> callable = () -> PrimeNumberUtils.getNthPrimeNumber(n);
            Future<Integer> future = executorService.submit(callable);
            System.out.println(future.get());
        }
    }

}
