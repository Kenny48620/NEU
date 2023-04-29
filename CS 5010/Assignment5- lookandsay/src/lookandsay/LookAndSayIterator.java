package lookandsay;

import java.math.BigInteger;
import java.util.Iterator;
/**
 * This class is to implement A look-and-say sequence by implement RIterator.
 * The user can call next() to get next look-and-say sequence or call 
 * prev() to get the sequence in reverse order.
 */
public class LookAndSayIterator implements RIterator<BigInteger>{

    private static final int        END_VALUE_SIZE    = 100;                         // size of DEFAULT_END_VALUE
    private static final BigInteger DEFAULT_END_VALUE = getEndValue(END_VALUE_SIZE); // default end value for constructor
    private static final BigInteger DEFAULT_SEED      = BigInteger.ONE;              // default seed for constructor
    private static final BigInteger LOWER_BOUND       = BigInteger.TEN;              // lower bound for hasPrevious operation

    private BigInteger cursor;         // current number
    private final BigInteger endValue; // the max value
    private boolean hasPre;            // check condition if has previous

    /**
     * Construstor
     */
    public LookAndSayIterator(){
        this(DEFAULT_SEED, DEFAULT_END_VALUE);
    }

    /**
     * Construstor that takes a seed argument 
     * @param seed a start number
     */
    public LookAndSayIterator(BigInteger seed){
        this(seed, DEFAULT_END_VALUE);
    }

    /**
     * Construstor that takes a seed and a endValue argument
     * @param seed a start number
     * @param endValue max value
     */
    public LookAndSayIterator(BigInteger seed, BigInteger endValue){
        checkIllegalArgumentException(seed, endValue);
        this.cursor   = seed;
        this.endValue = endValue;
        this.hasPre   = true;
    }

    /**
     * Return true if the next number to be returned is still lesser 
     * than end (specified in the constructors), false otherwise.
     * @return if the number have next sequence
     */
    @Override
    public boolean hasNext() {
        return cursor.compareTo(endValue) < 0; // return true if cursor <= endValue
    }

    /**
     * Return the current number in the sequence and advance to the next number.
     * @return next sequence number
     */
    @Override
    public BigInteger next() {
        String        prevCursor = cursor.toString();   // convert the cursor to string
        StringBuilder nextCursor = new StringBuilder(); // store next cursor 
        BigInteger    retCursor  = cursor;              // store the cursor that will be returned

        int  count = 1;                                 // count digit
        char digit = prevCursor.charAt(0);       // current digit

        for (int i=1; i<prevCursor.length(); i++){
            // if different than current digit, apply the result and re-count new one
            if (digit != prevCursor.charAt(i)){
                nextCursor.append(count); // count comes first
                nextCursor.append(digit); // then digit
                
                count  = 1;
                digit  = prevCursor.charAt(i);
            }else{
                count++;
            }
        }
        nextCursor.append(count);
        nextCursor.append(digit);

        cursor = new BigInteger(nextCursor.toString()); // update cursor
        return retCursor; 
    }

    /**
     * Return true if it is possible to go back one step, false otherwise
     * @return if the number can go back
     */
    @Override
    public boolean hasPrevious() {
        return hasPre;
    }

    /**
     * Return the current number in the sequence and retreat to the previous number.
     * @return previous number
     */
    @Override
    public BigInteger prev() {
        String        prevCursor = cursor.toString();   // convert the cursor to string
        StringBuilder nextCursor = new StringBuilder(); // store next cursor 
        BigInteger    retCursor  = cursor;              // store the cursor that will be returned

        // if < 10 or even number, return current cursor.
        if (cursor.compareTo(LOWER_BOUND) == -1 || cursor.toString().length() % 2 != 0){
            hasPre = false;
            return cursor;
        }
        
        for (int i=1; i<prevCursor.length(); i+=2){
            int  count = prevCursor.charAt(i-1)-'0'; // count digit
            char digit = prevCursor.charAt(i);       // current digit
            for (int j=0; j<count; j++){
                nextCursor.append(digit);
            }
        }

        cursor = new BigInteger(nextCursor.toString());
        return retCursor;
    }

    /**
     * Create the maximum default endValue by the size
     * @param endVsize  size
     * @return the default maxinum endValue
     */
    private static BigInteger getEndValue(int endVsize){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<endVsize; i++){
            sb.append("9");
        }

        return new BigInteger(sb.toString());
    }

    /**
     * Check all llegalArgumentExceptions
     * @param seed      a start number 
     * @param endValue  max number
     */
    private void checkIllegalArgumentException(BigInteger seed, BigInteger endValue){
        // if the seed is not positive
        if (seed.longValue() < 0){
            throw new IllegalArgumentException("ERROR: seed should be positive");
        }
        // if the seed is not less than the end
        if (seed.compareTo(endValue) == 1){
            throw new IllegalArgumentException("ERROR: seed should not greater than end value");
        }
        // if the seed has any zeroes in it
        if (seed.toString().contains("0")){
            throw new IllegalArgumentException("ERROR: contains zero is illegal");
        }
    }

    /**
     * Allow using forEach lamda expression
     * @return a iterator
     */
    @Override
    public Iterator<BigInteger> iterator() {
        return new LookAndSayIterator(cursor, endValue);
    }
}