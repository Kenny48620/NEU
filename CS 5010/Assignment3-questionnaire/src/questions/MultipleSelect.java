package questions;

import java.util.Comparator;

/**
 * This class is a question type that can be used to ask Multiple Select question. It implements Question interface 
 * and extends from MultipleSetting.
 */
public class MultipleSelect extends MultipleSetting implements Question{
    private static final int PRIORITY_ID = 3; // priority
    /**
     * Constructors of MultipleSelect, which is inherits from MultipleSetting
     * @param question a String that represents a question
     * @param answer   a String that represebts the answer
     * 
     * @param option1  an option for user to choose
     * @param option2  an option for user to choose
     * @param option3  an option for user to choose
     * @param option4  an option for user to choose
     * @param option5  an option for user to choose
     * @param option6  an option for user to choose
     * @param option7  an option for user to choose
     * @param option8  an option for user to choose
     */
    public MultipleSelect(String question, String answer, 
                          String option1,  String option2, String option3 ) {
        super(question, answer, option1, option2, option3);
    }
    /** Overloading for MultipleSelect*/
    public MultipleSelect(String question, String answer,  
                          String option1,  String option2, String option3, 
                          String option4                                  ) {
        super(question, answer, option1, option2, option3, option4);
    }
    /** Overloading for MultipleSelect*/
    public MultipleSelect(String question, String answer,  
                          String option1,  String option2, String answer3, 
                          String option4,  String option5                 ) {
        super(question, answer, option1, option2, answer3, option4, option5);
    }
    /** Overloading for MultipleSelect*/
    public MultipleSelect(String question, String answer, 
                          String option1,  String option2, String option3,
                          String option4,  String option5, String option6 ) {
        super(question, answer, option1, option2, option3, option4, option5, option6);
    }
    /** Overloading for MultipleSelect*/
    public MultipleSelect(String question, String answer, 
                          String option1,  String option2, String option3,
                          String option4,  String option5, String option6, 
                          String option7                                  ) {
        super(question, answer, option1, option2, option3, option4, option5, option6, option7);
    }
    /** Overloading for MultipleSelect*/
    public MultipleSelect(String question, String answer, 
                          String option1,  String option2, String option3,
                          String option4,  String option5, String option6, 
                          String option7,  String option8                 ) {
        super(question, answer, option1, option2, option3, option4, option5, option6, option7, option8);
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
}
