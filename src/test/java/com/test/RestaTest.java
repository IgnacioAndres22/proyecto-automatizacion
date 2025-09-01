package com.test;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la funcionalidad de resta
 * Cada test es atómico e independiente
 */
public class RestaTest {
    
    private Calculadora calculadora;
    
    @Before
    public void setUp() {
        // Configuración antes de cada test
        calculadora = new Calculadora();
    }
    
    @Test
    public void testRestaPositivos() {
        // Arrange
        int a = 10;
        int b = 3;
        int esperado = 7;
        
        // Act
        int resultado = calculadora.restar(a, b);
        
        // Assert
        assertEquals("La resta de números positivos debe ser correcta", 
                    esperado, resultado);
    }
    
    @Test
    public void testRestaNegativos() {
        // Arrange
        int a = -5;
        int b = -3;
        int esperado = -2;
        
        // Act
        int resultado = calculadora.restar(a, b);
        
        // Assert
        assertEquals("La resta de números negativos debe ser correcta", 
                    esperado, resultado);
    }
    
    @Test
    public void testRestaResultadoNegativo() {
        // Arrange
        int a = 3;
        int b = 10;
        int esperado = -7;
        
        // Act
        int resultado = calculadora.restar(a, b);
        
        // Assert
        assertEquals("La resta que resulta negativa debe ser correcta", 
                    esperado, resultado);
    }
    
    @Test
    public void testRestaCero() {
        // Arrange
        int a = 5;
        int b = 5;
        int esperado = 0;
        
        // Act
        int resultado = calculadora.restar(a, b);
        
        // Assert
        assertEquals("La resta que resulta en cero debe ser correcta", 
                    esperado, resultado);
    }
}
