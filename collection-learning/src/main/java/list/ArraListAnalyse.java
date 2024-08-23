package list;

import java.util.*;

public class ArraListAnalyse {

    public static void main(String[] args) {

//        public class ArrayList<E> extends AbstractList<E>
//        implements List<E>, RandomAccess, Cloneable, java.io.Serializable
        ArrayList<Integer> test = new ArrayList<>();
//        arrayList.add(4);
//        arrayList.add(5);
//        arrayList.add(6);
//        arrayList.add(5);
//        arrayList.add(6);
//        arrayList.add(7);
//        arrayList.add(8);
//        arrayList.add(9);
//        arrayList.add(1);
//        arrayList.add(2);
//        arrayList.add(3);
//        arrayList.add(4);


        List<Integer> arrayList = Arrays.asList(4, 5, 6, 5, 6, 7, 8, 9, 1, 2, 3, 4);


        arrayList.iterator().forEachRemaining(e -> System.out.print(e + " "));

        System.out.println();
        arrayList.spliterator().forEachRemaining(e -> System.out.print(e + " "));


        /**
         * 使用tryAdvance做拆分
         */
        Spliterator<Integer> spliterator = arrayList.spliterator();
        System.out.println();

        for(int i = 0; i < 4 && spliterator.tryAdvance(e->System.out.print(e + ":")); i++){
            long size = spliterator.estimateSize();
            System.out.println("ResidueSize:" + size);
        }

        // 使用 forEachRemaining 方法处理所有剩余元素
        System.out.println();
        spliterator.forEachRemaining(System.out::print);

        Spliterator<Integer> spliterator1 = arrayList.spliterator();
        Spliterator<Integer> integerSpliterator = spliterator1.trySplit();
        System.out.println();
        integerSpliterator.forEachRemaining(e->System.out.print(e + " "));
        System.out.println();
        spliterator1.forEachRemaining(e->System.out.print(e + " "));






    }


}
