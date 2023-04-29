import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;
/**
 * Unit Test for Shorebird class
 */
public class ShorebirdTest {
    /**
     * Create a Shorebird object and test if it works as expected 
     */
    @Test
    public void testConstructor(){

        String  name = "great auk";
        boolean extinctStatus = false;
        Shorebird greatAuk = new Shorebird("great auk", false);

        // add characcteristic 
        ArrayList<String> charList = new ArrayList<>();
        charList.add("one of the very most extensive bird orders");
        charList.add("there are about 350 bird species in it");
        charList.add("these birds have varied in size from 0.006 to 4.4 pounds");

        // add bodyOfWater they're living 
        ArrayList<String> bodyOfWater = new ArrayList<>();
        bodyOfWater.add("wetlands");
        bodyOfWater.add("freshwater");
        bodyOfWater.add("saltwater");
        bodyOfWater.add("shorelands");
        bodyOfWater.add("ocean");

        // add food preference
        ArrayList<String> foodPreference = new ArrayList<>();
        foodPreference.add("fish");
        foodPreference.add("seeds");
        foodPreference.add("insects");
        foodPreference.add("aquatic invertebrates");

        assertEquals(name, greatAuk.getName());
        assertEquals(extinctStatus, greatAuk.getExtinctStatus());
        assertEquals("Shorebird", greatAuk.getType());
        assertEquals(charList,greatAuk.getCharacList());
        assertEquals(bodyOfWater,greatAuk.getBodyOfWater());
        assertEquals(foodPreference,greatAuk.getFoodList());

    }
}
