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
 * Unit test for Likert.
 */
public class LikertTest {
    private Likert likert; // question
    /**
     * Initialize likert
     */
    @Before
    public void init(){
        likert = new Likert("How's your day");
    }
    /**
     * Test Constructor
     */
    @Test
    public void testConstructor(){
        assertNotNull(likert);
        assertEquals("How's your day", likert.getText());
    }
    /**
     * Test getText()
     */
    @Test
    public void testGetText(){
        assertEquals("How's your day", likert.getText());
    }
    /**
     * Test answer()
     */
    @Test
    public void testAnswer(){
        assertEquals("Correct", likert.answer("1"));
        assertEquals("Correct", likert.answer("2"));
        assertEquals("Correct", likert.answer("3"));
        assertEquals("Correct", likert.answer("4"));
        assertEquals("Correct", likert.answer("5"));

        assertEquals("Incorrect", likert.answer("0"));
        assertEquals("Incorrect", likert.answer("10"));
    }
    /**
     * Test compareTo()
     */
    @Test
    public void testCompareTo(){
        Likert la = new Likert("A?"); 
        Likert lb = new Likert("B??"); 
        Likert lc = new Likert("C??"); 

        List<Likert> ls  = new ArrayList<>();
        List<Likert> exp = new ArrayList<>();
        ls.add(lc);ls.add(la);ls.add(lb);
        exp.add(la);exp.add(lb);exp.add(lc);

        assertNotEquals(exp, ls);
        Collections.sort(ls);
        assertEquals(exp, ls);
    }
    /**
     * Test getID()
     */
    @Test
    public void testGetID(){
        assertEquals(4, likert.getID());
    }
}
