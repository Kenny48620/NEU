package bignumber;

/**
 * This class is a class that can represnt a big number that int cannot hold. It
 * use an inner class Node and store the number into linked list.
 * It implements BigNumber interface.
 */
public class BigNumberImpl implements BigNumber{
    /**
     * Private class Node that store digit and pointer of next node.
     */
    private class Node{
        int  digit; // digit of a number
        Node next;  // pointer to next node
        /**
         * Constructor of Node
         * @param digit a digit
         */
        public Node(int digit){
            this.digit = digit;
            this.next  = null;
        }
    }

    /** Fields */
    private Node head;    // the head of linked list
    private int  length;  // the size of linked list

    /**
     * Default constructor for taking 0
     */
    public BigNumberImpl(){
        length = 1;
        // create a number 0
        head   = new Node(0);
    }

    /**
     * Constructor 
     * @param number a number
     */
    public BigNumberImpl(String number){
        length = 0;
        // assign the number 
        head   = assignNumber(number);
    }

    /**
     * Assign a number to a head node. If number = 123, the linkedlist = 3->2->1
     * @param number a number
     * @return the head of linked list
     */
    private Node assignNumber(String number){
        // Check if number is null or empty
        if (number == null || number.isEmpty()){
            throw new IllegalArgumentException("Error: number is null or is empty");
        }
        // check if negative or not
        if (number.charAt(0) == '-'){
            throw new IllegalArgumentException("Error: cannot take negative number");
        }

        int i = 0;

        // if the String start with "+" ex: "+0", but not for "+"
        if (number.charAt(i) == '+' && number.length() != 1){
            i++;
        }

        // skip all leading zero ex "0001"
        while (i<number.length() && number.charAt(i) == '0'){
            i++;
        }
        
        // special case i = number.length() 
        if (i == number.length()){
            length++;
            return new Node(0); // String is "0"
        }
        
        Node head = null; // the head of linked list

        // validation check and assign digit
        for (; i<number.length(); i++){
            if (!Character.isDigit(number.charAt(i))){
                throw new IllegalArgumentException("Error: invalid number!");
            }
        
            Node digitNode = new Node(number.charAt(i)-'0');
            if (head == null){
                head = digitNode;
            }else{
                digitNode.next =  head;
                head = digitNode;
            }
            length++; // update the length of linked list
        }

        return head;
    }

    /**
     * Return the legnth of this big number
     * @return the legnth of this big number
     */
    @Override
    public int length() {
        return length;
    }

    /**
     * Shift the number to left, which is multiplied by 10
     * @param numShift number of left shifts
     */
    @Override
    public void shiftLeft(int numShift) {
        // negative shift 
        if (numShift < 0){
            shiftRight(-numShift);
            return;
        }
        // if number is 0, there is no change to it
        if (length ==  1 &&  head.digit == 0){
            return;
        }

        for (int i=0; i<numShift; i++){
            Node digitNode = new Node(0);
            digitNode.next = head;
            head           = digitNode;
            length++; 
        }
    }

    /**
     * Shift the number to left, which is divided by 10
     * @param numShift number of right shifts
     */
    @Override
    public void shiftRight(int numShift) {
        // negative shift
        if (numShift < 0){
            shiftLeft(-numShift);
            return;
        }
        // if number is 0, there is no change to it
        if (length ==  1 &&  head.digit == 0){
            return;
        }
        // if the number of shift is greater than the length 
        if (numShift >= length){
            head.digit  = 0;
            head.next   = null;
            length      = 1;
            return;
        }

        for (int i=0; i<numShift; i++){
            if (head != null){
                head = head.next;
                length--;
            }
        }
        
    }

    /**
     * Takes a single digit as an argument and adds it to this number.
     * This method throws an IllegalArgumentException if the digit passed to it is not a single non-negative digit.
     * @param digit an int to be added
     */
    @Override
    public void addDigit(int digit) {
        // negative or two digits 
        if (digit < 0 || digit > 9){
            throw new IllegalArgumentException("Error: the digit passed to it is not a single non-negative digit.");
        }
        Node tmp   = head;
        tmp.digit += digit;
        
        while (tmp.digit > 9){
            tmp.digit -= 10;
            // special case 9->9->9
            // add          1
            //              0->0->0->1
            if (tmp.next == null){
                tmp.next = new Node(1); // create a new Node if next is null
                length++; // update the length
            }else{
                tmp        = tmp.next;
                tmp.digit += 1; 
            }
        }
    }

    /**
     * Takes a position as an argument and returns the digit at that position. 
     * @param position  the rihgt most position that starts at zero
     * @return the digit at the position
     */
    @Override
    public int getDigitAt(int position) {
        // if postion is negative or is greater than the length of this number
        if (position < 0 || position >= length){
            throw new IllegalArgumentException("Error: an invalid position is passed.");
        }
        Node tmp = head;
        while (tmp != null && position > 0){
            tmp = tmp.next;
            position --;  
        }

        return tmp.digit;
    }

    /**
     * Return a copy of this object
     * @return a object of bignumber
     */
    @Override
    public BigNumber copy() {
        return new BigNumberImpl(this.toString());
    }

    /**
     * Add two big number
     * @param bigNumber another bigNumber
     * @return a new bigNumber object that has the sum of the two big number
     */
    @Override
    public BigNumber add(BigNumber bigNumber) {
        BigNumberImpl another = (BigNumberImpl) bigNumber;
        StringBuilder sb      = new StringBuilder();

        int position = 0;
        int carry    = 0;
        while (position < this.length() && position < another.length()){
            int val = this.getDigitAt(position) + another.getDigitAt(position) + carry;
            // if overflow, record it
            if (val > 9){
                val  -= 10;
                carry = 1;
            }else{
                carry = 0;
            }

            sb.append(val);
            position++;
        }

        // check if there exist a bigger one
        BigNumberImpl longer = null;
        if (position < this.length()){
            longer = this;
        }
        if (position < another.length()){
            longer = another;
        }
        // assign the bigger one 
        while (longer != null && position < longer.length()){
            int val = longer.getDigitAt(position)+carry;
            if (val > 9){
                val -= 10;
                carry = 1;
            }else{
                carry = 0;
            }
            sb.append(val);
            position++;
        }
        // check if carry == 1, which means that we need to add one at the head
        if (carry == 1){
            sb.append(carry);
            length++;
        }

        return new BigNumberImpl(sb.reverse().toString().trim());
    }
    
    /**
     * Compare two big number
     * @param o anotehr big number
     * @return 1 if this greater than anotehr, 0 equals to, -1 less than
     */
    @Override
    public int compareTo(BigNumber o) {
        // reference the same object 
        if (this == o){
            return 0;
        }
        BigNumberImpl another = (BigNumberImpl) o;

        // compare by length
        if (this.length() > another.length()){
            return 1;
        } else if (another.length() > this.length()){
            return -1;
        }

        // if they have same length, compare by digit one by one
        int position = this.length()-1;

        while (position >= 0){
            int thisDigit = this.getDigitAt(position);
            int anotDigit = another.getDigitAt(position);

            if (thisDigit > anotDigit){
                return 1;
            }else if (anotDigit > thisDigit){
                return -1;
            }
            position--;
        }

        return 0; // they're exacty same
    }

    /**
     * Display big number
     * @return big number
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node         tmp = head;

        while (tmp!=null){
            sb.append(tmp.digit);
            tmp   = tmp.next;
        }

        return sb.reverse().toString().trim(); // reverse to correct result and remove extra space               
    }
}
