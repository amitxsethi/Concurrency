import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomicinteger resolves thread safety issues.
 */
public class ThreadSafetyIssue01 implements Runnable {

    private final AtomicInteger shouldBeZero = new AtomicInteger(0);


    public void increment()  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        shouldBeZero.incrementAndGet();
    }

    public void decrement()  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        shouldBeZero.decrementAndGet();
    }

    public int getShouldBeZero() {
        return shouldBeZero.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafetyIssue01 operation = new ThreadSafetyIssue01();
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
