# Multi-stage build para optimizar tamaño
FROM openjdk:11-jdk-slim as builder

# Directorio de trabajo
WORKDIR /app

# Copiar archivos de configuración Maven
COPY pom.xml .
COPY src ./src

# Instalar Maven y construir la aplicación
RUN apt-get update && apt-get install -y maven && apt-get clean
RUN mvn clean package -DskipTests

# Stage final - solo runtime
FROM openjdk:11-jre-slim

# Instalar curl para health checks
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

# Crear usuario no-root por seguridad
RUN groupadd -r appuser && useradd -r -g appuser appuser

# Directorio de trabajo
WORKDIR /app

# Copiar JAR desde builder stage
COPY --from=builder /app/target/test-automation-1.0-SNAPSHOT.jar app.jar

# Cambiar ownership
RUN chown -R appuser:appuser /app
USER appuser

# Puerto que expone la aplicación
EXPOSE 8080

# Health check
HEALTHCHECK --interval=30s --timeout=10s --start-period=5s --retries=3 \
    CMD curl -f http://localhost:8080/health || exit 1

# Variables de entorno
ENV JAVA_OPTS="-Xmx256m -Xms128m"
ENV SERVER_PORT=8080

# Comando de inicio
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Dserver.port=$SERVER_PORT -jar app.jar"]