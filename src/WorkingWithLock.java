import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WorkingWithLock implements Runnable{


    private final Lock lock = new ReentrantLock(true);
    private int shouldBeZero = 0;


    private  void  increment()  {
        lock.lock();
        shouldBeZero++;
        lock.unlock();
    }

    private  void decrement()  {
        lock.lock();
        shouldBeZero--;
        lock.unlock();
    }

    public  void operate() {
        increment();
        decrement();
    }

    public int getShouldBeZero() {
        return shouldBeZero;
    }

    public static void main(String[] args) throws InterruptedException {
        WorkingWithLock operation = new WorkingWithLock();
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
