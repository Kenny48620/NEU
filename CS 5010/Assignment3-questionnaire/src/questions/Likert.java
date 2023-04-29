package questions;

import java.util.Comparator;

/**
 * This class is a question type that can be used to ask Likert question. It implements Question interface.
 */
public class Likert implements Question{
    private static final int LOWER_BOUND = 1;  // lower bound of the answer number
    private static final int UPPER_BOUND = 5;  // upper bound of the answer number
    private static final int PRIORITY_ID = 4;  // priority

    private String question;            // question
    /**
     * Constructor of Likert
     * @param question a String that represents a question
     * @param answer   a String that represebts the answer
     */
    public Likert(String qusetion){
        this.question = qusetion;
    }
    /**
     * Getter for getting text
     * @return a String that represents a question
     */
    @Override
    public String getText() {
        return question;
    }
    /**
     * Checking if the answer is correct or not
     * @param answer a String that represents the answer
     * @return a String that is Correct or Incorrect
     */
    @Override
    public String answer(String answer) {
        int ansNum = Integer.parseInt(answer);
        if (ansNum >= LOWER_BOUND && ansNum <= UPPER_BOUND)
            return "Correct";
        return "Incorrect";
    }
    /**
     * Comapre two questions by the priority IDs
     * Then compare the questions in lexicographical order 
     * @param  o  an Question object 
     * @return an Integer that represents the result of comparing two questions
     */
    @Override
    public int compareTo(Question o) {
        return Comparator.comparing(Question::getID)
        .thenComparing(Question::getText)
        .compare(this, o);
    }
    /**
     * Getter for gettgin piority of a question
     * @return priority of a question
     */
    @Override
    public int getID() {
        return PRIORITY_ID;
    }
}
