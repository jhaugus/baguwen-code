import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class NumberPrinter {
    private final int max;
    private int number = 1;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition conditionForMultiplesOfThree =
            lock.newCondition();
    private final Condition conditionForForm3nPlus1 =
            lock.newCondition();
    private final Condition conditionForForm3nPlus2 =
            lock.newCondition();

    public NumberPrinter(int max) {
        this.max = max;
    }

    // 打印 3n
    public void print3n() {
        printNumber(() -> number % 3 == 0, conditionForMultiplesOfThree,
                conditionForForm3nPlus1);
    }

    // 打印3n+1
    public void print3nPlus1() {
        printNumber(() -> number % 3 == 1, conditionForForm3nPlus1,
                conditionForForm3nPlus2);
    }

    // 打印 3n+2
    public void print3nPlus2() {
        printNumber(() -> number % 3 == 2, conditionForForm3nPlus2,
                conditionForMultiplesOfThree);
    }

    private void printNumber(java.util.function.Supplier<Boolean>
                                     shouldPrint, Condition currentCondition, Condition nextCondition) {
        while (number < max - 1) {
            lock.lock();
            try {
                while (!shouldPrint.get()) {
                    currentCondition.await();
                }
                System.out.println(Thread.currentThread().getName() + ":" + number++);
                nextCondition.signal();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter(99);
        Thread t1 = new Thread(printer::print3nPlus1, "Thread A");
        Thread t2 = new Thread(printer::print3nPlus2, "Thread B");
        Thread t3 = new Thread(printer::print3n, "Thread C");
        t1.start();
        t2.start();
        t3.start();
    }
}
