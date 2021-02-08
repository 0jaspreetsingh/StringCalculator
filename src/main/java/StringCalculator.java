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
    public int add(String input) {
        if (this.EMPTY_STRING == input || this.EMPTY_STRING == input.trim()) return 0;
        return this.getSum(input);
    }


    /**
     * splits input to an array depending on the seperator and returns sum
     *
     * @param input
     * @return
     */
    private int getSum(String input) {
        int answer = 0;
        String inputArrayWithoutNewLine[] = input.split(this.NEW_LINE);
        String seperator = this.DEFAULT_SEPERATOR;
        int startIndex = 0;
        if (input.startsWith(this.DEFAULT_SEPERATOR_OVERRIDE)) {
            startIndex++;
            seperator = this.getSeperator(input);
        }
        for (int i = startIndex; i < inputArrayWithoutNewLine.length; i++) {
            System.out.println(seperator);
            String inputArray[] = inputArrayWithoutNewLine[i].split(seperator);
            System.out.println(Arrays.toString(inputArray));
            for (String inputStringValue : inputArray) {
                answer += Integer.parseInt(inputStringValue);
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
