import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public int add(String numbers) {
        if(numbers.equals("")) {
            return 0;
        }
        List<String> nums = Arrays.asList(numbers.split(","));
        if(nums.size() == 1) {
            return Integer.parseInt(nums.get(0));
        }

        return -1;
    }

}
