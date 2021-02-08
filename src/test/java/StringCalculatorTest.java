import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for StringCalculator
 */
public class StringCalculatorTest {


    @Test
    public void testAddForEmptyString() {
        StringCalculator stringCalculator = new StringCalculator();
        String addInput = "";
        int expected = 0;
        int actual = stringCalculator.add(addInput);
        assertEquals(expected, actual, "Should add two numbers");
    }
}
