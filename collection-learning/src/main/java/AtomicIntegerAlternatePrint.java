import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerAlternatePrint {
    private static final AtomicInteger atomicInt = new AtomicInteger(1);

    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintTask(0));
        Thread t2 = new Thread(new PrintTask(1));

        t1.start();
        t2.start();
    }

    static class PrintTask implements Runnable {
        private final int threadId;

        public PrintTask(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {

            while (atomicInt.get() <= 100) {
                if (atomicInt.get() % 2 == threadId) {
                    System.out.println("Thread " + threadId + ": " + atomicInt.getAndIncrement());
                }
            }
        }
    }
}