package assignment7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.Test.None;

import priority.MinMaxPriorityQueueImpl;
/**
 * Test class for MinMaxPriorityQueueImpl.
 */
public class MinMaxPriorityQueueImplTest {

    /**
     * Test constructor
     */
    @Test
    public void testConstructor(){
        MinMaxPriorityQueueImpl<String> q = new MinMaxPriorityQueueImpl<>();  
        assertNotNull(q);
    }
    
    /**
     * Test add(E item, int priority)
     */
    @Test(expected = None.class)
    public void testAdd(){
        MinMaxPriorityQueueImpl<String> q = new MinMaxPriorityQueueImpl<>();  

        q.add("C0", 3);
        q.add("A0", 1);
        q.add("B", 2);
        q.add("A1", 1);
        q.add("C1", 3);
        q.add("D", 4);    
    }
    
    /**
     * Test minPriorityItem()
     */
    @Test
    public void testMinPriorityItem(){
        MinMaxPriorityQueueImpl<String> q = new MinMaxPriorityQueueImpl<>();  

        q.add("C0", 3);
        q.add("A0", 1);
        q.add("B", 2);
        q.add("A1", 1);
        q.add("C1", 3);
        q.add("D", 4);    

        assertEquals("A0", q.minPriorityItem());
        assertEquals("A1", q.minPriorityItem());
        assertEquals("B", q.minPriorityItem());
        assertEquals("C0", q.minPriorityItem());
        assertEquals("C1", q.minPriorityItem());
        assertEquals("D", q.minPriorityItem());
    }

    /**
     * Test maxPriorityItem()
     */
    @Test
    public void testMaxPriorityItem(){
        MinMaxPriorityQueueImpl<String> q = new MinMaxPriorityQueueImpl<>();  

        q.add("C0", 3);
        q.add("A0", 1);
        q.add("B", 2);
        q.add("A1", 1);
        q.add("C1", 3);
        q.add("D", 4);    

        assertEquals("D", q.maxPriorityItem());
        assertEquals("C0", q.maxPriorityItem());
        assertEquals("C1", q.maxPriorityItem());
        assertEquals("B", q.maxPriorityItem());
        assertEquals("A0", q.maxPriorityItem());
        assertEquals("A1", q.maxPriorityItem());
    }
}
