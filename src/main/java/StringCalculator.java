import java.net.Inet4Address;
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
        
        if(nums.size() == 2) {
            return Integer.parseInt(nums.get(0)) + Integer.parseInt(nums.get(1));
        }

        return -1;
    }

}
