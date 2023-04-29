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
 * Unit test for MutipleChoice.
 */
public class MultipleChoiceTest {

    private MultipleChoice mc; // question

    /**
     * Initialize mc
     */
    @Before
    public void init(){
        mc = new MultipleChoice("What day is today?", "Friday", "Monday", 
                                "Tuesday", "Wednesday", "Thursday", "Friday");
    }
    /**
     * Test Constructor
     */
    @Test
    public void testConstructor(){
        assertNotNull(mc);
        assertEquals("What day is today?", mc.getText());
    }
    /**
     * Test getText()
     */
    @Test
    public void testGetText(){
        assertEquals("What day is today?", mc.getText());
    }
    /**
     * Test answer()
     */
    @Test
    public void testAnswer(){
        assertEquals("Incorrect", mc.answer("Monday"));
        assertEquals("Correct", mc.answer("Friday"));
    }
    /**
     * Test compareTo
     */
    @Test
    public void testCompareTo(){
        MultipleChoice mca = new MultipleChoice("A?", "A", "A", "B", "C");
        MultipleChoice mcb = new MultipleChoice("B?", "B", "A", "B", "C");
        MultipleChoice mcc = new MultipleChoice("C?", "C", "A", "B", "C");

        List<MultipleChoice> mcs = new ArrayList<>();
        List<MultipleChoice> exp = new ArrayList<>();
        mcs.add(mcc);mcs.add(mca);mcs.add(mcb);
        exp.add(mca);exp.add(mcb);exp.add(mcc);

        assertNotEquals(exp, mcs);
        Collections.sort(mcs);
        assertEquals(exp, mcs);
    }
    /**
     * Test getID()
     */
    @Test
    public void testGetID(){
        assertEquals(2, mc.getID());
    }
}
