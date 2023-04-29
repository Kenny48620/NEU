import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
/**
 * Unit Test for Waterfowl class
 */
public class WaterfowlTest {
    /**
     * Create a Waterflow object and test if it works as expected 
     */
    @Test
    public void testConstructor(){

        String  name = "duck";
        boolean extinctStatus = false;
        Waterfowl duck = new Waterfowl("duck", false);

        // add characteristic 
        ArrayList<String> characList = new ArrayList<>();
        characList.add("webbed");
        characList.add("feet");
        characList.add("round bodies");
        characList.add("long necks");
        characList.add("small wings");

        // add bodyOfWater they're living
        ArrayList<String> bodyOfWater = new ArrayList<>();
        bodyOfWater.add("fresh water source");
        bodyOfWater.add("salt water source");

        // add food preference
        ArrayList<String> foodPreference = new ArrayList<>();
        foodPreference.add("berries");
        foodPreference.add("fish");
        foodPreference.add("insects");
        foodPreference.add("aquatic invertebrates");

        assertEquals(name, duck.getName());
        assertEquals(extinctStatus, duck.getExtinctStatus());
        assertEquals("Waterfowl", duck.getType());
        assertEquals(characList, duck.getCharacList());
        assertEquals(bodyOfWater, duck.getBodyOfWater());
        assertEquals(foodPreference, duck.getFoodList());

    }
}
