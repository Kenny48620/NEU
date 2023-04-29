import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
/**
 * Unit Test for BirdsOfPrey class
 */
public class BirdsOfPreyTest {
    /**
     * Create a BirdsOfPrey object and test if it works as expected 
     */
    @Test
    public void testConstructor(){

        String  name = "eagle";
        boolean extinctStatus = true;
        BirdsOfPrey eagle = new BirdsOfPrey("eagle", true);

        ArrayList<String> charList= new ArrayList<>();
        ArrayList<String> foodPreference= new ArrayList<>();

        // add the characteristic
        charList.add("sharp");
        charList.add("hooked beaks with visible nostrils");

        // add food preference
        foodPreference.add("eggs");
        foodPreference.add("other birds");
        foodPreference.add("small mammals");
        foodPreference.add("insects");

        assertEquals(name, eagle.getName());
        assertEquals(extinctStatus, eagle.getExtinctStatus());
        assertEquals("BirdsOfPrey", eagle.getType());
        assertEquals(charList, eagle.getCharacList());
        assertEquals(foodPreference, eagle.getFoodList());
    }
}
