package questions;

import java.util.Comparator;

/**
 * This class is a question type that can be used to ask True or False question. It implements Question interface.
 */
public class TrueFalse implements Question{

    private String question;            // question
    private String answer;              // answer
    private static final int PRIORITY_ID = 1;  // priority
    /**
     * Constructor of TrueFalse
     * @param question a String that represents a question
     * @param answer   a String that represebts the answer
     */
    public TrueFalse(String question, String answer){
        // if the answer is not True or False throw an exception
        if (!answer.equals("True") && !answer.equals("False")){
            throw new IllegalArgumentException("ERROR: constructor input answer must be True or False");
        }
        this.question = question;
        this.answer   = answer;
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
        // if the answer is not True or False throw an exception
        // if (!answer.equals("True") && !answer.equals("False")){
        //     throw new IllegalArgumentException("answer must be True or False");
        // }
        return this.answer.equals(answer)? "Correct": "Incorrect";
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
    
    /**
     * Overrode toString()
     * @return question
     */
    @Override
    public String toString(){
        return question;
    }
}
