package com.test;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


public class RestaTest {
    
    private Calculadora calculadora;
    
    @Before
    public void setUp() {
        calculadora = new Calculadora();
    }
    
    @Test
    public void testRestaPositivos() {
        int a = 10;
        int b = 3;
        int esperado = 7;
        
        int resultado = calculadora.restar(a, b);
        
        assertEquals("La resta de números positivos debe ser correcta", 
                    esperado, resultado);
    }
    
    @Test
    public void testRestaNegativos() {
        int a = -5;
        int b = -3;
        int esperado = -2;
        
        int resultado = calculadora.restar(a, b);
        
        assertEquals("La resta de números negativos debe ser correcta", 
                    esperado, resultado);
    }
    
    @Test
    public void testRestaResultadoNegativo() {
        int a = 3;
        int b = 10;
        int esperado = -7;
        
        int resultado = calculadora.restar(a, b);
        
        assertEquals("La resta que resulta negativa debe ser correcta", 
                    esperado, resultado);
    }
    
    @Test
    public void testRestaCero() {
        int a = 5;
        int b = 5;
        int esperado = 0;
        
        int resultado = calculadora.restar(a, b);
        
        assertEquals("La resta que resulta en cero debe ser correcta", 
                    esperado, resultado);
    }
}
