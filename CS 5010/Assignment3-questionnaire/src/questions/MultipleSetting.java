package questions;
/**
 * This class is a question setting for mutiple options quesions
 */
public abstract class MultipleSetting{
    protected String question;  // question
    protected String answer;    // answer 
    protected String option1;   // option1
    protected String option2;   // option2
    protected String option3;   // option3
    protected String option4;   // option4   
    protected String option5;   // option5
    protected String option6;   // option6
    protected String option7;   // option7
    protected String option8;   // option8
    /**
     * Constructors of MultipleSetting
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
    public MultipleSetting(String question, String answer, 
                          String option1,  String option2, String option3  ){
        this.question = question;
        this.answer   = answer;
        this.option1  = option1;
        this.option2  = option2;
        this.option3  = option3;
    }
    public MultipleSetting(String question, String answer,
                          String option1,  String option2, String option3,
                          String option4                                  ){
        this(question, answer, option1, option2, option3);
        this.option4  = option4;
    }
    public MultipleSetting(String question, String answer,
                          String option1,  String option2, String answer3,
                          String option4,  String option5                 ){
        this(question, answer, option1, option2, answer3, option4);
        this.option5  = option5;
    }
    public MultipleSetting(String question, String answer,
                          String option1,  String option2, String option3,
                          String option4,  String option5, String option6 ){
        this(question, answer, option1, option2, option3, option4, option5);
        this.option6  = option6;
    }
    public MultipleSetting(String question, String answer,
                          String option1,  String option2, String option3,
                          String option4,  String option5, String option6,
                          String option7                                  ){
        this(question, answer, option1, option2, option3, option4, option5, 
             option6);
        this.option7  = option7;
    }
    public MultipleSetting(String question, String answer,
                          String option1,  String option2, String option3,
                          String option4,  String option5, String option6,
                          String option7,  String option8                 ){
        this(question, answer, option1, option2, option3, option4, option5, 
             option6, option7);
        this.option8  = option8;
    }
}
