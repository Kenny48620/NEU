package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
/**
 * Test class for gears group
 */
public class GearsTest {

    /**
     * Test HeadGear constructor
     */
    @Test
    public void testHeadGearConstructor(){
        HeadGear gear = new HeadGear("Head Gear", 0, 5);

        assertEquals("Head Gear", gear.getName());
        assertEquals(0, gear.getAttack());
        assertEquals(5, gear.getDefense());
    }

    /**
     * Test HeadGear constructor IllegalArgumentException
     */
    @Test 
    public void testHeadGearConstructorIllegalArgumentException(){
     //   HeadGear gear = new HeadGear("Head Gear", 0, 0);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            // Call the method with an invalid argument
            HeadGear gear = new HeadGear("Head Gear", 1, 5);
        });

        assertEquals("Error: attack should be zero for HeadGear", e.getMessage());
    }

    /**
     * Test HandHear construcotr
     */
    @Test
    public void testHandGearConstructor(){
        HandGear gear = new HandGear("Hand Gear", 5, 0);

        assertEquals("Hand Gear", gear.getName());
        assertEquals(5, gear.getAttack());
        assertEquals(0, gear.getDefense());
    }

    /**
     * Test HeadGear constructor IllegalArgumentException
     */
    @Test 
    public void testHandGearConstructorIllegalArgumentException(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            // Call the method with an invalid argument
            HandGear gear = new HandGear("Hand Gear", 1, 5);
        });

        assertEquals("Error: defense should be zero for HandGear", e.getMessage());
    }
    /**
     * Test FootGear constructor
     */
    @Test
    public void testFootGearConstructor(){
        FootGear gear = new FootGear("Foot Gear", 5, 5);

        assertEquals("Foot Gear", gear.getName());
        assertEquals(5, gear.getAttack());
        assertEquals(5, gear.getDefense());

    }

    /**
     * Test getAdjective()
     */
    @Test
    public void testGetAdjective(){
        FootGear gear     = new FootGear("A B C Gear", 5, 5);
        List<String> copy = new ArrayList<>();
        copy.add("A");copy.add("B");copy.add("C");

        assertEquals(copy, gear.getAdjective());
    }

    /**
     * Test combineWith() with HeadGear and exception
     */
    @Test
    public void testCombineWithHeadGearAndException(){
        HeadGear gear0   = new HeadGear("Head0 Gear", 0, 5);
        HeadGear gear1   = new HeadGear("Head1 Gear", 0, 5);
        HeadGear newGear = (HeadGear) gear0.combineWith(gear1);

        assertEquals("Head1 , Head0 Gear", newGear.getName());
        assertEquals(0, newGear.getAttack());
        assertEquals(10, newGear.getDefense());

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            // Call the method with an invalid argument
            newGear.combineWith(new HandGear("Hand Gear", 3, 0));
        });
    }

    /**
     * Test combineWith() with HandGear and exception
     */
    @Test
    public void testCombineWithHandGearAndException(){
        HandGear gear0   = new HandGear("Hand0 Gear", 5, 0);
        HandGear gear1   = new HandGear("Hand1 Gear", 5, 0);
        HandGear newGear = (HandGear) gear0.combineWith(gear1);

        assertEquals("Hand1 , Hand0 Gear", newGear.getName());
        assertEquals(10, newGear.getAttack());
        assertEquals(0, newGear.getDefense());

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            // Call the method with an invalid argument
            newGear.combineWith(new FootGear("Foot Gear", 3, 0));
        });
    }

    /**
     * Test combineWith() with FootGear and exception
     */
    @Test
    public void testCombineWithFootGearAndException(){
        FootGear gear0   = new FootGear("Foot0 Gear", 5, 5);
        FootGear gear1   = new FootGear("Foot1 Gear", 5, 5);
        FootGear newGear = (FootGear) gear0.combineWith(gear1);

        assertEquals("Foot1 , Foot0 Gear", newGear.getName());
        assertEquals(10, newGear.getAttack());
        assertEquals(10, newGear.getDefense());

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            // Call the method with an invalid argument
            newGear.combineWith(new HeadGear("Head Gear",0, 5));
        });
    }

}
