package com.test;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la funcionalidad de suma
 * Cada test es atómico e independiente
 */
public class SumaTest {
    
    private Calculadora calculadora;
    
    @Before
    public void setUp() {
        // Configuración antes de cada test
        calculadora = new Calculadora();
    }
    
    @Test
    public void testSumaPositivos() {
        // Arrange
        int a = 5;
        int b = 3;
        int esperado = 8;
        
        // Act
        int resultado = calculadora.sumar(a, b);
        
        // Assert
        assertEquals("La suma de números positivos debe ser correcta", 
                    esperado, resultado);
    }
    
    @Test
    public void testSumaNegativos() {
        // Arrange
        int a = -5;
        int b = -3;
        int esperado = -8;
        
        // Act
        int resultado = calculadora.sumar(a, b);
        
        // Assert
        assertEquals("La suma de números negativos debe ser correcta", 
                    esperado, resultado);
    }
    
    @Test
    public void testSumaCero() {
        // Arrange
        int a = 0;
        int b = 5;
        int esperado = 5;
        
        // Act
        int resultado = calculadora.sumar(a, b);
        
        // Assert
        assertEquals("La suma con cero debe ser correcta", 
                    esperado, resultado);
    }
    
    @Test
    public void testSumaMixta() {
        // Arrange
        int a = 10;
        int b = -4;
        int esperado = 6;
        
        // Act
        int resultado = calculadora.sumar(a, b);
        
        // Assert
        assertEquals("La suma de números mixtos debe ser correcta", 
                    esperado, resultado);
    }
}
