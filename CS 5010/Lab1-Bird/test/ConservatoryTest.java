import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
/**
 * Unit Test for Conservatory class
 */
public class ConservatoryTest {

    
    private Conservatory c;    // Conservatory object
    private Flightless kiwis;  // extinct bird
    private Flightless emus;   // Flightless not extinct
    private BirdsOfPrey hawks; // BirdsOfPrey not extinct
    private Waterfowl duck;    // Waterfowl not extinct
    private Pigeon runt;       // Pigeon not extinct
    private Owl snowy;         // Owl not extinct



    /**
     *  Setting enviorment
     */
    @Before
    public void init(){
        c = new Conservatory();
        kiwis = new Flightless("Kiwis", true);
        emus  = new Flightless("Emus", false);
        hawks = new BirdsOfPrey("Hawks", false);
        duck  = new Waterfowl("Duck", false);
        runt  = new Pigeon("Runt", false);
        snowy = new Owl("Snowy Owl", false);
    }


    /**
     * Test for constructor
     */
    @Test
    public void testConstructor(){

        assertNotNull(c.getAviary());
        assertEquals(20, c.getAviary().length);
        assertEquals(new ArrayList<String>(), c.getbirdsRecord());

        // Test if constructor intialize array successfully
        Aviary[] a = c.getAviary();
        for (int i=0; i<20; i++){
            assertEquals(i, a[i].getHouseNum());
        }
        c.aviary = null;

    }
    /**
     * Test IllegalArgumentException if the bird is extinct
     */
    @Test (expected = IllegalArgumentException.class)
    public void testsendToAviaryIllegalArgumentException(){
        c.sendToAviary(kiwis);
    }

    /**
     * Test sendToAviary() case 0: send 3 special case birds type first then send 2 other type
     */
    @Test
    public void testsendToAviary(){
        c.sendToAviary(emus);c.sendToAviary(hawks);c.sendToAviary(duck);
        c.sendToAviary(runt);c.sendToAviary(snowy);

        // check the aviary to see if in it
        Aviary[] aviaries = c.getAviary();
        Bird[]   birds    = null;
        
        // check aviary type
        assertEquals("Flightless",aviaries[0].getType());
        // check the content
        birds = aviaries[0].getAviary();
        assertEquals("Emus",birds[0].getName());

        // check aviary type
        assertEquals("BirdsOfPrey",aviaries[1].getType());
        // check the content
        birds = aviaries[1].getAviary();
        assertEquals("Hawks",birds[0].getName());

        // check aviary type
        assertEquals("Waterfowl",aviaries[2].getType());
        // check the content
        birds = aviaries[2].getAviary();
        assertEquals("Duck",birds[0].getName());

        // check aviary type
        assertEquals("",aviaries[3].getType());
        // check the content
        birds = aviaries[3].getAviary();
        assertEquals("Runt",birds[0].getName());
        assertEquals("Snowy Owl",birds[1].getName());
    }

    /**
     * Test sendToAviary() case 1: send 2 other type fist, then send 3 special case birds type 
     */
    @Test
    public void testsendToAviary2(){
        c.sendToAviary(runt);c.sendToAviary(snowy);
        c.sendToAviary(emus);c.sendToAviary(hawks);c.sendToAviary(duck);

        // check the aviary to see if in it
        Aviary[] aviaries = c.getAviary();
        Bird[]   birds    = null;

        // check aviary type
        assertEquals("",aviaries[0].getType());
        // check the content
        birds = aviaries[0].getAviary();
        assertEquals("Runt",birds[0].getName());
        assertEquals("Snowy Owl",birds[1].getName());

        // check aviary type
        assertEquals("Flightless",aviaries[1].getType());
        // check the content
        birds = aviaries[1].getAviary();
        assertEquals("Emus",birds[0].getName());

        // check aviary type
        assertEquals("BirdsOfPrey",aviaries[2].getType());
        // check the content
        birds = aviaries[2].getAviary();
        assertEquals("Hawks",birds[0].getName());

        // check aviary type
        assertEquals("Waterfowl",aviaries[3].getType());
        // check the content
        birds = aviaries[3].getAviary();
        assertEquals("Duck",birds[0].getName());
    }
    /**
     *  Test testdisplayAviary() IllegalArgumentException if aviary number is < 0
     */
    @Test (expected = IllegalArgumentException.class)
    public void testdisplayAviaryIllegalArgumentException1(){
        c.displayAviary(-1);
    }
    /**
     *  Test testdisplayAviary() IllegalArgumentException if aviary number is >= 20
     */
    @Test (expected = IllegalArgumentException.class)
    public void testdisplayAviaryIllegalArgumentException2(){
        c.displayAviary(20);
    }

    /**
     * Test displayAviary()
     */
    @Test
    public void testdisplayAviary(){
        c.sendToAviary(emus);c.sendToAviary(hawks);

        Aviary[] aviaries = c.getAviary();
        Bird[]   birds  = aviaries[0].getAviary();

        String Output0 = "Aviary 0 has:\n" ;
        Output0 += birds[0] + "\n";
        Output0 += "-------------------------------";

        assertEquals(Output0, c.displayAviary(0));
    }
    /**
     * Test displayAllAviaries()
     */
    @Test
    public void testdisplayAllAviaries(){
        c.sendToAviary(emus);c.sendToAviary(hawks);
        c.sendToAviary(runt);c.sendToAviary(snowy);
        Aviary[] aviaries = c.getAviary();

        String output = "";

        for (int i=0; i < 20; i++){
            output += aviaries[i].displayBirds();
        }

        assertEquals(output, c.displayAllAviaries());
    }
    /**
     * Test displayByAlphOrder() and also for the private method recordBirdLoc() inside sendToAviary()
     */
    @Test
    public void testdisplayByAlphOrder(){
        c.sendToAviary(runt);c.sendToAviary(snowy);
        c.sendToAviary(emus);c.sendToAviary(hawks);c.sendToAviary(duck);

        ArrayList<String> byOrder = new ArrayList<>();
        byOrder.add("Runt at aviary 0");byOrder.add("Snowy Owl at aviary 0");
        byOrder.add("Emus at aviary 1");byOrder.add("Hawks at aviary 2");byOrder.add("Duck at aviary 3");

        String output = "";
        Collections.sort(byOrder);
        for (String bird: byOrder){
            output += bird.toString();
        }

        assertEquals(output, c.displayByAlphOrder());
    }
    /**
     * Test initAviary()
     */
    @Test
    public void testinitAviary(){

        // Test if constructor intialize array successfully
        Aviary[] a = c.getAviary();
        for (int i=0; i<20; i++){
            assertEquals(i, a[i].getHouseNum());
        }
    }

    /**
     * Test displayAviaryInDetail()
     */
    @Test
    public void testdisplayAviaryInDetail(){
        c.sendToAviary(runt);c.sendToAviary(snowy);

        String output = "Start to display the detail of Aviary 0\n";
        output       += "Slot 0: Runt\nCharacterics: \nfeeding their young \"bird milk\" very similar to the milk of mammals\nFood preference: nuts,eggs,fruit,berries\n\n";
        output       += "Slot 1: Snowy Owl\nCharacterics: \ndistinguished by the facial disks that frame the eyes and bill\nFood preference: small mammals,seeds,insects,fish\n\n";

        assertEquals(output, c.displayAviaryInDetail(0));
    }
}
