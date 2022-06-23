package com.example.calc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    public void beforeEach() {
        calculator = new Calculator();
    }

    @Test
    public void addTest() {
        // Prepare Test Data
        int n1 = 12;
        int n2 = 13;
        int expected = 25;
        // Act ==> call the real function with Test Data
        int actual = calculator.add(n1, n2);
        // Assert ==> verify outcome
        assertEquals(expected, actual);
    }

    @Test
    public void subTest() {
        int n1 = 12;
        int n2 = 13;
        int expected = -1;
        // Act
        int actual = calculator.sub(n1, n2);
        // Assert
        assertEquals(expected, actual);
    }


    @Test
    public void divTestWithException(){
        int n1 = 12;
        int n2 = 0;
        Exception e=assertThrows(ArithmeticException.class, ()->{
            calculator.div(n1,n2);
        });
        assertEquals("/ by zero", e.getMessage());
    }


}
