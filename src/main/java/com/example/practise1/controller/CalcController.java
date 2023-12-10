package com.example.practise1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {
    @GetMapping("/calcPage")
    public String getCalc() {
        return "calc";
    }

    @PostMapping("/calc")
    public String calculate(@RequestParam("num1") int num1, @RequestParam("num2") int num2, @RequestParam("operation") String operation, Model model) {
        int result = calc(num1, num2, operation);
        model.addAttribute("calc_result", result);
        return "calc_result";
    }

    private int calc(int num1, int num2, String operation) {
        int result;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
        return result;
    }
}
