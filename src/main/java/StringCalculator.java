import java.util.Arrays;

/**
 * Utility class to add numbers
 */
public class StringCalculator {

    private String DEFAULT_SEPERATOR = ",";
    private String EMPTY_STRING = "";
    private String NEW_LINE = "\n";
    private String DEFAULT_SEPERATOR_OVERRIDE = "//";
    private String BACK_SLASH = "\\";


    /**
     * utility function to add numbers given in string input seperated by comma or some other specified character
     *
     * @param input
     * @return
     */
    public int add(String input) throws Exception {
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
        String inputArrayWithoutNewLine[] = input.split(this.NEW_LINE);
        String seperator = this.DEFAULT_SEPERATOR;
        int startIndex = 0;
        if (input.startsWith(this.DEFAULT_SEPERATOR_OVERRIDE)) {
            startIndex++;
            seperator = this.getSeperator(input);
        }
        for (int i = startIndex; i < inputArrayWithoutNewLine.length; i++) {
            String inputArray[] = inputArrayWithoutNewLine[i].split(seperator);
            for (String inputStringValue : inputArray) {
                int number = Integer.parseInt(inputStringValue);
                if (number < 0) throw new Exception("“negatives not allowed");
                answer += number;
            }
        }

        return answer;
    }

    /**
     * get seperator if input starts with \\ , otherwise return default seperator
     *
     * @param input
     * @return
     */
    private String getSeperator(String input) {
        String seperator = input.split(this.NEW_LINE)[0].substring(2);
        StringBuilder sb = new StringBuilder();
        for (char c : seperator.toCharArray()) {
            sb.append(this.isDanglingCharacter(c) ? this.BACK_SLASH + c : c);
        }
        return sb.toString();
    }

    private boolean isDanglingCharacter(char c) {
        return c == '?' || c == '^' || c == '*' || c == '+' || c == '$';
    }
}
