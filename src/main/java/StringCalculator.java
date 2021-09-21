import java.net.Inet4Address;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final Logger LOGGER = Logger.getLogger(StringCalculator.class.getName());

    public int add(String numbers) {
        if(numbers.equals("")) {
            return 0;
        }
        String delimiter = "";
        LOGGER.info("Original Numbers: " + numbers);
        if(numbers.startsWith("\\")) {
            delimiter = String.valueOf(numbers.charAt(1));
        } else {
            delimiter = ",";
        }
        numbers = numbers.replaceAll("[\n]", "+");
        int lastNewLine = numbers.lastIndexOf('+');
        if(lastNewLine != -1) {
            numbers = numbers.substring(lastNewLine);
        }
        LOGGER.info("Modified Numbers: " + numbers);
        List<String> nums = Arrays.asList(numbers.split(delimiter));
        List<String> filteredNums = nums.stream().filter(num -> Integer.parseInt(num) < 0).toList();
        if(filteredNums.size() > 0) {
            String message = String.join(",", filteredNums);
            throw new IllegalArgumentException("Negative numbers not allowed: " + message);
        }
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
