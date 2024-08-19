package UnsafeFunction;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class MemoryProtective {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ChangeThread changeThread = new ChangeThread();
        new Thread(changeThread).start();
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe)field.get(null);
        while (true) {
            boolean flag = changeThread.isFlag();
            unsafe.loadFence(); //加入读内存屏障
            if (flag){
                System.out.println("detected flag changed");
                break;
            }
        }
        System.out.println("main thread end");
    }



}
