import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
/**
 * Unit Test for Pigeon
 */
public class PigeonTest {
    /**
     * Create a Pigeon object and test if it works as expected 
     */
    @Test
    public void testConstructor(){

        String  name = "runt";
        boolean extinctStatus = false;
        Pigeon runt = new Pigeon("runt", false);

        // add the characteristic
        ArrayList<String> charList= new ArrayList<>();
        charList.add("feeding their young \"bird milk\" very similar to the milk of mammals");
        // add food preference
        ArrayList<String> foodPreference= new ArrayList<>();
        foodPreference.add("nuts");
        foodPreference.add("eggs");
        foodPreference.add("fruit");
        foodPreference.add("berries");

        assertEquals(name, runt.getName());
        assertEquals(extinctStatus, runt.getExtinctStatus());
        assertEquals("Pigeon", runt.getType());
        assertEquals(charList, runt.getCharacList());
        assertEquals(foodPreference, runt.getFoodList());

    }
}
