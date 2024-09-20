public class WorkingWithSemaphores {


    public static void main(String[] args) {
        new Thread(new LongRunningTask("task01",10)).start();
        new Thread(new LongRunningTask("task02",20)).start();
        new Thread(new LongRunningTask("task03",15)).start();
        new Thread(new LongRunningTask("task04",22)).start();
        new Thread(new LongRunningTask("task05",30)).start();
    }


}
