package lookandsay;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
/**
 * This class is a test class for LookAndSayIterator.java
 */
public class LookAndSayIteratorTest {
    /**
     * Test default seed and end value
     */
    @Test
    public void testDefaultSeed(){
        LookAndSayIterator it = new LookAndSayIterator();
        String[] b = new String[5];
        b[0] = "1";b[1] = "11";b[2]="21";
        b[3] = "1211"; b[4] = "111221";
        int i = 0;
        while(it.hasNext() && i<5){
            assertEquals(new BigInteger(b[i]), it.next());
            i++;
        }
    }

    /**
     * Test default seed and end value for reverse
     */
    @Test
    public void testReverseDefaultSeed(){
        LookAndSayIterator it = new LookAndSayIterator(new BigInteger("111221"));
        String[] b = new String[5];
        b[0] = "1";b[1] = "11";b[2]="21";
        b[3] = "1211"; b[4] = "111221";
        int i = 4;
        while(it.hasPrevious() && i>=0){
            assertEquals(new BigInteger(b[i]), it.prev());
            i--;
        }
    }

    /**
     * Test custom seed 
     */
    @Test
    public void testCustomSeed(){
        LookAndSayIterator it = new LookAndSayIterator(new BigInteger("211"));

        String[] b = new String[5];
        b[0] = "211";b[1] = "1221";b[2]="112211";
        b[3] = "212221"; b[4] = "12113211";
        int i = 0;
        while(it.hasNext() && i<5){
            assertEquals(new BigInteger(b[i]), it.next());
            i++;
        }
    }

    /**
     * Test custom seed for reverse
     */
    @Test
    public void testReverseCustomSeed(){
        LookAndSayIterator it = new LookAndSayIterator(new BigInteger("111221131221"));

        String[] b = new String[6];
        b[0] = "211"; b[1] = "1221";b[2] = "112211";
        b[3]="212221";b[4] = "12113211"; b[5] = "111221131221";
        int i = 5;
        while(it.hasPrevious() && i>= 0){
            assertEquals(new BigInteger(b[i]), it.prev());
            i--;
        }
    }

    /**
     * Test custom seed and endValue
     */
    @Test
    public void testCustomSeedEnd(){
        LookAndSayIterator it = new LookAndSayIterator(new BigInteger("182"), new BigInteger("1113122118132113"));

        String[] b = new String[5];
        b[0] = "182";b[1] = "111812";b[2]="31181112";
        b[3] = "1321183112"; b[4] = "1113122118132112";
        int i = 0;
        while(it.hasNext()){
            assertEquals(new BigInteger(b[i]), it.next());
            i++;
        }
    }

    /**
     * Test custom seed and endValue for reverse
     */
    @Test
    public void testReverseCustomSeedEnd(){
        LookAndSayIterator it = new LookAndSayIterator(new BigInteger("1113122118132112"), new BigInteger("1113122118132113"));

        String[] b = new String[5];
        b[0] = "182";b[1] = "111812";b[2]="31181112";
        b[3] = "1321183112"; b[4] = "1113122118132112";
        int i = 4;
        while(it.hasPrevious()){
            assertEquals(new BigInteger(b[i]), it.prev());
            i--;
        }
    }
}
