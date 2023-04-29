package questions;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
/**
 * Unit test for TrueFalseTest.
 */
public class MultipleSettingTest {
    
    /**
     * Test Constructor
     */
    @Test
    public void testConstructor(){
        String question = "which question?";// question
        String answer   = "option 1";       // answer 
        String option1  = "option 1";       // option1
        String option2  = "option 2";       // option2
        String option3  = "option 3";       // option3
        String option4  = "option 4";       // option4   
        String option5  = "option 5";       // option5
        String option6  = "option 6";       // option6
        String option7  = "option 7";       // option7
        String option8  = "option 8";       // option8

        // 3 options
        MultipleSetting ms = new MultipleSetting(question, answer, option1, option2, option3) {
        };
        assertNotNull(ms);
        // 4 options
        ms = new MultipleSetting(question, answer, option1, option2, option3, option4) {
        };
        assertNotNull(ms);
        // 5 options
        ms = new MultipleSetting(question, answer, option1, option2, option3, option4, option5) {
        };
        assertNotNull(ms);
        // 6 options
        ms = new MultipleSetting(question, answer, option1, option2, option3, option4, option5, option6) {
        };
        assertNotNull(ms);
        // 7 options
        ms = new MultipleSetting(question, answer, option1, option2, option3, option4, option5, option6, option7) {
        };
        assertNotNull(ms);
        // 8 options
        ms = new MultipleSetting(question, answer, option1, option2, option3, option4, option5, option6, option7, option8) {
        };
        assertNotNull(ms);
    } 
}
