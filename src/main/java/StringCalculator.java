
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class StringCalculator {

    private static final Logger LOGGER = Logger.getLogger(StringCalculator.class.getName());

    int count = 0;

    public int add(String numbers) {
        count++;
        if(numbers.equals("")) {
            return 0;
        }
        String delimiter = "";
        LOGGER.info("Original Numbers: " + numbers);
        numbers = numbers.replaceAll("[\n]", "+");
        if(numbers.startsWith("//")) {
            if(numbers.charAt(2) == '[') {
                delimiter = numbers.substring(numbers.indexOf("[")+1, numbers.indexOf("]"));
            } else {
                delimiter = String.valueOf(numbers.charAt(1));
            }
        } else {
            delimiter = ",";
        }
        LOGGER.info("Delimiter:" + delimiter);
        int lastNewLine = numbers.lastIndexOf('+');
        if(lastNewLine != -1) {
            numbers = numbers.substring(lastNewLine);
        }
        LOGGER.info("Modified Numbers: " + numbers);
        delimiter = delimiter.replaceAll("[*,;%]", "a");
        numbers = numbers.replaceAll("[*,;%]", "a");
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
            int result = nums.stream().mapToInt(Integer::parseInt).
                    filter(number -> number < 1000).sum();
            return result;
        }

        if(nums.size() > 2) {
            throw new IllegalArgumentException("More than 2 numbers are not allowed!");
        }

        return -1;
    }

    public int getCalledCount() {
        return this.count;
    }

}
