package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
    Calculator calc = new Calculator();
    
    @Test
    public void testAdd() {
        assertEquals(4, calc.add(2, 2));
    }
    
    @Test
    public void testSubtract() {
        assertEquals(2, calc.subtract(4, 2));
    }
    
    @Test
    public void testMultiply() {
        assertEquals(6, calc.multiply(2, 3));
    }
    
    @Test
    public void testDivide() {
        assertEquals(2.0, calc.divide(4, 2), 0.0001);
    }
}