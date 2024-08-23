public class test {

    public static void main(String[] args) {

    }
}


class MyThread extends Thread {

    private static int count = 0;

    public void run() {
        for (int i = 0; i < 100; i++) {
            if (count % 2 == 0){
                count++;
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}