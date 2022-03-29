package com.example14.example14.controller;

import com.example14.example14.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;
    public CalculatorController (CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    @GetMapping
    public String showHello () {
        return "Добро пожаловать в калькулятор";
    }

    private String generateMassage (int num1, int num2, String action, int result) {
        return String.format("%d %s %d = %d", num1, action, num2, result);
    }
    @GetMapping("/plus")
    public String sum (@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.sum(num1,num2);
        return generateMassage(num1,num2,"+", result);
    }
    @GetMapping ("/minus")
    public String subtraction (@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.subtraction(num1,num2);
        return generateMassage(num1,num2,"-", result);
    }
    @GetMapping ("/multiply")
    public String multiplication (@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.multiplication(num1,num2);
        return generateMassage(num1,num2,"*", result);
    }
    @GetMapping ("/divide")
    public String division (@RequestParam int num1, @RequestParam int num2) {
        if (num2 == 0) {
            return "Деление на 0 невозможно";
        }
        int result = calculatorService.division(num1,num2);
        return generateMassage(num1,num2,"/", result);
    }
}
