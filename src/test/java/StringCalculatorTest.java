import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    public void addForEmptyString() {
        StringCalculator stringCalculator = new StringCalculator();
        int actual = stringCalculator.add("");
        assertEquals(0, actual, "Should return 0 for empty string.");
    }

}