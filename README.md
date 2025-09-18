proyecto de automatización de pruebas EXAMEN
Fuente: Material de estudio y respuestas unidad 1 al 6.

Objetivos.
Implementar integración continua para un proyecto de Java con Maven y pruebas automatizadas.
Configurar Pipeline en github actions para compilación y ejecución automatica de test.
Garantizar trazabilidad y control de versiones en git.

Comandos utilizados:
git init (iniciar)
git add . (añadir)
git commit -m (Comentarios)
git branch -M main (Subir a raiz principal)
git remote add origin <url-repositorio> (Subir al repositorio)
git push -u origin main (Subir en origen)
mvn clean compile (Compila repositorio)
mvn test ( pruebas unitarias)
mvn surefire-report:report ( genera reportes)

Comandos adicionales implementados:
mvn failsafe:integration-test (Ejecuta pruebas de integración)
mvn jacoco:report (Genera reportes de cobertura de código)
mvn clean package (Compila y empaqueta la aplicación)
docker build -t calculadora-app . (Construye imagen Docker)
docker run -d --name app -p 8090:8080 calculadora-app (Ejecuta contenedor)
docker ps (Lista contenedores activos)
docker logs <container-name> (Muestra logs del contenedor)

Archivos clave y breve explicación
pom.xml: Define dependencias Maven y configuración del proyecto
src/main/java: Código fuente principal (Calculadora.java, Application.java)
src/test/java: Tests unitarios (CalculadoraTest.java, IntegrationTest.java, AcceptanceTest.java)
.github/workflows/ci.yml: Configuración del pipeline de CI/CD
README.md: Documentación del proyecto en este caso objetivos, comandos utilizados, archivos clave, etc.
.gitignore: Archivos excluidos del control de versiones
Dockerfile: Configuración para containerización de la aplicación
src/main/resources/application.properties: Configuración de Spring Boot

Descripción del pipeline de CI/CD
El pipeline de github actions ejecuta las siguentes etapas automaticamente:

Etapa de Testing:
SETUP en donde esta configura java y cache de Maven, Build ejecuta mvn clean compile para compilar el repositorio, mvn test para correr las pruebas unitarias, mvn failsafe:integration-test para pruebas de integración, report para generar los reportes de cobertura con JaCoCo.

Etapa de Containerización:
Build de imagen Docker usando Dockerfile multi-stage, ejecución de contenedor para testing, health checks automáticos para verificar estado de la aplicación.

Etapa de Deployment:
Deploy a ambiente staging usando Docker, ejecución de acceptance tests contra la aplicación deployada, simulación de Blue-Green deployment con dos ambientes paralelos, testing de capacidad de rollback automático.

La activación del mismo se activa cada vez que hay un push o pull de la rama main.
Resultado esperado: Logs y reportes visibles en pestaña "Actions", artefactos generados con reportes de cobertura, evidencias de deployment exitoso.

Funcionalidades implementadas:
API REST con Spring Boot:
Aplicación web con endpoints para operaciones matemáticas básicas
Health check endpoint para monitoreo
Manejo de errores y validaciones

Testing comprehensivo:
Pruebas unitarias con 100% de cobertura
Pruebas de integración para validar componentes
Acceptance tests para validar funcionalidad end-to-end

Deployment automatizado:
Containerización con Docker
Blue-Green deployment para zero-downtime
Rollback automático en caso de fallos
Health checks y monitoreo continuo

Como esto beneficia:
Crea ramas feature para nuevas funcionalidades, escribir commits con mensajes descriptivos. Creación de pull para revisiones y se asegura que pase todos los test. Deployment automatizado reduce errores manuales. Rollback automático garantiza disponibilidad del servicio. Reportes de cobertura aseguran calidad del código. Trazabilidad completa desde código hasta producción.

Estructura final del proyecto:
text
proyecto-automatizacion/
├── src/main/java/com/test/
├── src/test/java/com/test/
├── .github/workflows/ci.yml
├── Dockerfile
├── pom.xml
└── README.md
URLs de testing:
Aplicación principal: http://localhost:8090

Health check: http://localhost:8090/health

Operaciones matemáticas: http://localhost:8090/sumar?a=5&b=3