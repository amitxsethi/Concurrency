import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFuture01 {


    static ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("I can find you Nth prime number");
            int n = scanner.nextInt();

            CompletableFuture<Integer> completableFuture =
                    (CompletableFuture.supplyAsync(() -> PrimeNumberUtils.getNthPrimeNumber(n)))
                            .thenApplyAsync(integer -> {System.out.println(integer); return integer;});
        }
    }
}
