import java.util.Scanner;

public class Thread01 {
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
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}