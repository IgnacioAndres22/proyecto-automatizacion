package com.test;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


public class SumaTest {
    
    private Calculadora calculadora;
    
    @Before
    public void setUp() {
        calculadora = new Calculadora();
    }
    
    @Test
    public void testSumaPositivos() {
        int a = 5;
        int b = 3;
        int esperado = 8;
        
        int resultado = calculadora.sumar(a, b);
        
        assertEquals("La suma de números positivos debe ser correcta", 
                    esperado, resultado);
    }
    
    @Test
    public void testSumaNegativos() {
        int a = -5;
        int b = -3;
        int esperado = -8;
        
        int resultado = calculadora.sumar(a, b);
        
        assertEquals("La suma de números negativos debe ser correcta", 
                    esperado, resultado);
    }
    
    @Test
    public void testSumaCero() {
        int a = 0;
        int b = 5;
        int esperado = 5;
        
        int resultado = calculadora.sumar(a, b);
        
        assertEquals("La suma con cero debe ser correcta", 
                    esperado, resultado);
    }
    
    @Test
    public void testSumaMixta() {
        int a = 10;
        int b = -4;
        int esperado = 6;
        
        int resultado = calculadora.sumar(a, b);
        
        assertEquals("La suma de números mixtos debe ser correcta", 
                    esperado, resultado);
    }
}
