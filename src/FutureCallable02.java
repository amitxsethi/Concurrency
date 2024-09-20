import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCallable02 {

    static ExecutorService executorService = Executors.newFixedThreadPool(3);

    final static int[] nthPrimeArray = new int[]{1000000,2,3,4,5,6,7,8,9};
    final static ArrayList<Future<Integer>> futures = new ArrayList<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        for ( int i = 0; i < nthPrimeArray.length; i++) {
            int finalI = i;
            Callable<Integer> callable = () -> PrimeNumberUtils.getNthPrimeNumber(nthPrimeArray[finalI]);
            Future<Integer> future = executorService.submit(callable);
            futures.add(future);
        }

        while (!futures.isEmpty()) {
            Optional<Future<Integer>> futureOptional =  futures.stream().filter(Future::isDone).findFirst();
            if (futureOptional.isPresent()) {
                System.out.println(futureOptional.get().get());
                futures.remove(futureOptional.get());
            }
        }
        System.out.println("done");
        executorService.shutdown();
        }


    }

