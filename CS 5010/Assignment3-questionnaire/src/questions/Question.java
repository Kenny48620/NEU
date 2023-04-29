package questions;
/**
 * This class is an interface for serveral question types
 */
public interface Question extends Comparable<Question> {
    /**
     * Getter for getting text
     * @return a String that represents a question
     */
    public String getText();

    /**
     * Checking if the answer is correct or not
     * @param answer a String that represents the answer
     * @return a String that is Correct or Incorrect
     */
    public String answer(String answer);
    
    /**
     * Getter for gettgin piority of a question
     * @return priority of a question
     */
    public int getID();
}
