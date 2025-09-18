package com.test;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculadoraTest {
    
    @Test
    public void testSumar() {
        Calculadora calc = new Calculadora();
        assertEquals(5, calc.sumar(2, 3));
        assertEquals(0, calc.sumar(-1, 1));
        assertEquals(-5, calc.sumar(-2, -3));
    }
    
    @Test
    public void testRestar() {
        Calculadora calc = new Calculadora();
        assertEquals(1, calc.restar(3, 2));
        assertEquals(-1, calc.restar(2, 3));
        assertEquals(0, calc.restar(5, 5));
    }
    
    @Test
    public void testMultiplicar() {
        Calculadora calc = new Calculadora();
        assertEquals(6, calc.multiplicar(2, 3));
        assertEquals(0, calc.multiplicar(0, 5));
        assertEquals(-10, calc.multiplicar(-2, 5));
        assertEquals(25, calc.multiplicar(5, 5));
    }
    
    @Test
    public void testDividir() {
        Calculadora calc = new Calculadora();
        assertEquals(2, calc.dividir(6, 3));
        assertEquals(5, calc.dividir(10, 2));
        assertEquals(-3, calc.dividir(-9, 3));
        assertEquals(1, calc.dividir(7, 7));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testDividirPorCero() {
        Calculadora calc = new Calculadora();
        calc.dividir(10, 0); 
    }
    
    @Test
    public void testMensajeDivisionPorCero() {
        Calculadora calc = new Calculadora();
        
        try {
            calc.dividir(10, 0);
            fail("Debería haber lanzado IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("No se puede dividir por cero", e.getMessage());
        }
    }
}
