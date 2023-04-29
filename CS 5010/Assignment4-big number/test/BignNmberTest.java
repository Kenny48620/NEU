package bignumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
/**
 * This class is a Unit Test for BigNumberImpl
 */
public class BignNmberTest {
    /**
     *  Test constructor for default 
     */
    @Test
    public void testBignumberDefault(){
        BigNumber bn = new BigNumberImpl();
        
        assertNotNull(bn);
        assertEquals(1, bn.length());
        assertEquals("0", bn.toString());
    }
    /**
     * Test constructor if number = null
     */
    @Test (expected = IllegalArgumentException.class)
    public void testBignumberIllegalArgumentException1(){
        new BigNumberImpl(null);
    }
    /**
     * Test constructor if number is empty
     */
    @Test (expected = IllegalArgumentException.class)
    public void testBignumberIllegalArgumentException2(){
        new BigNumberImpl("");
    }
    /**
     * Test constructor if number is negative
     */
    @Test (expected = IllegalArgumentException.class)
    public void testBignumberIllegalArgumentException3(){
        new BigNumberImpl("-12345");
    }
    /**
     * Test constructor if number contains a in valid digit
     */
    @Test (expected = IllegalArgumentException.class)
    public void testBignumberIllegalArgumentException4(){
        new BigNumberImpl("12a345");
    }
    /**
     * Test constructor 
     */
    @Test
    public void testBignumber(){
        BigNumber bn = new BigNumberImpl("12345");
        assertNotNull(bn);
        assertEquals(5, bn.length());
        assertEquals("12345", bn.toString());
    }
    /**
     * Test length()
     */
    @Test
    public void testlength(){
        BigNumber bn = new BigNumberImpl("0");

        assertEquals(1, bn.length());
        bn = new BigNumberImpl("123456789123456789123456789");
        assertEquals(27, bn.length());
    }
    /**
     * Test shiftLeft() for negative move
     */
    @Test
    public void testshiftLeftForNegative(){
        BigNumber bn = new BigNumberImpl("123");
        bn.shiftLeft(-3);
        assertEquals("0", bn.toString());
    }
    /**
     * Test shiftLeft() if number is zero
     */
    @Test
    public void testshiftLeftIfNumberZero(){
        BigNumber bn = new BigNumberImpl("0");
        bn.shiftLeft(3);
        assertEquals("0", bn.toString());
    }
    /**
     * Test shiftLeft()
     */
    @Test
    public void testshiftLeft2(){
        BigNumber bn = new BigNumberImpl("123");
        bn.shiftLeft(10);
        assertEquals("1230000000000", bn.toString());
    }
    /**
     * Test shiftRight() for negative move
     */
    @Test
    public void testshiftRightForNegative(){
        BigNumber bn = new BigNumberImpl("456");
        bn.shiftRight(-3);
        assertEquals("456000", bn.toString());
    }
    /**
     * Test shiftRight() 
     */
    @Test
    public void testshiftRightIfNumberZero(){
        BigNumber bn = new BigNumberImpl("0");
        bn.shiftRight(100);
        assertEquals("0", bn.toString());     
    }
    /**
     * Test shiftRight() if the number of shifts is greater than the length 
     */
    @Test
    public void testshiftRight2(){
        BigNumber bn = new BigNumberImpl("123456");
        bn.shiftRight(100);
        assertEquals("0", bn.toString());    
    }
    /**
     * Test shiftRight() 
     */
    @Test
    public void testshiftRight3(){
        BigNumber bn = new BigNumberImpl("1000000001000000000000000000000000000000");
        bn.shiftRight(30);
        assertEquals("1000000001", bn.toString());  
    }
    
    /**
     * Test addDigit() if the argument is not valid, which is < 0
     */
    @Test (expected = IllegalArgumentException.class)
    public void testtaddDigitIllegalArgumentException1(){
        BigNumber bn = new BigNumberImpl("12345678901213123213");
        bn.addDigit(-4);
    }
    /**
     * Test addDigit() if the argument is not valid, which is > 9
     */
    @Test (expected = IllegalArgumentException.class)
    public void testaddDigitIllegalArgumentException2(){
        BigNumber bn = new BigNumberImpl("12345678901213123213");
        bn.addDigit(10);
    }
    /**
     * Test addDigit() for adding carry
     */
    @Test
    public void testaddDigitForAddingCarry(){
        BigNumber bn = new BigNumberImpl("9999999999");
        bn.addDigit(1);
        assertEquals("10000000000", bn.toString());                       
    }
    /**
     * Test addDigit()
     */
    @Test
    public void testaddDigit(){
        BigNumber bn = new BigNumberImpl("12345678910");
        bn.addDigit(8);
        assertEquals("12345678918", bn.toString());      
        bn.addDigit(9);
        assertEquals("12345678927", bn.toString());     
    }
    /**
     * Test getDigitAt() if position less than zero
     */
    @Test (expected = IllegalArgumentException.class)
    public void testgetDigitAtIllegalArgumentException1(){
        new BigNumberImpl("12345678910").getDigitAt(-2);  
    }

    /**
     * Test getDigitAt() if position greater than the length
     */
    @Test (expected = IllegalArgumentException.class)
    public void testgetDigitAtIllegalArgumentException2(){
        new BigNumberImpl("12345678910").getDigitAt(100);  
    }
    /**
     * Test getDigitAt() 
     */
    @Test
    public void testgetDigit(){
        BigNumber bn = new BigNumberImpl("12345678910");
      
        assertEquals(0, bn.getDigitAt(0));
        assertEquals(1, bn.getDigitAt(1));   
        assertEquals(7, bn.getDigitAt(4));   
        assertEquals(6, bn.getDigitAt(5));   
        assertEquals(1, bn.getDigitAt(10));        
    }
    /**
     * Test copy()
     */   
    @Test
    public void testcopy(){
        BigNumber bn   = new BigNumberImpl("123123123123123123123123213242556674232425678910");
        BigNumber copy = bn.copy();

        assertFalse(bn == copy);
        assertEquals(bn.toString(), copy.toString());
        assertEquals(0, bn.compareTo(copy));
    }
    /**
     * Test add() with the same length
     */
    @Test
    public void testadd(){
        BigNumber bn1 = new BigNumberImpl("100000000000000000000000000000000000000000000009");
        BigNumber bn2 = new BigNumberImpl("100000000000000000000000000000000000000000000001");
        BigNumber sum = bn1.add(bn2);

        assertEquals("200000000000000000000000000000000000000000000010", sum.toString());
    }
    /**
     * Test add() with the different length
     */
    @Test
    public void testadd1(){
        BigNumber bn1 = new BigNumberImpl("1");
        BigNumber bn2 = new BigNumberImpl("999999999999999999999999999999999999");
        BigNumber sum = bn1.add(bn2);

        assertEquals("1000000000000000000000000000000000000", sum.toString());
    }
    /**
     * Test add() with the different length
     */
    @Test
    public void testadd2(){
        BigNumber bn1 = new BigNumberImpl("999999999999999999999999999999999999");
        BigNumber bn2 = new BigNumberImpl("1");
        BigNumber sum = bn1.add(bn2);

        assertEquals("1000000000000000000000000000000000000", sum.toString());
    }
    /**
     * Test compareTo() for same object
     */
    @Test
    public void testcompareTo1(){
        BigNumber bn1 = new BigNumberImpl("999999999999999999999999999999999999");
        assertEquals(0, bn1.compareTo(bn1));
    }
    /**
     * Test compareTo() for another greater 
     */
    @Test
    public void testcompareTo2(){
        BigNumber bn1 = new BigNumberImpl("999999999999999999999999999999999999");
        BigNumber bn2 = new BigNumberImpl("99999999999999999999999999999999999");
        assertEquals(1, bn1.compareTo(bn2));
    }
    /**
     * Test compareTo() for another smaller
     */
    @Test
    public void testcompareTo3(){
        BigNumber bn1 = new BigNumberImpl("1");
        BigNumber bn2 = new BigNumberImpl("7823912731279471892471249147412894712847");
        assertEquals(-1, bn1.compareTo(bn2));
    }
    /**
     * Test compareTo() for another same
     */
    @Test
    public void testcompareTo4(){
        BigNumber bn1 = new BigNumberImpl("812379127398213792173912838712987321844241729");
        BigNumber bn2 = new BigNumberImpl("812379127398213792173912838712987321844241729");
        assertEquals(0, bn1.compareTo(bn2));
    }
    /**
     * Test toString()
     */
    @Test
    public void testtoString(){
        BigNumber bn1 = new BigNumberImpl("739123381238641723182312397128312831283712871274824719312");
        BigNumber bn2 = new BigNumberImpl("5678631236813727462195697381927581751283612936127");

        assertEquals("739123381238641723182312397128312831283712871274824719312", bn1.toString());
        assertEquals("5678631236813727462195697381927581751283612936127", bn2.toString());
    }
}
