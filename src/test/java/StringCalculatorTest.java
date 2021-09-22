import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();
    int expectedRunCount = 0;

    @Test
    public void addForEmptyString() {
        expectedRunCount++;
        int actual = stringCalculator.add("");
        assertEquals(0, actual, "Should return 0 for empty string.");
    }

    @Test
    public void addForASingleNumber() {
        expectedRunCount++;
        int actual = stringCalculator.add("1");
        assertEquals(1, actual, "Should handle single number.");
    }

    @Test
    public void addForTwoNumbers() {
        expectedRunCount++;
        int actual = stringCalculator.add("1,2");
        assertEquals(3, actual, "Should add two numbers");
    }

    @Test
    public void addForMoreThanTwoNumbers() {
        expectedRunCount++;
        assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("1,2,3"));
    }

    @Test
    public void addForNewLine() {
        expectedRunCount++;
        assertEquals(5, stringCalculator.add("1\n2,3"));
    }

    @Test
    public void addSupportForDelimiter() {
        expectedRunCount++;
        assertEquals(4, stringCalculator.add("\\;\n1;3"));
    }

    @Test
    public void addForNegativeNumberThrowsException() {
        expectedRunCount++;
        assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("1,-1"));
    }

    @Test
    public void addForMultipleNegatives() {
        expectedRunCount++;
        String message = assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.add("-1,-1");
        }).getMessage();
        assertEquals("Negative numbers not allowed: -1,-1", message);
    }

    @Test
    public void addForNumbersBiggerThanThousand() {
        expectedRunCount++;
        assertEquals(2, stringCalculator.add("2,1000"),"Numbers bigger than 1000 should be ignored.");
    }

    @Test
    public void addForDifferentSizeDelimiter() {
        expectedRunCount++;
        assertEquals(3, stringCalculator.add("//[***]\n1***2"));
    }

    @Test
    public void addForMultipleDelimiter() {
        expectedRunCount++;
        assertEquals(3, stringCalculator.add("//[*][%]\n1%2"));
    }

    @Test
    public void addForMultipleDelimiterWithDifferentSize() {
        expectedRunCount++;
        assertEquals(3, stringCalculator.add("//[**][%%]\n1%%2"));
    }

    @Test
    public void getCalledCountTest() {
        assertEquals(expectedRunCount, stringCalculator.getCalledCount());
    }

}
