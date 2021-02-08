import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for StringCalculator
 */
public class StringCalculatorTest {


    /**
     * problem 1
     */
    @Test
    public void add_ShouldReturnZeroForEmptyString() {
        StringCalculator stringCalculator = new StringCalculator();
        String addInput = "";
        int expected = 0;
        int actual = stringCalculator.add(addInput);
        assertEquals(expected, actual, "Should return 0 for empty String");
    }

    /**
     * problem 1
     */
    @Test
    public void add_ShouldReturnNumberItselfForInputWithSingleValue() {
        StringCalculator stringCalculator = new StringCalculator();
        String addInput = "2";
        int expected = 2;
        int actual = stringCalculator.add(addInput);
        assertEquals(expected, actual, "Should return number itself for single value input");
    }

    /**
     * problem 2
     */
    @Test
    public void add_ShouldReturnSumForInputWithTwoOrMoreCommaSeperatedNumbers() {
        StringCalculator stringCalculator = new StringCalculator();
        String addInput = "2,3,6,7";
        int expected = 18;
        int actual = stringCalculator.add(addInput);
        assertEquals(expected, actual, "Should return sum for two or more comma seperated numbers");
    }
}
