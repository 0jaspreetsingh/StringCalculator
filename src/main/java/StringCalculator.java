/**
 * Utility class to add numbers
 */
public class StringCalculator {

    private String DEFAULT_SEPERATOR = ",";
    private String EMPTY_STRING = "";
    private String NEW_LINE = "\n";
    private String DEFAULT_SEPERATOR_OVERRIDE = "//";
    private String BACK_SLASH = "\\";
    private int calledCount = 0;
    private String SQUARE_BRACKET = "[";


    /**
     * utility function to add numbers given in string input seperated by comma or some other specified character
     *
     * @param input
     * @return
     */
    public int add(String input) throws Exception {
        this.calledCount++;
        if (this.EMPTY_STRING == input || this.EMPTY_STRING == input.trim()) return 0;
        return this.getSum(input);
    }


    /**
     * splits input to an array depending on the seperator and returns sum
     *
     * @param input
     * @return
     */
    private int getSum(String input) throws Exception {
        int answer = 0;
        String seperator = this.DEFAULT_SEPERATOR;
        int startIndex = 0;
        // check if seperator is overriden
        if (input.startsWith(this.DEFAULT_SEPERATOR_OVERRIDE)) {
            startIndex++; // to skip value before first new line as it specifies Delimiters
            String seperatorList[] = this.getSeperator(input);
            seperator = seperatorList[0];
            if (seperatorList.length > 1) {
                for (int i = 1; i < seperatorList.length; i++) {
                    input = input.replace(seperatorList[i], seperator); // replacing multipe Delimiters with a single value for parsing easily
                }
            }
        }
        String inputArrayWithoutNewLine[] = input.split(this.NEW_LINE);
        StringBuilder negativeNumbersList = new StringBuilder();
        for (int i = startIndex; i < inputArrayWithoutNewLine.length; i++) {
            String inputArray[] = inputArrayWithoutNewLine[i].split(refractorSeperator(seperator));
            for (String inputStringValue : inputArray) {
                int number = Integer.parseInt(inputStringValue);
                if (number < 0) negativeNumbersList.append(number + " ");
                if (number > 1000) number = 0;
                answer += number;
            }
        }
        if (negativeNumbersList.length() > 0)
            throw new Exception("negatives not allowed: " + negativeNumbersList.toString());
        return answer;
    }

    /**
     * get seperator if input starts with \\ , otherwise return default seperator
     *
     * @param input
     * @return
     */
    private String[] getSeperator(String input) {
        String seperatorString = input.split(this.NEW_LINE)[0].substring(2);
        return this.getSeperatorList(seperatorString);
    }

    /**
     * get seperator list
     *
     * @param seperatorsString
     * @return
     */
    private String[] getSeperatorList(String seperatorsString) {
        if (seperatorsString.startsWith(this.SQUARE_BRACKET)) {
            seperatorsString = seperatorsString.substring(1, seperatorsString.length() - 1);
            return seperatorsString.split("]\\[");
        }
        return new String[]{seperatorsString};
    }

    /**
     * ensure that special characters does not break code
     *
     * @param seperator
     * @return
     */
    private String refractorSeperator(String seperator) {
        StringBuilder sb = new StringBuilder();
        for (char c : seperator.toCharArray()) {
            sb.append(this.isDanglingCharacter(c) ? this.BACK_SLASH + c : c);
        }
        return sb.toString();
    }

    /**
     * to avoid String.split function's error for these specific characters
     *
     * @param c
     * @return
     */
    private boolean isDanglingCharacter(char c) {
        return c == '?' || c == '^' || c == '*' || c == '+' || c == '$';
    }

    /**
     * number of times the add function is called
     *
     * @return
     */
    public int getCalledCount() {
        return this.calledCount;
    }
}
