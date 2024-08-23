package list;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedListAnalyse2 {
    private static final AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable task = () -> {
            while (count.get() < 100) {
                print();
            }
        };

        executor.execute(task);
        executor.execute(task);

        executor.shutdown();
    }

    private static void print() {
        int currentCount = count.get();
        // 确保只有一个线程输出并递增
        if (currentCount < 100 && count.compareAndSet(currentCount, currentCount + 1)) {
            System.out.println(Thread.currentThread().getName() + ": " + (currentCount + 1));
        }


    }
}
