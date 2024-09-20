import java.util.concurrent.Semaphore;

/**
 * Long running task of x seconds.
 */
public class LongRunningTask implements Runnable{

    /**
     * only 2 of these long running tasks can run at any given time
     */
    private static final Semaphore semaphore = new Semaphore(2);

    private final int seconds ;
    private final String taskName ;


    public LongRunningTask(String taskName, int seconds) {
        this.seconds = seconds;
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(taskName + "is started");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(taskName + "is finished");
            semaphore.release();
        }
    }

}
