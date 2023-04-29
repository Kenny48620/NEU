import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Unit Test for WaterBird class
 */
public class WaterBirdTest {

    /**
     * Create a WaterBird object and test if it works as expected 
     */
    @Test
    public void testConstructor(){

        String name = "water bird";
        boolean extinctStatus = false;

        // create an anonymous subclass of abstract class for testing
        WaterBird wb = new WaterBird("water bird", false){
            // dummy part because the methods are concrete 
        };

        assertEquals(name, wb.getName());
        assertEquals(extinctStatus, wb.getExtinctStatus());
        assertEquals(new ArrayList<String>(), wb.getBodyOfWater());
    }

    /**
     * Test the setter and getter for bodyOfWater field
     */
    @Test
    public void testSetterGetterOfbodyOfWater(){
        // create an anonymous subclass of abstract class for testing
        WaterBird wb = new WaterBird("water bird", false){
            // dummy part because the methods are concrete 
        };
        ArrayList<String> location = new ArrayList<>();
        location.add("ocean");
        location.add("river");

        // setter
        wb.addBodyOfWater("ocean");
        wb.addBodyOfWater("river");
        // getter
        assertEquals(location, wb.getBodyOfWater());
    }

}
