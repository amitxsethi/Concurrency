/**
 * Demostrates synchronized method to resolve the issue
 */
public class ThreadSafetyIssue04 implements Runnable {

    private  int shouldBeZero = 0;


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

    public synchronized void operate() {
        increment();
        decrement();
    }

    public int getShouldBeZero() {
        return shouldBeZero;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafetyIssue04 operation = new ThreadSafetyIssue04();
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
