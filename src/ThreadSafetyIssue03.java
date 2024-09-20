/**
 * Demostrates how thread safety is resolved.
 * since the access to the variable is via synchronised method, at the end of the method,
 * the variable is flushed to system memory from L1,L2 cache. Hence every thread works only on latest copy once lock is aquired.
 * Montor lock in this case is "this".
 */
public class ThreadSafetyIssue03 implements Runnable {

    private  int shouldBeZero = 0;

    public synchronized void  increment()  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        shouldBeZero++;
    }

    public synchronized void decrement()  {
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
        ThreadSafetyIssue03 operation = new ThreadSafetyIssue03();
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
