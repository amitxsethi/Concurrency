import java.util.stream.IntStream;

public class PrimeNumberUtils {

    public static boolean isPrime (int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if( num % i == 0){
                return false;
            }
        }
        return true;
    }



    public static int getNthPrimeNumber (int n) {
        if (n <= 0) {
            System.exit(0);
        }

        int count = 0;
        for (int num = 2; num < Integer.MAX_VALUE; num++) {
            if (isPrime(num)) {
                if (++count==n) return num;
            }
        }
        return -1;
    }
}
