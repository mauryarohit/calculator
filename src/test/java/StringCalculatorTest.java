import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    public void addForEmptyString() {
        StringCalculator stringCalculator = new StringCalculator();
        int actual = stringCalculator.add("");
        assertEquals(0, actual, "Should return 0 for empty string.");
    }

    @Test
    public void addForASingleNumber() {
        StringCalculator stringCalculator = new StringCalculator();
        int actual = stringCalculator.add("1");
        assertEquals(1, actual, "Should handle single number.");
    }

    @Test
    public void addForTwoNumbers() {
        StringCalculator stringCalculator = new StringCalculator();
        int actual = stringCalculator.add("1,2");
        assertEquals(3, actual, "Should add two numbers");
    }

    @Test
    public void addForMoreThanTwoNumbers() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("1,2,3"));
    }

    @Test
    public void addForNewLine() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(5, stringCalculator.add("1\n2,3"));
    }

    @Test
    public void addSupportForDelimiter() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(4, stringCalculator.add("\\;\n1;3"));
    }

    @Test
    public void addForNegativeNumberThrowsException() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("1,-1"));
    }

    @Test
    public void addForMultipleNegatives() {
        StringCalculator stringCalculator = new StringCalculator();
        String message = assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.add("-1,-1");
        }).getMessage();
        assertEquals("Negative numbers not allowed: -1,-1", message);
    }

    @Test
    public void addForNumbersBiggerThanThousand() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(2, stringCalculator.add("2,1000"),"Numbers bigger than 1000 should be ignored.");
    }

    @Test
    public void addForDifferentSizeDelimiter() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("//[***]\n1***2"));
    }

    @Test
    public void addForMultipleDelimiter() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("//[*][%]\n1%2"));
    }

}
