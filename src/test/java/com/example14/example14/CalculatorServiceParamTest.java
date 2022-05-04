package com.example14.example14;

import com.example14.example14.service.CalculatorServiceImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceParamTest {
    public final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

    public static Stream<Arguments> provideParamsForSum() {
        return Stream.of(
                Arguments.of(4, 5, 9),
                Arguments.of(-9, -10, -19)
        );
    }

    public static Stream<Arguments> provideParamsForSubtraction() {
        return Stream.of(
                Arguments.of(4, 5, -1),
                Arguments.of(-9, -10, 1)
        );
    }

    public static Stream<Arguments> provideParamsForMultiplication() {
        return Stream.of(
                Arguments.of(4, 5, 20),
                Arguments.of(-9, -10, 90)
        );
    }

    public static Stream<Arguments> provideParamsForDivision() {
        return Stream.of(
                Arguments.of(4, 5, 0),
                Arguments.of(-20, -10, 2),
                Arguments.of(5, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForSum")
    public void sumCalculatorTest(int num1, int num2, int expected) {
        int result = calculatorService.sum(num1, num2);
        assertEquals(result, expected);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForSubtraction")
    public void subtractionCalculatorTest(int num1, int num2, int expected) {
        int result = calculatorService.subtraction(num1, num2);
        assertEquals(result, expected);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMultiplication")
    public void multiplicationCalculatorTest(int num1, int num2, int expected) {
        int result = calculatorService.multiplication(num1, num2);
        assertEquals(result, expected);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForDivision")
    public void divideCalculator(int num1, int num2, int expected) {
        if (num2 == 0) {
            assertThrows(IllegalArgumentException.class, () -> calculatorService.division(num1, num2));
        } else {
            int result = calculatorService.division(num1, num2);
            assertEquals(result, expected);
        }
    }
}