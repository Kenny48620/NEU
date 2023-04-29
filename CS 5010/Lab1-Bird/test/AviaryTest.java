import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Unit Test for Bird class
 */
public class AviaryTest {
    /**
     * Create a Aviary object and test if it works as expected 
     * It will also test getAviary() as well
     */
    @Test
    public void testConstructor(){

        int houseDefault         = -1;
        int sizeDefault          = 0;
        Map<String, Integer> map = new HashMap<>();
        String typeDefault       = "";

        Aviary a = new Aviary();

        assertEquals(houseDefault, a.getHouseNum());
        assertEquals(sizeDefault, a.getSize());
        assertEquals(map, a.getFoodMap());
        assertEquals(typeDefault, a.getType());

        // check for array
        assertNotNull(a.getAviary());
        assertEquals(5, a.getAviary().length);
    }

    /**
     * Test for put() throwing IndexOutOfBoundsException
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testputIndexOutOfBoundsException(){
        Owl snowy1 = new Owl("Snowy Owl1", false);
        Owl snowy2 = new Owl("Snowy Owl2", false);
        Owl snowy3 = new Owl("Snowy Owl3", false);
        Owl snowy4 = new Owl("Snowy Owl4", false);
        Owl snowy5 = new Owl("Snowy Owl5", false);
        Owl snowy6 = new Owl("Snowy Owl6", false);

        Aviary a   = new Aviary();
        a.put(snowy1);a.put(snowy2);a.put(snowy3);
        a.put(snowy4);a.put(snowy5);a.put(snowy6);
    }

    /**
     * Test put() for FLIGHTLESS type 
     */
    @Test
    public void testput1(){
        Flightless emus = new Flightless("Emus", false);
        Aviary a   = new Aviary();
        a.put(emus);

        assertEquals("Flightless", a.getType());
    }

    /**
     * Test put() for BIRDS_OF_PREY type
     */
    @Test
    public void testput2(){
        BirdsOfPrey hawks = new BirdsOfPrey("Hawks", false);
        Aviary a   = new Aviary();
        a.put(hawks);
        assertEquals("BirdsOfPrey", a.getType());
    }
    /**
     * Test put() for WATERFOWL type
     */
    @Test
    public void testput3(){
        Waterfowl duck = new Waterfowl("Duck", false);
        Aviary a   = new Aviary();
        a.put(duck);
        assertEquals("Waterfowl", a.getType());
    }
    /**
     * Test put() for Other type
     */
    @Test
    public void testput4(){
        Parrot grayParrot = new Parrot("Gray Parrot", false);
        Aviary a   = new Aviary();
        a.put(grayParrot);
        assertEquals("", a.getType());
    }


    /**
     * 
     * Test testrecordFoodPeference() and the getter getFoodMap()
     * It tests testdisplayFoodList(), print method, as well
     */
    @Test
    public void testrecordFoodPeference(){
        Parrot grayParrot    = new Parrot("Gray Parrot", false);
        Pigeon runt          = new Pigeon("Runt", false);

        Aviary a   = new Aviary();
        a.setHouseNum(0);
        a.put(grayParrot);a.put(runt);
        a.recordFoodPeference(grayParrot);a.recordFoodPeference(runt);

        Map<String, Integer> foodMap = new HashMap<>();
        foodMap.put("berries", 2);
        foodMap.put("seeds", 1);       
        foodMap.put("vegetation", 1);       
        foodMap.put("nuts", 2);      
        foodMap.put("eggs", 1);     
        foodMap.put("fruit", 1);            


        String foodInfo = "Aviary " + a.getHouseNum() + " food list needs: "+foodMap.toString();
        
        assertEquals(foodMap, a.getFoodMap());
        assertEquals(foodInfo, a.displayFoodList());
    }
    /**
     * Test displayBirds()
     */    
    @Test
    public void testdisplayBirds(){
        Parrot grayParrot    = new Parrot("Gray Parrot", false);
        Pigeon runt          = new Pigeon("Runt", false);

        Aviary a   = new Aviary();
        a.setHouseNum(0);
        a.put(grayParrot); a.put(runt);
        String all = "Aviary "+0+ " has:\n" ;
        all += "Gray Parrot\nRunt\n";
        all += "-------------------------------";

        assertEquals(all, a.displayBirds());
    }
    
    /**
     * Test displayDetail()
     */   
    @Test
    public void testdisplayDetail(){
        Aviary     a = new Aviary();
        Pigeon runt  = new Pigeon("Runt", false);
        Owl    snowy = new Owl("Snowy Owl", false);

        a.put(runt);a.put(snowy);
        a.setHouseNum(0);

        String output = "Start to display the detail of Aviary 0\n";
        output       += "Slot 0: Runt\nCharacterics: \nfeeding their young \"bird milk\" very similar to the milk of mammals\nFood preference: nuts,eggs,fruit,berries\n\n";
        output       += "Slot 1: Snowy Owl\nCharacterics: \ndistinguished by the facial disks that frame the eyes and bill\nFood preference: small mammals,seeds,insects,fish\n\n";

        assertEquals(output, a.displayDetail());
    }
    /**
     * Test setter and getter for house number
     */   
    @Test
    public void testSetterGetterForHouseNumber(){
        Aviary a = new Aviary();
        a.setHouseNum(1);
        assertEquals(1, a.getHouseNum());

        a.setHouseNum(2);
        assertEquals(2, a.getHouseNum());
    }
    /**
     * Test setter and getter for type
     */   
    @Test
    public void testSetterGetterForType(){
        Aviary a = new Aviary();
        a.setType("Flightless");
        assertEquals("Flightless", a.getType());
    }
}
