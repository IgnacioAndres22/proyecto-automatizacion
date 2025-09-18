package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
    
    private final Calculadora calculadora = new Calculadora();
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
@GetMapping("/")
public String home() {
    return "<h1>Calculadora API - Examen Automatización</h1>" +
           "<h2>Endpoints disponibles:</h2>" +
           "<ul>" +
           "<li><a href=\"/health\">/health</a> - Health check</li>" +
           "<li><a href=\"/sumar?a=5&b=3\">/sumar?a=5&b=3</a> - Sumar dos números</li>" +
           "<li><a href=\"/restar?a=8&b=3\">/restar?a=8&b=3</a> - Restar dos números</li>" +
           "<li><a href=\"/multiplicar?a=4&b=7\">/multiplicar?a=4&b=7</a> - Multiplicar dos números</li>" +
           "<li><a href=\"/dividir?a=10&b=2\">/dividir?a=10&b=2</a> - Dividir dos números</li>" +
           "<li><a href=\"/dividir?a=10&b=0\">/dividir?a=10&b=0</a> - Probar división por cero</li>" +
           "</ul>" +
           "<p><strong>Versión:</strong> 1.0.0</p>" +
           "<p><strong>Estudiante:</strong> Ignacio Castro Espinoza</p>" +
           "<hr>" +
           "<h3> Enlaces de prueba rápida:</h3>" +
           "<p>" +
           "<a href=\"/sumar?a=15&b=25\" style=\"margin-right:10px;\">Suma: 15+25</a> | " +
           "<a href=\"/multiplicar?a=6&b=9\" style=\"margin-right:10px;\">Multiplicación: 6×9</a> | " +
           "<a href=\"/dividir?a=20&b=4\" style=\"margin-right:10px;\">División: 20÷4</a>" +
           "</p>";
}
    
    @GetMapping("/health")
    public String health() {
        return "OK - Aplicación funcionando correctamente";
    }
    
    @GetMapping("/sumar")
    public String sumar(@RequestParam int a, @RequestParam int b) {
        int resultado = calculadora.sumar(a, b);
        return String.format("Resultado: %d + %d = %d", a, b, resultado);
    }
    
    @GetMapping("/restar")
    public String restar(@RequestParam int a, @RequestParam int b) {
        int resultado = calculadora.restar(a, b);
        return String.format("Resultado: %d - %d = %d", a, b, resultado);
    }
    
    @GetMapping("/multiplicar")
    public String multiplicar(@RequestParam int a, @RequestParam int b) {
        int resultado = calculadora.multiplicar(a, b);
        return String.format("Resultado: %d × %d = %d", a, b, resultado);
    }
    
    @GetMapping("/dividir")
    public String dividir(@RequestParam int a, @RequestParam int b) {
        try {
            int resultado = calculadora.dividir(a, b);
            return String.format("Resultado: %d ÷ %d = %d", a, b, resultado);
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }
}
