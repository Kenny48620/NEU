package priority;

/**
 * This class is the interface for MinMaxPriorityQueue, which gives
 * the user to get the maximum priority item and minimum priority
 * item
 */
public interface MinMaxPriorityQueue<T> {
    /**
     * Add an item by it's priority
     * @param item     item
     * @param priority the priority
     */
    void add(T item, int priority);

    /**
     * Find the minimum priority of item
     * @return item 
     */
    T minPriorityItem();

    /**
     * Find the maximum priority of item
     * @return item
     */
    T maxPriorityItem();
}
