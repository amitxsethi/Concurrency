import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterService02 {

    static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args){

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("I can find you Nth prime number");
            int n = scanner.nextInt();
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(PrimeNumberUtils.getNthPrimeNumber(n));
                }
            };
            executorService.execute(runnable);
        }
    }

}