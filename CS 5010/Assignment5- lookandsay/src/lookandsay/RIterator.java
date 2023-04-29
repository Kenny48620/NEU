package lookandsay;

import java.util.Iterator;
/**
 * This is an interface that extends Iterator
 */
public interface RIterator<T> extends Iterator<T>, Iterable<T>{
    /**
     * Return the current number in the sequence and retreat to the previous number.
     * @return previous number
     */
    T prev();           
    /**
     * Return true if it is possible to go back one step, false otherwise
     * @return if the number can go back
     */
    boolean hasPrevious();
}
