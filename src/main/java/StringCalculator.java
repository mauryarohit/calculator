import java.net.Inet4Address;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class StringCalculator {

    private static final Logger LOGGER = Logger.getLogger(StringCalculator.class.getName());

    public int add(String numbers) {
        if(numbers.equals("")) {
            return 0;
        }
        LOGGER.info("Original Numbers: " + numbers);
        numbers = numbers.replaceAll("[\n]", "+");
        int lastNewLine = numbers.lastIndexOf('+');
        if(lastNewLine != -1) {
            numbers = numbers.substring(lastNewLine);
        }
        LOGGER.info("Modified Numbers: " + numbers);
        List<String> nums = Arrays.asList(numbers.split(","));
        if(nums.size() == 1) {
            return Integer.parseInt(nums.get(0));
        }
        
        if(nums.size() == 2) {
            return Integer.parseInt(nums.get(0)) + Integer.parseInt(nums.get(1));
        }

        if(nums.size() > 2) {
            throw new IllegalArgumentException("More than 2 numbers are not allowed!");
        }

        return -1;
    }

}
