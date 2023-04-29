import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Unit Test for Bird class
 */
public class BirdTest {
    /**
     * Create a Bird object and test if it works as expected 
     */
    @Test
    public void testConstructor(){

        String  name = "bird";
        boolean extinctStatus = false;
        String  type = "bird";
        int     wings = 2;
        ArrayList<String> characList = new ArrayList<>();
        ArrayList<String> foodPreference = new ArrayList<>();

        // create an anonymous subclass of abstract class for testing
        Bird b = new Bird(type, extinctStatus) {
           // dummy part because the methods are concrete 
        };

        assertEquals(name, b.getName());
        assertEquals(extinctStatus, b.getExtinctStatus());
        assertEquals(type, b.getType());
        assertEquals(wings, b.getWings());
        assertEquals(characList, b.getCharacList());
        assertEquals(foodPreference, b.getFoodList());
    }
    
    /**
     * Test setter and getter for type
     */
    @Test
    public void testSetterGetterForType(){
        // create an anonymous subclass of abstract class for testing
        Bird b = new Bird("bird", false) {
           // dummy part because the methods are concrete 
        };

        b.setType("Owl");
        assertEquals("Owl", b.getType());
        
    }

    /**
     * Test setter and getter for wings
     */
    @Test
    public void testSetterGetterForWings(){
        Bird b = new Bird("bird", false) {
        };

        b.setWings(0);
        assertEquals(0, b.getWings());
    }

    /**
     * Test setter and getter for foodList and also the gettter of all food string
     * addFoodToList(String food)
     * String getAllFood()
     * List<String> getFoodList()
     */
    @Test
    public void testSetterGetterForFoodListAndAllFood(){
        Bird b = new Bird("bird", false) {
        };
        ArrayList<String> foodList = new ArrayList<>();
        b.addFoodToList("seeds");
        b.addFoodToList("buds");
        foodList.add("seeds");
        foodList.add("buds");

        String preference = "";
        for (String p:foodList){
            preference += p + ",";
        }
        if (preference.length()>2){
            preference = preference.substring(0, preference.length()-1);
        }

        assertEquals(foodList, b.getFoodList());
        assertEquals(preference, b.getAllFood());
    }

    /**
     * Test setter and getter for characList and also for getAllCharacteristic()
     * addCharacteristic(String characteristic)
     * List<String> getCharacList()
     * String getAllCharacteristic()
     */
    @Test
    public void testSetterGetterForCharacListAndAllCharacteristic(){
        Bird b = new Bird("bird", false) {
        };
        ArrayList<String> charList = new ArrayList<>();

        b.addCharacteristic("blue"); charList.add("blue");
        b.addCharacteristic("sharp");charList.add("sharp");
        b.addCharacteristic("hooked beaks with visible nostrils");charList.add("hooked beaks with visible nostrils");

        assertEquals(charList, b.getCharacList());

        String all = "";
        for (String c: charList){
            all +=  c+"\n";
        }

        assertEquals(all, b.getAllCharacteristic());
    }

    /**
    * Test setter and getter for isExtinct
    */
    @Test
    public void testSetterGetterForIsExtinct(){
        Bird b = new Bird("bird", false) {
        };
        b.setExtinctStatus(true);

        assertEquals(true, b.getExtinctStatus());
    }

    /**
    * Test setter and getter for aviaryNum
    */
    @Test
    public void testSetterGetterForAviaryNum(){
        Bird b = new Bird("bird", false) {
        };
        b.setAviaryNumber(2);
        assertEquals(2, b.getAviaryNumber());
    }

    /**
    * Test setter and getter for name
    */
    @Test
    public void testSetterGetterForName(){
        Bird b = new Bird("bird", false) {
        };
        b.setName("duck");
        assertEquals("duck", b.getName());
    }

    /**
    * Test toString methid 
    */
    @Test
    public void testToString(){
        Bird b = new Bird("bird", false) {
        };
        assertEquals("bird", b.toString());
    }

}
