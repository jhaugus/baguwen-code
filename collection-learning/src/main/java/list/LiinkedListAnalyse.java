package list;

import java.util.AbstractSequentialList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LiinkedListAnalyse {
    public static void main(String[] args) {


//        public class LinkedList<E>
//                extends AbstractSequentialList<E>
//                implements List<E>, Deque<E>, Cloneable, java.io.Serializable
        LinkedList<Integer> list = new LinkedList<>();

        list.offer(1);
        list.offer(2);
        list.offer(3);


        

        list.iterator().forEachRemaining(e -> System.out.print(e + " "));


    }
}
