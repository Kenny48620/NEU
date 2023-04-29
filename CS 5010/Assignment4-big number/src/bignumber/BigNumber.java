package bignumber;
/**
 * This is an interface BigNumber that can be used to represnt a really big number that in cannot hold.
 * It extends another interface Comparable.
 */
public interface BigNumber extends Comparable<BigNumber>{
    /**
     * Return the legnth of this big number
     * @return the legnth of this big number
     */
    int length();
    /**
     * Shift the number to left, which is multiplied by 10
     * @param numShift number of left shifts
     */
    void shiftLeft(int numShift);
    /**
     * Shift the number to left, which is divided by 10
     * @param numShift number of right shifts
     */
    void shiftRight(int numShift);
    /**
     * Takes a single digit as an argument and adds it to this number.
     * This method throws an IllegalArgumentException if the digit passed to it is not a single non-negative digit.
     * @param digit an int to be added
     */
    void addDigit(int digit);
    /**
     * Takes a position as an argument and returns the digit at that position. 
     * @param position  the rihgt most position that starts at zero
     * @return the digit at the position
     */
    int getDigitAt(int position);
    /**
     * Return a copy of this object
     * @return a object of bignumber
     */
    BigNumber copy();
    /**
     * Add two big number
     * @param bigNumber another bigNumber
     * @return a new bigNumber object that has the sum of the two big number
     */
    BigNumber add(BigNumber bignumber);
}
