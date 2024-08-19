package UnsafeFunction;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class MemoryOperation {



    private static void memoryTest() throws NoSuchFieldException, IllegalAccessException {
        int size = 4;

        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe)field.get(null);


        long addr = unsafe.allocateMemory(size);
        long addr3 = unsafe.reallocateMemory(addr, size * 2);
        System.out.println("addr: "+addr);
        System.out.println("addr3: "+addr3);
        try {
            unsafe.setMemory(null,addr ,size,(byte)1);
            for (int i = 0; i < 2; i++) {
                unsafe.copyMemory(null,addr,null,addr3+size*i,4);
            }
            System.out.println(unsafe.getInt(addr));
            System.out.println(unsafe.getLong(addr3));
        }finally {
            unsafe.freeMemory(addr);
            unsafe.freeMemory(addr3);
        }
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        memoryTest();
    }

}
