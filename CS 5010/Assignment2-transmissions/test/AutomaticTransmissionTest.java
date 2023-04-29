
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import transmission.AutomaticTransmission;

/**
 *  This class will test the methods from AutomaticTransmission.java.
 *  @author Kaichun Lee
 */

public class AutomaticTransmissionTest {
    /*
     * Test llegalArgumentException for 5 conditions
     */
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorIllegalArgumentException1(){
        AutomaticTransmission at = new AutomaticTransmission(-2, 20 , 30, 40, 50);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorIllegalArgumentException2(){
        AutomaticTransmission at = new AutomaticTransmission(10, 0 , 30, 40, 50);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorIllegalArgumentException3(){
        AutomaticTransmission at = new AutomaticTransmission(10, 20 , 0, 40, 50);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorIllegalArgumentException4(){
        AutomaticTransmission at = new AutomaticTransmission(10, 20 , 30, 0, 50);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorIllegalArgumentException5(){
        AutomaticTransmission at = new AutomaticTransmission(10, 20 , 30, 40, 0);
    }

    /*
     * 2 Test increaseSpeed method
     */
    @Test
    public void testIncreaseSpeed1(){
        AutomaticTransmission at = new AutomaticTransmission(4, 6 , 8, 9, 10);
        at.increaseSpeed();
        assertEquals(2, at.getSpeed());
        assertEquals(1, at.getGear());

        at.increaseSpeed();
        assertEquals(4, at.getSpeed());
        assertEquals(2, at.getGear());

        at.increaseSpeed();at.increaseSpeed();
        assertEquals(8, at.getSpeed());
        assertEquals(4, at.getGear());

        at.increaseSpeed();
        assertEquals(10, at.getSpeed());
        assertEquals(6, at.getGear());
        
    }

    @Test
    public void testIncreaseSpeed2(){
        AutomaticTransmission at = new AutomaticTransmission(3, 5 , 7, 9, 11);
        
        at.increaseSpeed();
        assertEquals(2, at.getSpeed());
        assertEquals(1, at.getGear());

        at.increaseSpeed();
        assertEquals(4, at.getSpeed());
        assertEquals(2, at.getGear());

        at.increaseSpeed();
        assertEquals(6, at.getSpeed());
        assertEquals(3, at.getGear());
        
        at.increaseSpeed();
        assertEquals(8, at.getSpeed());
        assertEquals(4, at.getGear());

        at.increaseSpeed();
        assertEquals(10, at.getSpeed());
        assertEquals(5, at.getGear());

        at.increaseSpeed();
        assertEquals(12, at.getSpeed());
        assertEquals(6, at.getGear());
    }
    
    /*
     * Test IllegalStateException for decreaseSpeed() 
     */
    @Test(expected = IllegalStateException.class)
    public void testDecreaseSpeedIllegalStateException(){
        AutomaticTransmission at = new AutomaticTransmission(3, 5 , 7, 9, 11);
        at.decreaseSpeed();
    }

    /*
     * Test decreaseSpeed method
     */
    @Test
    public void testDecreaseSpeed1(){
        AutomaticTransmission at = new AutomaticTransmission(3, 5 , 7, 9, 11);
        for (int i=0; i<6; i++){
            at.increaseSpeed();
        }

        assertEquals(12, at.getSpeed());
        assertEquals(6, at.getGear());

        // start decreasing speed
        at.decreaseSpeed();
        assertEquals(10, at.getSpeed());
        assertEquals(5, at.getGear());   

        at.decreaseSpeed();
        assertEquals(8, at.getSpeed());
        assertEquals(4, at.getGear());   

        at.decreaseSpeed();
        assertEquals(6, at.getSpeed());
        assertEquals(3, at.getGear());   

        at.decreaseSpeed();
        assertEquals(4, at.getSpeed());
        assertEquals(2, at.getGear());   

        at.decreaseSpeed();
        assertEquals(2, at.getSpeed());
        assertEquals(1, at.getGear());   
    }

    /*
     *  Test toString method
     */
    @Test
    public void testToString(){
        AutomaticTransmission at = new AutomaticTransmission(2, 4 , 6, 8, 10);
        
        assertEquals("Transmission (speed = 0, gear = 0)", at.toString());
        
        at.increaseSpeed();
        assertEquals("Transmission (speed = 2, gear = 2)", at.toString());

        at.increaseSpeed();
        assertEquals("Transmission (speed = 4, gear = 3)", at.toString());

        at.increaseSpeed();
        assertEquals("Transmission (speed = 6, gear = 4)", at.toString());

        at.increaseSpeed();
        assertEquals("Transmission (speed = 8, gear = 5)", at.toString());

        at.increaseSpeed();
        assertEquals("Transmission (speed = 10, gear = 6)", at.toString());
    }
}
    // Transmission increaseSpeed();
    // Transmission decreaseSpeed();
    // int          getSpeed();
    // int          getGear();