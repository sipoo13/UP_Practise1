package com.example.practise1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {
    private static final double USD_TO_RUB = 92.16;
    private static final double EUR_TO_RUB = 99.28;

    @GetMapping("/converter")
    public String getConverter() {
        return "converter";
    }

    @PostMapping("/currency-converter")
    public String convertCurrency(@RequestParam("fromCurrency") String fromCurrency, @RequestParam("toCurrency") String toCurrency, @RequestParam("amount") double amount,Model model) {
        double result = convert(amount, fromCurrency, toCurrency);
        model.addAttribute("currency_result", result);
        return "converter_result";
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        double result = 0.0;
        if (fromCurrency.equals("RUB") && toCurrency.equals("USD")) {
            result = amount / USD_TO_RUB;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("RUB")) {
            result = amount * USD_TO_RUB;
        } else if (fromCurrency.equals("RUB") && toCurrency.equals("EUR")) {
            result = amount / EUR_TO_RUB;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("RUB")) {
            result = amount * EUR_TO_RUB;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            double rubAmount = amount * USD_TO_RUB;
            result = rubAmount / EUR_TO_RUB;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            double rubAmount = amount * EUR_TO_RUB;
            result = rubAmount / USD_TO_RUB;
        }
        return result;
    }
}
