import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;

/**
 * This class explains how we can use ForkJoinScheduler to break down a long task
 * into smaller chunks and complete this chunks on separate threads and then join
 * the output.
 *
 * We will use this to find nTh prime of each number in the array and then summing the resule and printing it.
 *
 */


public class ForkJoinExample {

    static int[] arr = new int[]{1,2,3, 4, 5};


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        Integer result = forkJoinPool.invoke(new CalculatePrimeTask(arr, 0, arr.length-1));
        System.out.println("result is " + result);
    }





}
