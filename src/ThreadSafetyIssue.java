public class ThreadSafetyIssue implements Runnable {

    private int shouldBeZero = 0;


    public void increment()  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        shouldBeZero = 1+shouldBeZero;
    }

    public void decrement()  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        shouldBeZero = shouldBeZero-1;
    }

    public int getShouldBeZero() {
        return shouldBeZero;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafetyIssue operation = new ThreadSafetyIssue();
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
