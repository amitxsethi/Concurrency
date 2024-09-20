import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("I can find you Nth prime number");
            System.out.println(PrimeNumberUtils.getNthPrimeNumber(scanner.nextInt()));
        }
    }
}