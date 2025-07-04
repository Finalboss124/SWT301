import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import baolt.example.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    static Calculator calculator;

    @BeforeAll
    static void initAll() {
        calculator = new Calculator();
    }

    @AfterAll
    static void cleanupAll() {
        calculator = null;
    }

    @DisplayName("Kiểm tra phép cộng với hai số dương")
    @Test
    void testAddition() {
        assertEquals(5, calculator.add(2, 3), "Addition should return 5");
    }

    @DisplayName("Kiểm tra phép chia bình thường")
    @Test
    void testDivide() {
        assertEquals(2, calculator.divide(6, 3), "6 / 3 should return 2");
    }

    @DisplayName("Kiểm tra chia cho 0 ném IllegalArgumentException")
    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @DisplayName("Kiểm tra phép nhân từ file CSV")
    @ParameterizedTest(name = "Test {index} => {0} * {1} = {2}")
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void testMultiplyFromFile(int a, int b, int expected) {
        int result = calculator.multiply(a, b);
        assertEquals(expected, result, () -> a + " * " + b + " should be " + expected);
    }

}