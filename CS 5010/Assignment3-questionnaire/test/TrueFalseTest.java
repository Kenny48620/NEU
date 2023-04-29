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
 * Unit test for TrueFalseTest.
 */
public class TrueFalseTest {

    private TrueFalse tf;   // question
    /**
     * Initialize tf
     */
    @Before
    public void init(){
        tf = new TrueFalse("Are you a male?", "True");
    }
    /**
     * Test IllegalArgumentException of constructor
     */
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorIllegalArgumentException(){
        new TrueFalse("Are you a male?", "Yes");
    } 

    /**
     * Test constructor() 
     */
    @Test 
    public void testConstructorGetTextTestAnswer(){
       assertNotNull(tf);
       assertEquals("Are you a male?", tf.getText());
       assertEquals("Correct", tf.answer("True"));
    } 
    /**
     * Test getText()
     */
    @Test
    public void testGetText(){
        assertEquals("Are you a male?", tf.getText());
    }
    /**
     * Test IllegalArgumentException for answer()
     */
    @Test (expected = IllegalArgumentException.class)
    public void testAnswerIllegalArgumentException(){
        tf.answer("Yes");
    }
    /**
     * Test answer()
     */
    @Test
    public void testAnswer(){
        assertEquals("Correct", tf.answer("True"));
        assertEquals("Incorrect", tf.answer("False"));
    }   
    /**
     * Test compareTo()
     */
    @Test
    public void testCompareTo(){
        TrueFalse tfa = new TrueFalse("A?", "True");
        TrueFalse tfb = new TrueFalse("B??", "False");
        TrueFalse tfc = new TrueFalse("C???", "False");

        List<TrueFalse> tfs = new ArrayList<>();
        List<TrueFalse> exp = new ArrayList<>();
        tfs.add(tfc);tfs.add(tfa);tfs.add(tfb);
        exp.add(tfa);exp.add(tfb);exp.add(tfc);

        assertNotEquals(exp, tfs);
        Collections.sort(tfs);
        assertEquals(exp, tfs);
    }
    /**
     * Test getID()
     */
    @Test
    public void testGetID(){
        assertEquals(1, tf.getID());
    }
}
