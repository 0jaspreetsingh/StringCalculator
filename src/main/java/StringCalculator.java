/**
 * Utility class to add numbers
 */
public class StringCalculator {

    /**
     * utility function to add numbers given in string input seperated by comma or some other specified character
     *
     * @param input
     * @return
     */
    public int add(String input) {
        return this.getSum(input, ",");
    }


    /**
     * splits input to an array depending on the seperator and returns sum
     *
     * @param input
     * @param seperator
     * @return
     */
    private int getSum(String input, String seperator) {
        if (input == "" || input.trim() == "") return 0;
        int answer = 0;
        String inputArrayWithoutNewLine[] = input.split("\n");
        for (String inputWithSeperator : inputArrayWithoutNewLine) {
            String inputArray[] = inputWithSeperator.split(seperator);
            for (String inputStringValue : inputArray) {
                answer += Integer.parseInt(inputStringValue);
            }
        }

        return answer;
    }
}
