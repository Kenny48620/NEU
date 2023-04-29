import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
/**
 * Unit Test for Parrot class
 */
public class ParrotTest {
    /**
     * Create a Parrot object and test if it works as expected 
     * Further, it also tests the setters and getters at the meantime 
     */
    @Test
    public void testConstructor(){

        String  name = "grayParrot";
        boolean extinctStatus = false;
        Set<String> wrordsSet = new HashSet<>();
        String  favWord = "";
        Parrot grayParrot = new Parrot("grayParrot", false);

        ArrayList<String> charList= new ArrayList<>();
        ArrayList<String> foodPreference= new ArrayList<>();
        // add the characteristic
        charList.add("have a short, curved beak and are known for their intelligence and ability to mimic sounds");
        charList.add("can learn a vocabulary of up to 100 words and often adopt a single favorite saying");
        // add food preference
        foodPreference.add("berries");
        foodPreference.add("seeds");
        foodPreference.add("vegetation");
        foodPreference.add("nuts");

        // add wordsSet
        grayParrot.addWord("Hello");
        wrordsSet.add("Hello");
        grayParrot.addWord("How");
        wrordsSet.add("How");
        grayParrot.addWord("Are");
        wrordsSet.add("Are");
        grayParrot.addWord("You");
        wrordsSet.add("You");
        // add favorite word
        grayParrot.setFavWord("Hello");
        favWord = "Hello";

        assertEquals(name, grayParrot.getName());
        assertEquals(extinctStatus, grayParrot.getExtinctStatus());
        assertEquals("Parrot", grayParrot.getType());
        assertEquals(charList, grayParrot.getCharacList());
        assertEquals(foodPreference, grayParrot.getFoodList());
        assertEquals(wrordsSet, grayParrot.getWords());
        assertEquals(favWord, grayParrot.getFavoriteWord());
    }
    /**
     * Test IllegalArgumentException in setFavWord() if the word is not in words set
     */
    @Test (expected = IllegalArgumentException.class)
    public void testsetFavWordIllegalArgumentException(){
        Parrot grayParrot = new Parrot("grayParrot", false);
        grayParrot.addWord("Hello");
        grayParrot.addWord("World");

        grayParrot.setFavWord("Hi");
    }
}
