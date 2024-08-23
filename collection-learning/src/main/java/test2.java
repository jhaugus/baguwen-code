import java.util.*;
import java.util.concurrent.*;

public class test2 {


    public static void main(String[] args) {

        LinkedHashSet<Integer> integers = new LinkedHashSet<>();
        
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> deque2 = new LinkedList<>();

        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();


        HashSet<Integer> objects = new HashSet<>();
        Integer next = objects.iterator().next();


        CopyOnWriteArrayList<Object> objects1 = new CopyOnWriteArrayList<>();


        ConcurrentSkipListSet<Integer> integers2 = new ConcurrentSkipListSet<>();


//        CopyOnWriteArraySet

        List<Object> objects2 = Collections.synchronizedList(new ArrayList<>());



        ArrayBlockingQueue<Integer> integers3 = new ArrayBlockingQueue<>(10);
        PriorityBlockingQueue<Integer> integers4 = new PriorityBlockingQueue<>();


        TreeSet<Integer> integers1 = new TreeSet<>();
        objects.add(33);
        objects.add(4123);
        objects.add(1231);
        objects.add(22);

        objects.add(54);

        for(Integer object:objects){
            System.out.println(object);
        }

    }
}
