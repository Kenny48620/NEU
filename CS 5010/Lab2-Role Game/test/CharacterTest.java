package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * Test class for character
 */
public class CharacterTest {

    /**
     * Test Character constructor
     */
    @Test
    public void testHeadGearConstructor(){
        Character c = new Character("A", 1, 0);

        assertEquals("A", c.getName());
        assertEquals(1, c.attack());
        assertEquals(0, c.defense());
    }

    /**
     * Test seekGear() and the sub methods for rule 1
     */
    @Test
    public void testSeekGearRule1(){
        Character c = new Character("A", 1, 0);
        // only lack Head Gear
        HeadGear headGear = new HeadGear("Head Gear", 0, 1);

        c.pickUpGear(new HandGear("Hand1 Gear", 1, 0));
        c.pickUpGear(new HandGear("Hand2 Gear", 1, 0));

        c.pickUpGear(new FootGear("Foot1 Gear", 1, 0));
        c.pickUpGear(new FootGear("Foot2 Gear", 1, 0));

        List<ArmedGear> gearPool = new ArrayList<>();
        gearPool.add(new HandGear("None Gear", 1, 0));
        gearPool.add(headGear);
        gearPool.add(new FootGear("None Gear", 0, 1));

        ArmedGear seekGear  = c.seekGear(gearPool);
        assertEquals(headGear, seekGear);

        c = new Character("A", 1, 0);
        // only lack of one of Hand Gear
        HandGear handGear = new HandGear("Hand Gear", 5, 0);

        c.pickUpGear(new HeadGear("Head Gear", 0, 10));

        c.pickUpGear(new HandGear("Hand1 Gear", 1, 0));

        c.pickUpGear(new FootGear("Foot1 Gear", 1, 0));
        c.pickUpGear(new FootGear("Foot2 Gear", 1, 0));

        gearPool = new ArrayList<>();
        gearPool.add(new FootGear("None Gear", 1, 0));
        gearPool.add(new HeadGear("None Gear", 0, 1));
        gearPool.add(handGear);

        seekGear = c.seekGear(gearPool);
        assertEquals(handGear, seekGear);


        c = new Character("A", 1, 0);
        // only lack of one of Foot Gear
        FootGear FootGear = new FootGear("Foot Gear", 5, 0);

        c.pickUpGear(new HeadGear("Head Gear", 0, 10));

        c.pickUpGear(new HandGear("Hand1 Gear", 1, 0));
        c.pickUpGear(new HandGear("Hand2 Gear", 1, 0));

        c.pickUpGear(new FootGear("Foot1 Gear", 1, 0));

        gearPool = new ArrayList<>();
        gearPool.add(new HandGear("None Gear", 1, 0));
        gearPool.add(new HandGear("None Gear", 1, 0));
        gearPool.add(FootGear);
        gearPool.add(new HandGear("None Gear", 1, 0));

        seekGear = c.seekGear(gearPool);
        assertEquals(FootGear, seekGear);
    }

    /**
     * Test seekGear() and the sub methods for rule 2
     */
    @Test
    public void testSeekGearRule2(){
        Character c = new Character("A", 1, 0);
        // leave two empty slots
        FootGear FootGear = new FootGear("Foot Gear", 10, 0);

        c.pickUpGear(new HeadGear("Head Gear", 0, 10));

        c.pickUpGear(new HandGear("Hand1 Gear", 1, 0));
        c.pickUpGear(new HandGear("Hand2 Gear", 1, 0));

        List<ArmedGear> gearPool = new ArrayList<>();
        gearPool.add(new HandGear("None Gear", 1, 0));
        gearPool.add(new HandGear("None Gear", 9, 0));
        gearPool.add(FootGear);
        gearPool.add(new HandGear("None Gear", 8, 0));
        gearPool.add(new HandGear("None Gear", 3, 0));

        ArmedGear seekGear = c.seekGear(gearPool);
        assertEquals(FootGear, seekGear);
    }

    /**
     * Test seekGear() and the sub methods for rule 3
     */
    @Test
    public void testSeekGearRule3(){
        Character c = new Character("A", 1, 0);
        // leave two empty slots
        FootGear FootGear = new FootGear("Foot Gear", 10, 10);

        c.pickUpGear(new HeadGear("Head Gear", 0, 10));

        c.pickUpGear(new HandGear("Hand1 Gear", 1, 0));
        c.pickUpGear(new HandGear("Hand2 Gear", 1, 0));

        List<ArmedGear> gearPool = new ArrayList<>();
        gearPool.add(new HandGear("None Gear", 1, 0));
        gearPool.add(new HandGear("None Gear", 10, 0));
        gearPool.add(FootGear);
        gearPool.add(new HandGear("None Gear", 8, 0));
        gearPool.add(new HandGear("None Gear", 3, 0));

        ArmedGear seekGear = c.seekGear(gearPool);
        assertEquals(FootGear, seekGear);
    }

    /**
     * Test seekGear() and the sub methods for rule 4
     */
    @Test
    public void testSeekGearRule4(){
        Character c = new Character("A", 1, 0);
        // leave two empty slots
        FootGear FootGear1 = new FootGear("Foot Gear1", 10, 10);
        FootGear FootGear2 = new FootGear("Foot Gear2", 10, 10);
        FootGear FootGear3 = new FootGear("Foot Gear3", 10, 10);
        FootGear FootGear4 = new FootGear("Foot Gear4", 10, 10);
        

        c.pickUpGear(new HeadGear("Head Gear", 0, 10));

        c.pickUpGear(new HandGear("Hand1 Gear", 1, 0));
        c.pickUpGear(new HandGear("Hand2 Gear", 1, 0));

        Set<ArmedGear> set = new HashSet<>();
        set.add(FootGear1);
        set.add(FootGear2);
        set.add(FootGear3);
        set.add(FootGear4);

        List<ArmedGear> gearPool = new ArrayList<>();
        gearPool.add(FootGear1);
        gearPool.add(FootGear2);
        gearPool.add(FootGear3);
        gearPool.add(FootGear4);

        ArmedGear seekGear;  
        for (int i=0; i<gearPool.size(); i++){
            seekGear= c.seekGear(gearPool);
            set.remove(seekGear);
        }

        assertEquals(2, set.size());
    }
    /**
     * Test pickUpGear()
     */
    @Test
    public void testPickUpGear(){
        Character c = new Character("A", 0, 0);
        List<ArmedGear> gearPool = new ArrayList<>();

        HeadGear head = new HeadGear("Head Gear", 0, 1);

        HandGear hand0 = new HandGear("Hand1 Gear", 1, 0);
        HandGear head1 = new HandGear("Hand1 Gear", 1, 0);

        FootGear foot0 = new FootGear("Foot Gear1", 10, 10);
        FootGear foot1 = new FootGear("Foot Gear1", 10, 10);

        c.pickUpGear(head);
        assertEquals(0, c.attack());assertEquals(1, c.defense());

        c.pickUpGear(hand0);
        assertEquals(1, c.attack());assertEquals(1, c.defense());

        c.pickUpGear(head1);
        assertEquals(2, c.attack());assertEquals(1, c.defense());

        c.pickUpGear(foot0);
        assertEquals(12, c.attack());assertEquals(11, c.defense());

        c.pickUpGear(foot1);
        assertEquals(22, c.attack());assertEquals(21, c.defense());
    }
}
