import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for StringCalculator
 */
public class StringCalculatorTest {


    /**
     * problem 1
     */
    @Test
    public void add_ShouldReturnZeroForEmptyString() throws Exception {
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
    public void add_ShouldReturnNumberItselfForInputWithSingleValue() throws Exception {
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
    public void add_ShouldReturnSumForInputWithTwoOrMoreCommaSeperatedNumbers() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        String addInput = "2,3,6,7";
        int expected = 18;
        int actual = stringCalculator.add(addInput);
        assertEquals(expected, actual, "Should return sum for two or more comma seperated numbers");
    }

    /**
     * problem 3
     */
    @Test
    public void add_ShouldHandleInputCorrectlyWithNewLineCharacters() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        String addInput = "1\n2,3";
        int expected = 6;
        int actual = stringCalculator.add(addInput);
        assertEquals(expected, actual, "Should handle input correctly with new line characters");
    }

    /**
     * problem 3
     */
    @Test
    public void add_ShouldHandleInputCorrectlyWithMultipleNewLineCharacters() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        String addInput = "1\n2,3,5\n7";
        int expected = 18;
        int actual = stringCalculator.add(addInput);
        assertEquals(expected, actual, "Should handle input correctly with new line characters");
    }

    /**
     * problem 4
     */
    @Test
    public void add_ShouldHandleinputCorrectlyForDifferentSeperatorSpecifiedAtBeginning() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        String addInput = "//;\n1;2";
        int expected = 3;
        int actual = stringCalculator.add(addInput);
        assertEquals(expected, actual, "Should handle input correctly for different seperator specified at beginning");
    }

    /**
     * problem 4
     */
    @Test
    public void add_ShouldHandleinputCorrectlyForDifferentSeperatorSpecified() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        String addInput = "//^\n1^2";
        int expected = 3;
        int actual = stringCalculator.add(addInput);
        assertEquals(expected, actual, "Should handle input correctly for different seperator specified");
    }

    /**
     * problem 5
     */
    @Test
    public void add_ShouldThrowExceptionForNegativeNumbersInInput() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        String addInput = "//^\n1^-2";

        Exception exception = assertThrows(Exception.class, () -> {
            stringCalculator.add(addInput);
        });
        assertEquals("negatives not allowed: -2", exception.getMessage().trim());
    }

    /**
     * problem 6
     */
    @Test
    public void add_ShouldThrowExceptionAlongWithListOfNegativeNumbersInInput() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        String addInput = "//^\n1^-2^-6";

        Exception exception = assertThrows(Exception.class, () -> {
            stringCalculator.add(addInput);
        });
        assertEquals("negatives not allowed: -2 -6", exception.getMessage().trim());
    }

    /**
     * problem 7
     *
     * @throws Exception
     */
    @Test
    public void add_ShouldCheckCallCountforAddMethod() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        stringCalculator.add("1\n2,3");
        String addInput = "//^\n1^-2^-6";
        int excepted = 2;
        Exception exception = assertThrows(Exception.class, () -> {
            stringCalculator.add(addInput);
        });
        assertEquals(2, stringCalculator.getCalledCount());
    }

    /**
     * problem 9
     *
     * @throws Exception
     */
    @Test
    public void add_ShouldIgnorenumbersGreaterThan1000() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        String addInput = "1\n2,3,5\n7,2000";
        int expected = 18;
        int actual = stringCalculator.add(addInput);
        assertEquals(expected, actual, "Should ignore numners greater than 1000");
    }

    /**
     * problem 10
     *
     * @throws Exception
     */
    @Test
    public void add_ShouldAllowDelimitersWithLengthGreaterThanOne() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        String addInput = "//****\n1****2";
        int expected = 3;
        int actual = stringCalculator.add(addInput);
        assertEquals(expected, actual, "Should allow Delimiters greater than one");
    }
}
