package com.example14.example14.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int subtraction(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int multiplication(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int division(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("You cannot divide by zero!");
        }
        return num1 / num2;
    }
}