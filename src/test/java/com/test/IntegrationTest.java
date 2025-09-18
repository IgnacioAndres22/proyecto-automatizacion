package com.test;

import org.junit.Test;
import static org.junit.Assert.*;

public class IntegrationTest {
    
    @Test
    public void testIntegracionCompleta() {
        Calculadora calc = new Calculadora();
        
        int resultado1 = calc.sumar(calc.multiplicar(2, 3), 4); // (2*3) + 4 = 10
        assertEquals(10, resultado1);
        
        int resultado2 = calc.restar(calc.dividir(10, 2), 3); // (10/2) - 3 = 2
        assertEquals(2, resultado2);
        
        assertTrue("Integración debe funcionar", true);
    }
    
    @Test
    public void testFlujoCalculadoraCompleto() {
        Calculadora calc = new Calculadora();
        
        int base = calc.sumar(5, 5);              // 10
        int multiplicado = calc.multiplicar(base, 2);   // 20
        int dividido = calc.dividir(multiplicado, 4);   // 5
        int final_result = calc.restar(dividido, 1);    // 4
        
        assertEquals("Flujo completo debe dar 4", 4, final_result);
    }
    
    @Test
    public void testRobustezCalculadora() {
        Calculadora calc = new Calculadora();
        
        assertEquals(2000000, calc.multiplicar(1000, 2000));
        
        assertEquals(-15, calc.sumar(-10, -5));
        assertEquals(-6, calc.multiplicar(-2, 3));
        assertEquals(2, calc.dividir(-8, -4));
        
        int a = 15, b = 3;
        assertEquals(a, calc.dividir(calc.multiplicar(a, b), b));
    }
    
    @Test
    public void testManejoExcepcionesIntegracion() {
        Calculadora calc = new Calculadora();
        
        try {
            int cero = calc.restar(5, 5); // 0
            calc.dividir(10, cero); // Debe lanzar excepción
            fail("Debería haber lanzado excepción");
        } catch (IllegalArgumentException e) {
            assertEquals("No se puede dividir por cero", e.getMessage());
        }
    }
}
