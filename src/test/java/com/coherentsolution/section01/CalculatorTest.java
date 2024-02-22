package com.coherentsolution.section01;

import com.coherentsolution.section01.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        // This method is run before each test. It's used to set up the test environment.
        calculator = new Calculator();
    }

    @Test
    void testAddition() {
        // Test method to check the addition functionality
        assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5");
    }

    @Test
    void testSubtraction() {
        // Test method to check the subtraction functionality
        assertEquals(1, calculator.subtract(4, 3), "4 - 3 should equal 1");
    }
}

