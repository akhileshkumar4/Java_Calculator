package com.example.calculator.controller;


import com.example.calculator.service.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CalculatorController {


    private final CalculatorService service;


    public CalculatorController(CalculatorService service) {
        this.service = service;
    }


    @GetMapping("/")
    public String index() {
        return "index"; // templates/index.html
    }


    @PostMapping("/calc")
    public String calculate(@RequestParam("a") double a,
                            @RequestParam("b") double b,
                            @RequestParam("op") String op,
                            Model model) {
        double result;
        try {
            switch (op) {
                case "add" -> result = service.add(a, b);
                case "sub" -> result = service.subtract(a, b);
                case "mul" -> result = service.multiply(a, b);
                case "div" -> result = service.divide(a, b);
                case "pow" -> result = service.power(a, b);
                default -> throw new IllegalArgumentException("Unknown operation: " + op);
            }
            model.addAttribute("result", result);
            model.addAttribute("error", null);
        } catch (Exception e) {
            model.addAttribute("result", null);
            model.addAttribute("error", e.getMessage());
        }
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("op", op);
        return "index";
    }
}