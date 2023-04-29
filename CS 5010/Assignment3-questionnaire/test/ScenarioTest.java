package questions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * This is a test that tests the functionality interaction of all of the files in src/questions
 */
public class ScenarioTest {
    List<Question> questionBank;   // use list as a question bank to stroe questions
    List<Question> questions;      // expected quesions output

    // TrueFalse questions
    TrueFalse tf1;      TrueFalse tf2;      TrueFalse tf3;
    // Multiple Choice questions
    MultipleChoice mc1; MultipleChoice mc2; MultipleChoice mc3;
    // Multiple Select questions
    MultipleSelect ms1; MultipleSelect ms2; MultipleSelect ms3;
    // Likert questionsquestions
    Likert lk1;         Likert lk2;         Likert lk3;

    /**
     * Initialize all fields before testing
     */
    @Before
    public void init(){
        tf1 = new TrueFalse("Do you like coffe?", "True");
        tf2 = new TrueFalse("Do you like coke?", "True");
        tf3 = new TrueFalse("Do you like water?", "False");

        mc1 = new MultipleChoice("What is this?", "Coke", "Coke", "Water", "Juice");
        mc2 = new MultipleChoice("How is his day?", "Good", "Bad", "Good", "Great", "Not bad");
        mc3 = new MultipleChoice("At the top?", "Yes", "Yes", "No", "Maybe");

        ms1 = new MultipleSelect("Go where?", "1 2 3 4", "Market", "Bar", "Subway", "Inn", "Home");
        ms2 = new MultipleSelect("Which is in the box?", "2, 3", "Dog", "Cat", "Monkey");
        ms3 = new MultipleSelect("Color she likes?", "4", "Red", "Yellow", "Blue");
        
        lk1 = new Likert("Is this difficult?");
        lk2 = new Likert("Should we go without him?");
        lk3 = new Likert("Today is not your day?");
    }
    /**
     * Test the functionalities of all and put them into a list that represents
     * a question bank that stores the questions and use Collections.sort() to
     * maintain the order as the requirements
     */
    @Test
    public void senarioByUsingList(){
        questionBank = new ArrayList<>();
        // randomly add them
        questionBank.add(lk3);questionBank.add(mc1);questionBank.add(ms3);
        questionBank.add(tf1);questionBank.add(ms2);questionBank.add(mc2);
        questionBank.add(lk1);questionBank.add(tf3);questionBank.add(lk2);
        questionBank.add(tf2);questionBank.add(mc3);questionBank.add(ms1);

        
        questions = new ArrayList<>();
        // add it by the expected order
        questions.add(tf1);questions.add(tf2);questions.add(tf3);
        questions.add(mc3);questions.add(mc2);questions.add(mc1);
        questions.add(ms3);questions.add(ms1);questions.add(ms2);
        questions.add(lk1);questions.add(lk2);questions.add(lk3);

        // before sorting
        assertNotEquals(questions, questionBank);
        // maintain te order
        Collections.sort(questionBank);
        // after sorting
        assertEquals(questions, questionBank);
    }    
}
