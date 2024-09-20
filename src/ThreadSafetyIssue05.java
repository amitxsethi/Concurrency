/**
 * Demostrates synchronized block to resolve the issue
 */
public class ThreadSafetyIssue05 implements Runnable {

    private int shouldBeZero = 0;


    private  void  increment()  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        shouldBeZero++;
    }

    private  void decrement()  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        shouldBeZero--;
    }

    public  void operate() {
        synchronized (this) {
            increment();
            decrement();
        }
    }

    public int getShouldBeZero() {
        return shouldBeZero;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafetyIssue05 operation = new ThreadSafetyIssue05();
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
        operate();
    }
}
