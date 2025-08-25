package com.example.calculator;

import com.example.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTests {
    private final CalculatorService svc = new CalculatorService();

    @Test
    void addWorks() {
        assertEquals(7.0, svc.add(3,4));
    }

    @Test
    void subWorks() {
        assertEquals(1.5, svc.subtract(3.5,2.0));
    }

    @Test
    void mulWorks() {
        assertEquals(12.0, svc.multiply(3,4));
    }

    @Test
    void divWorks() {
        assertEquals(2.5, svc.divide(5,2));
    }

    @Test
    void divByZeroThrows() {
        assertThrows(IllegalArgumentException.class, () -> svc.divide(1,0));
    }
}
