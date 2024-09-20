import java.util.concurrent.RecursiveTask;
import java.lang.Integer;

public class CalculatePrimeTask extends RecursiveTask<Integer> {

    private final int[] arr;
    private final int begin;
    private final int end;

    CalculatePrimeTask(final int[] arr, final int begin, final int end) {
        this.arr = arr;
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end == begin) {
            return PrimeNumberUtils.getNthPrimeNumber(arr[begin]);
        } else if (end-begin == 1 ) {
            return PrimeNumberUtils.getNthPrimeNumber(arr[begin])
                    + PrimeNumberUtils.getNthPrimeNumber(arr[end]) ;
        } else {
            int mid = (end-begin)/2;
            CalculatePrimeTask task1 = new CalculatePrimeTask(arr, begin, mid);
            CalculatePrimeTask task2 = new CalculatePrimeTask(arr, mid+1, end);
            task1.invoke();
            task2.invoke();
            return task1.join() + task2.join();
        }
    }
}
