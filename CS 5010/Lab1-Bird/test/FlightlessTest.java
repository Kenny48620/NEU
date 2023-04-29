import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
/**
 * Unit Test for Flightless class
 */
public class FlightlessTest {
    /**
     * Create a Flightless object and test if it works as expected 
     */
    @Test
    public void testConstructor(){

        String  name = "kiwis";
        boolean extinctStatus = true;
        Flightless kiwis = new Flightless("kiwis", true);

        ArrayList<String> charList= new ArrayList<>();
        ArrayList<String> foodPreference= new ArrayList<>();

        // add the characteristic
        charList.add("live on the ground");
        charList.add("have no wings");

        // add food preference
        foodPreference.add("buds");
        foodPreference.add("seeds");
        foodPreference.add("nuts");
        foodPreference.add("berries");

        assertEquals(name, kiwis.getName());
        assertEquals(extinctStatus, kiwis.getExtinctStatus());
        assertEquals("Flightless", kiwis.getType());
        assertEquals(0,kiwis.getWings());
        assertEquals(charList, kiwis.getCharacList());
        assertEquals(foodPreference, kiwis.getFoodList());
    }
}
