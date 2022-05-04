package com.example14.example14;

import com.example14.example14.service.CalculatorServiceImpl;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceTest {
    private final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
    public int numPositive1 = 5;
    public int numPositive2 = 4;
    public int numNegative1 = -10;
    public int numNegative2 = -9;
    public int numNull = 0;

    @Test
    public void sumCalculator() {
        int actualResult = calculatorService.sum(numPositive1, numPositive2);
        int expectedResult = 9;
        assertEquals(expectedResult, actualResult);
        actualResult = calculatorService.sum(numNegative1, numNegative2);
        expectedResult = -19;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void subtractionCalculator() {
        int actualResult = calculatorService.subtraction(numPositive1, numPositive2);
        int expectedResult = 1;
        assertEquals(expectedResult, actualResult);
        actualResult = calculatorService.subtraction(numNegative1, numNegative2);
        expectedResult = -1;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void multiplicationCalculator() {
        int actualResult = calculatorService.multiplication(numPositive1, numPositive2);
        int expectedResult = 20;
        assertEquals(expectedResult, actualResult);
        actualResult = calculatorService.multiplication(numNegative1, numNegative2);
        expectedResult = 90;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void divideCalculator() {
        int actualResult = calculatorService.division(numPositive1, numPositive2);
        int expectedResult = 1;
        assertEquals(expectedResult, actualResult);
        actualResult = calculatorService.division(numNegative1, numNegative2);
        expectedResult = 1;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void divideCalculatorByNullError() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.division(numNegative1, numNull));
        assertThrows(IllegalArgumentException.class, () -> calculatorService.division(numPositive1, numNull));
    }
}