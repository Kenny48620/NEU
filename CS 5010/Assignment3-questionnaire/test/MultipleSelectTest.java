package questions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for MultipleSelect.
 */
public class MultipleSelectTest {
    private MultipleSelect ms; // question

    /**
     * Initialize ms
     */
    @Before
    public void init(){
        ms = new MultipleSelect("Which is fruit?", "1 2", "Apple", 
                                "Orange", "Bike", "Computer", "Box");
    }
    /**
     * Test Constructor
     */
    @Test
    public void testConstructor(){
        assertNotNull(ms);
        assertEquals("Which is fruit?", ms.getText());
    }
    /**
     * Test getText()
     */
    @Test
    public void testGetText(){
        assertEquals("Which is fruit?", ms.getText());
    }
    /**
     * Test answer()
     */
    @Test
    public void testAnswer(){
        assertEquals("Incorrect", ms.answer("2 3"));
        assertEquals("Correct", ms.answer("1 2"));
    }
    /**
     * Test compareTo
     */
    @Test
    public void testCompareTo(){
        MultipleSelect msa = new MultipleSelect("A?", "1", "A", "B", "C");
        MultipleSelect msb = new MultipleSelect("B?", "1 2", "B", "B", "C");
        MultipleSelect msc = new MultipleSelect("C?", "2 3", "A", "C", "C");

        List<MultipleSelect> mss = new ArrayList<>();
        List<MultipleSelect> exp = new ArrayList<>();
        mss.add(msc);mss.add(msa);mss.add(msb);
        exp.add(msa);exp.add(msb);exp.add(msc);

        assertNotEquals(exp, mss);
        Collections.sort(mss);
        assertEquals(exp, mss);
    }
    /**
     * Test getID()
     */
    @Test
    public void testGetID(){
        assertEquals(3, ms.getID());
    }
}
