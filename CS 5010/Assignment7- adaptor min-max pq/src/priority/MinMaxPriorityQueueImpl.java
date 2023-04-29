package priority;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Map.Entry;
/**
 * This class is to implement the interface MinMaxPriorityQueue by using an desgin
 * pattern concept adpater.
 */
public class MinMaxPriorityQueueImpl<E> implements MinMaxPriorityQueue<E>{
    private TreeMap<Integer, Queue<E>> priorityQueue; // priority queue
    private static final int MAX_PRIORITY = 0;        // maximum priority
    private static final int MIN_PRIORITY = 1;        // minimum priority

    /**
     * Constructor
     */
    public MinMaxPriorityQueueImpl(){
        priorityQueue = new TreeMap<>();
    }

    @Override
    public void add(E item, int priority) {
        if (priorityQueue.containsKey(priority)){
            priorityQueue.get(priority).add(item);
        }else{
            Queue<E> queue = new LinkedList<>();
            queue.add(item);
            priorityQueue.put(priority, queue);
        }
    }

    @Override
    public E minPriorityItem() {
        return findItemBy(MIN_PRIORITY);
    }

    @Override
    public E maxPriorityItem() {
        return findItemBy(MAX_PRIORITY);
    }

    /**
     * Find an item by minimum priority or maximum priority
     * @param priorityType MIN_PRIORITY or MAX_PRIORITY
     * @return
     */
    private E findItemBy(int priorityType){
        if (priorityQueue.isEmpty()){
            return null;
        }

        Entry<Integer, Queue<E>> entry;
        if (priorityType == MIN_PRIORITY){
            entry = priorityQueue.firstEntry();
        }else{
            entry = priorityQueue.lastEntry();
        }

        Queue<E> curQueue = entry.getValue();
        E item = curQueue.poll();

        if (curQueue.isEmpty()){
            priorityQueue.remove(entry.getKey());
        }

        return item;
    }
    
}
