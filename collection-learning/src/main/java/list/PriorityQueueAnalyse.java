package list;

import java.util.PriorityQueue;

public class PriorityQueueAnalyse {


    public static void main(String[] args) {

//public class PriorityQueue<E> extends AbstractQueue<E>
//    implements java.io.Serializable {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(4);
        priorityQueue.add(5);
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);


        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }
}
