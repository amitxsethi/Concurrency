import java.util.concurrent.atomic.AtomicInteger;

/**
 * Non atomic operations on volatile variable still causes issues with multiple threads
 */
public class ThreadSafetyIssue02 implements Runnable {

    private volatile int shouldBeZero = 0;


    public void increment()  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        shouldBeZero++;
    }

    public void decrement()  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        shouldBeZero--;
    }

    public int getShouldBeZero() {
        return shouldBeZero;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafetyIssue02 operation = new ThreadSafetyIssue02();
        new Thread(operation).start();
        new Thread(operation).start();
        new Thread(operation).start();
        new Thread(operation).start();
        while (true)   {
            System.out.println(operation.getShouldBeZero());
            Thread.sleep(2000);
        }



    }

    @Override
    public void run() {
        increment();
        System.out.println(Thread.currentThread().getName() + "incremented to"+ getShouldBeZero());
        decrement();
        System.out.println(Thread.currentThread().getName() + "decremented to"+ getShouldBeZero());
    }
}
