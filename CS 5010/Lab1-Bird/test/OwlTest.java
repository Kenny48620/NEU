import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
/**
 * Unit Test for Owl class
 */
public class OwlTest {
    /**
     * Create a Owl object and test if it works as expected 
     */
    @Test
    public void testConstructor(){

        String  name = "Snowy Owl";
        boolean extinctStatus = false;
        Owl snowy = new Owl("Snowy Owl", false);

        ArrayList<String> charList= new ArrayList<>();
        ArrayList<String> foodPreference= new ArrayList<>();

        // add the characteristic
        charList.add("distinguished by the facial disks that frame the eyes and bill");

        // add food preference
        foodPreference.add("small mammals");
        foodPreference.add("seeds");
        foodPreference.add("insects");
        foodPreference.add("fish");

        assertEquals(name, snowy.getName());
        assertEquals(extinctStatus, snowy.getExtinctStatus());
        assertEquals("Owl", snowy.getType());
        assertEquals(charList, snowy.getCharacList());
        assertEquals(foodPreference, snowy.getFoodList());

    }
}
