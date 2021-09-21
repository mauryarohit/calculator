import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void addForEmptyString() {
        int actual = stringCalculator.add("");
        assertEquals(0, actual, "Should return 0 for empty string.");
    }

    @Test
    public void addForASingleNumber() {
        int actual = stringCalculator.add("1");
        assertEquals(1, actual, "Should handle single number.");
    }

    @Test
    public void addForTwoNumbers() {
        int actual = stringCalculator.add("1,2");
        assertEquals(3, actual, "Should add two numbers");
    }

    @Test
    public void addForMoreThanTwoNumbers() {
        assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("1,2,3"));
    }

    @Test
    public void addForNewLine() {
        assertEquals(5, stringCalculator.add("1\n2,3"));
    }

    @Test
    public void addSupportForDelimiter() {
        assertEquals(4, stringCalculator.add("\\;\n1;3"));
    }

    @Test
    public void addForNegativeNumberThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("1,-1"));
    }

    @Test
    public void addForMultipleNegatives() {
        String message = assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.add("-1,-1");
        }).getMessage();
        assertEquals("Negative numbers not allowed: -1,-1", message);
    }

    @Test
    public void addForNumbersBiggerThanThousand() {
        assertEquals(2, stringCalculator.add("2,1000"),"Numbers bigger than 1000 should be ignored.");
    }

    @Test
    public void addForDifferentSizeDelimiter() {
        assertEquals(3, stringCalculator.add("//[***]\n1***2"));
    }

    @Test
    public void addForMultipleDelimiter() {
        assertEquals(3, stringCalculator.add("//[*][%]\n1%2"));
    }

    @Test
    public void addForMultipleDelimiterWithDifferentSize() {
        assertEquals(3, stringCalculator.add("//[**][%%]\n1%%2"));
    }

    @Test
    public void getCalledCountTest() {
        assertEquals(12, stringCalculator.getCalledCount());
    }

}
