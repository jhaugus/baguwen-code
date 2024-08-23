package list;



import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;


public class SynchronizedListAnalyse {
//    private static final AtomicInteger count = new AtomicInteger(1);
    private static int count = 0;
    public static void main(String[] args) {


//        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<Integer>());
        ReentrantLock lock = new ReentrantLock();

        new Thread(new Runnable() {
            @Override
            public void run() {

                while(count < 100){
                    lock.lock();
                    print(0);
                    lock.unlock();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public  void run() {

                while(count < 100){
                    lock.lock();
                    print(1);
                    lock.unlock();
                }


            }
        }).start();



    }

    private static void print(int flag) {
        if(count % 2 == flag && count < 100){
            count++;
            System.out.println(Thread.currentThread().getName() + ": " + count);
        }
    }

}
